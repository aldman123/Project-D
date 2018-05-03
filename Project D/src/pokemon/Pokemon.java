package pokemon;

import java.util.Random;
import java.util.Scanner;

import misc.*;
import moves.Move;

public abstract class Pokemon {
	private final double STAB_MODIFIER = 1.5;
	private final Type typeA, typeB;
	private final Experience experienceType;
	private boolean knockedOut = false;
	private Move[] moveList, moveLearnset;
	private int[] ivList, baseStatList, statList;
	private int level, accuracy, evasion, experiencePoints, baseExperienceYield;
	private double criticalHit;
	private String name;
	private StatusEffect status = StatusEffect.NOTHING;

	/**
	 * 
	 * @param baseStatList: Base stats in order: HP, Atk, Def, SpAtk, SpDef, Speed
	 * @param level: What level is the Pokemon?
	 * @param typeA: The main or first type of the Pokemon
	 * @param typeB: The optional secondary type of Pokemon
	 * @param moveLearnset: What moves will this Pokemon learn?
	 * @param experienceType: How quickly does this Pokemon level up?
	 */
	public Pokemon(int[] baseStatList, int level, Type typeA, Type typeB, Move[] moveLearnset, String name, Experience experienceType) {
		this.name = name;
		this.experienceType = experienceType;
		this.baseExperienceYield = 50;
		if (typeB == null) {
			typeB = typeA;
		}
		this.level = level;
		this.typeA = typeA;
		this.typeB = typeB;

		this.baseStatList = baseStatList;
		this.statList = new int[6];
		this.ivList = new int[6];

		Random generator = new Random();

		for (int i = 0; i < ivList.length; i++) {
			ivList[i] = generator.nextInt(16);
		}

		moveList = new Move[4];
		this.moveLearnset = moveLearnset.clone();

		//Learn's it's 4 most recent moves based on level
		int moveSlot = 0;
		for (int i = moveLearnset.length - 1; i >= 0 && moveSlot < 4; i--) {
			if (moveList[moveSlot] == null) {
				if (moveLearnset[i].getLearnLevel() <= this.level) {
					moveList[moveSlot] = moveLearnset[i];
					moveSlot++;
				}
			} else {
				moveSlot++;
			}
		}

		this.resetStats();

	}

	public void setBaseExperienceYield(int experience) {
		this.baseExperienceYield = experience;
	}

	public int getBaseExperienceYield() {
		return this.baseExperienceYield;
	}

	public Pokemon addExperience(int experiencePoints) {
		System.out.println(this.name + " gained " + experiencePoints + " xp!");
		this.experiencePoints += experiencePoints;
		if (this.experiencePoints >= this.experienceType.getExperienceToLevelUp(this.level+1)) {
			return this.levelUp();
		}
		
		return this;
	}
	/**
	 * This is terrible code, but because of how I designed the class system,
	 * I need to do it this way. It makes me sad. -Alexander
	 * @return A new version of the Pokemon
	 */
	private Pokemon levelUp() {
		if (this.level < 50) {
			this.level++;
			
			if (this instanceof EvolveablePokemon) {
				EvolveablePokemon me = (EvolveablePokemon) this;
				if (me.getEvolveLevel() <= level) {
					try {
						me = (EvolveablePokemon) me.getEvolution().newInstance();
						me.inputInheritedTraits(this.level, this.moveList, this.name, this.experiencePoints);
						return (Pokemon) me;
					} catch (InstantiationException e) {
						System.out.println("Error in evolution");
						System.out.println(e.getMessage());
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						System.out.println("Error in evolution");
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}

			for (Move newMove : this.moveLearnset) {
				if (newMove.getLearnLevel() == this.level) {
					learnMove(newMove);
				}
			}

			this.resetStats();
		}
		return this;

	}

	public int getLevel() {
		return this.level;
	}

	public void resetStats() {
		for (int i = 0; i < statList.length; i++) {
			statList[i] = calculateStat(i);
		}
		this.accuracy = 1;
		this.evasion = 1;
		this.criticalHit = 1;

	}

	protected void learnMove(Move move) {
		for (int i = 0; i < 4; i++) {
			if (moveList[i] == null) {
				moveList[i] = move;
				System.out.println(this.name.toUpperCase() + " leaned " + move.getName().toUpperCase() + "!");
				return;
			}
		}

		System.out.println(this.getName() + " has already learned four moves!");
		Scanner input = new Scanner(System.in);

		boolean invalidInput = true;
		int selectedMoveToDelete = -1;
		while (invalidInput) {
			System.out.println(moveList);
			System.out.println("Please Select a Move to replace");
			System.out.println("To stop learning " + move.getName().toUpperCase() + ", input: 0");
			if (input.hasNextInt()) {
				selectedMoveToDelete = input.nextInt();
				for (int i = 0; i < 5; i++) {
					if (i == selectedMoveToDelete) {
						invalidInput = false;
					}
				}
			}
		}
		input.close();
		System.out.println(this.getName() + " forgot " + this.moveList[selectedMoveToDelete - 1].getName() + ", and learned " + move.getName() + "!");
		this.moveList[selectedMoveToDelete - 1] = move;


	}

	public int calculateStat(int statID) {
		if (statID == 6) {

		} else if (statID == 7) {

		}
		return calculateStat(this.statList[statID], this.ivList[statID], this.level, statID == 0);
	}

	private int calculateStat(int base, int iv, int level, boolean isHP) {
		int stat = 2*(base + iv) * level / 100 + level + 5;
		if (isHP) {
			stat += 5;
		}
		return stat;
	}

	public void doDamageFrom(Pokemon opponent, Move move) {
		Type type = move.getType();
		int power = move.getPower();
		double modifier = type.against(typeA);

		//Get type effectiveness
		if (typeA != typeB) {
			modifier *= typeB.against(type);
		}

		if (modifier < 1) {
			System.out.println("The move wasn't very effective.");
		} else if (modifier > 1 && modifier <= 2) {
			System.out.println("The move was quite effective!");
		} else if (modifier < 4) {
			System.out.println("The move was super effective!");
		}

		//Critical Hit
		Random generator = new Random();
		double criticalHitMod = 1/2 * this.getCriticalHit();
		if (move.getHighCriticalHit()) {
			criticalHitMod *= 8;
		}

		if (opponent.getSpeed() * criticalHitMod >= generator.nextInt(256)) {
			modifier *= 2;
			System.out.println("Critical Hit!");
		}

		//Get STAB bonus
		modifier *= this.getSTAB(type);

		//Calculate damage based on modifier and stats
		int damage;
		if (move.getSpecialAttack()) {
			damage = (int) Math.round(((2.0*this.level/5.0 + 2.0)/50.0 * power * opponent.getSpAtk() / this.getSpDef() + 2.0) * modifier);
		} else {
			damage = (int) Math.round(((2.0*this.level/5.0 + 2.0)/50.0 * power * opponent.getAtk() / this.getDef() + 2.0) * modifier);
		}
		//Apply damage
		opponent.reduceHP(damage);
		return;
	}

	public void doPoisonDamage() {
		this.reduceHP(this.baseStatList[0] / 8);

	}


	//Same Type Attack Bonus
	public double getSTAB(Type type) {
		if ( (type == this.typeA && typeA != Type.NORMAL) || (typeB == type && typeB != Type.NORMAL) ) {
			return STAB_MODIFIER;
		} else {
			return 1;
		}
	}

	public boolean isKnockedOut() {
		return this.knockedOut;
	}

	public void setMove(Move move, int index) {
		moveList[index] = move;
	}

	public Move getMove(int index) {
		return moveList[index];
	}

	public String toString() {
		return "[" + this.getName() + ", lv:" + level + "]";
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		if (name == null) {
			return "Not Learned";
		} else {
			return this.name;
		}
	}

	public StatusEffect getStatus() {
		return this.status;
	}

	public void setStatus(StatusEffect newStatus) {
		this.status = newStatus;
	}




	public void setHP(int newValue) {
		statList[0] = newValue;
	}

	public void setDef(int newValue) {
		statList[1] = newValue;
	}


	public void setAtk(int newValue) {
		statList[2] = newValue;
	}

	public void setSpDef(int newValue) {
		statList[3] = newValue;
	}

	public void setSpAtk(int newValue) {
		statList[4] = newValue;
	}

	public void setSpeed(int newValue) {
		statList[5] = newValue;
	}

	public void setAccuracy(int newValue) {
		this.accuracy = newValue;
	}

	public void setEvasion(int newValue) {
		this.evasion = newValue;
	}

	public int getHP() {
		return statList[0];
	}

	public int getAtk() {
		return statList[1];
	}

	public int getDef() {
		return statList[2];
	}

	public int getSpAtk() {
		return statList[3];
	}

	public int getSpDef() {
		return statList[4];
	}

	public int getSpeed() {
		return statList[5];
	}

	public int getAccuracy() {
		return this.accuracy;
	}

	public int getEvasion() {
		return this.evasion;
	}

	public double getCriticalHit() {
		return this.criticalHit;
	}

	public void reduceHP(int damage) {
		this.setHP(this.getHP() - damage);
		if (this.getHP() < 1) {
			this.knockedOut = true;
			this.setHP(0);
		}
	}


	public int getMaxHP() {
		return this.calculateStat(0);
	}

	/**
	 * Multiples the stat by the modifier
	 * @param statID
	 * Stats in order: HP, Atk, Def, SpAtk, SpDef, Speed, Accuracy, Evasion
	 * HP = 0, Evasion = 7
	 */
	public void modifyStat(int statID, double modifier) {
		/*
		 * changes stat modifier from stage multiplier to percent
		 * ie: -1 -> 2/3, 0 -> 2/2, +1 -> 3/2 etc.
		 */
		if (modifier > 0) {
			modifier = (modifier + 2) / 2;
		} else {
			modifier = 2 / (modifier * -1 + 2);
		}

		if (statID < 6) {
			this.statList[statID] *= modifier;
		} else if (statID == 6) {
			this.accuracy *= modifier;
		} else if (statID == 7) {
			this.evasion *= modifier;
		} else if (statID == 8) {
			this.criticalHit *= modifier;
		}
	}

	public int getNumberOfMoves() {
		int moves = 4;
		for (int i = 0; i < 4; i++) {
			if (this.getMove(i) == null) {
				moves--;
			}
		}
		return moves;
	}
	
	protected void setExperience(int experience) {
		this.experiencePoints = experience;
		
	}

	protected void setLevel(int level) {
		this.level = level;
		
	}

}
