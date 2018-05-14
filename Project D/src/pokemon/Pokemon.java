package pokemon;

import java.util.Random;

import misc.*;
import moves.Move;

public abstract class Pokemon implements Cloneable{
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
		this.moveLearnset = moveLearnset;

		//Learn's it's 4 most recent moves based on level
		int moveSlot = 0;
		for (int i = moveLearnset.length - 1; i >= 0 && moveSlot < 4; i--) {
			if (moveList[moveSlot] == null) {
				if (moveLearnset[i].getLearnLevel() <= this.level) {
					moveList[moveSlot] = moveLearnset[i].clone();
					moveSlot++;
				}
			} else {
				moveSlot++;
			}
		}
		this.experiencePoints = experienceType.getExperienceToLevelUp(this.getLevel());
		this.resetStats();

	}

	public void setBaseExperienceYield(int experience) {
		this.baseExperienceYield = experience;
	}

	public int getBaseExperienceYield() {
		return this.baseExperienceYield;
	}

	public int getExperience() {
		return this.experiencePoints;
	}

	public Pokemon addExperience(int experiencePoints) {
		System.out.println(this.name + " gained " + experiencePoints + " xp!");
		this.experiencePoints += experiencePoints;
		while (this.experiencePoints >= this.experienceType.getExperienceToLevelUp(this.level+1)) {
			return this.levelUp();
		}

		return this;
	}
	/**
	 * This is terrible code, but because of how I designed the class system,
	 * I need to do it this way. It makes me sad. -Alexander
	 * @return A new version of the Pokemon
	 */
	protected Pokemon levelUp() {
		System.out.println(this.getName() + " leveled up!");
		if (this.level < 50) {
			this.level++;

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

	private void learnMove(Move move) {
		int oldestMoveIndex = 0;
		for (int i = 0; i < 4; i++) {
			if (moveList[i] == null) {
				moveList[i] = move;
				System.out.println(this.name.toUpperCase() + " learned " + move.getName().toUpperCase() + "!");
				return;
			} else if (moveList[oldestMoveIndex].getLearnLevel() > moveList[i].getLearnLevel()) {
				oldestMoveIndex = i;
			}
		}

		System.out.println(this.getName() + " has already learned four moves!");

		System.out.println(this.getName() + " forgot " + this.moveList[oldestMoveIndex].getName() + ", and learned " + move.getName() + "!");
		this.moveList[oldestMoveIndex] = move;

	}

	private int calculateStat(int statID) {
		if (statID == 6) {			//Accuracy
			return 1;
		} else if (statID == 7) {	//Evasion
			return 1;
		} else if (statID == 8) {	//Critical Hit
			return 1;
		}
		return calculateStat(baseStatList[statID], ivList[statID], level, statID == 0);
	}

	private int calculateStat(int base, int iv, int level, boolean isHP) {
		int stat = (int) (2.0*(base + iv) * level / 100.0 + level + 5.0);
		if (isHP) {
			stat += 5;
		}
		return stat;
	}
	
	public String getStatName(int statIndex) {
		switch (statIndex) {
		case 1:
			return "Attack";
		case 2:
			return "Defence";
		case 3:
			return "Special Attack";
		case 4:
			return "Special Defence";
		case 5:
			return "Speed";
		case 6:
			return "Accuracy";
		case 7:
			return "Evasion";
		case 8:
			return "Critical Hit Ratio";
		default:
			return "Stat";
		}
	}

	public void receiveDamageFrom(Pokemon pokemonAttacking, Move move) {
		Type type = move.getType();
		int power = move.getPower();
		
		//Get type effectiveness
		double modifier = type.against(typeA);
		if (typeA != typeB) {
			modifier *= type.against(typeB);
		}

		if (modifier < 1) {
			System.out.println("The move wasn't very effective.");
		} else if (modifier > 1 && modifier <= 2) {
			System.out.println("The move was quite effective!");
		} else if (modifier > 2) {
			System.out.println("The move was super effective!");
		}

		//Critical Hit
		Random generator = new Random();
		double criticalHitMod = 1/2 * this.getCriticalHit();
		if (move.getHighCriticalHit()) {
			criticalHitMod *= 8;
		}

		if (pokemonAttacking.getSpeed() * criticalHitMod >= generator.nextInt(256)) {
			modifier *= 2;
			System.out.println("Critical Hit!");
		}

		//Get STAB bonus
		modifier *= this.getSTAB(type);

		//Calculate damage based on modifier and stats
		int damage;
		if (move.getSpecialAttack()) {
			damage = (int) Math.round(((2.0*pokemonAttacking.level/5.0 + 2.0)/50.0 * power * pokemonAttacking.getSpAtk() / this.getSpDef() + 2.0) * modifier);
		} else {
			damage = (int) Math.round(((2.0*pokemonAttacking.level/5.0 + 2.0)/50.0 * power * pokemonAttacking.getAtk() / this.getDef() + 2.0) * modifier);
		}

		//Apply damage
		this.reduceHP(damage);
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

	public String getMoveList() {
		String moveList = "[";
		for (int i = 0; i < 4; i++) {
			if (this.getMove(i) != null) {
				if (i > 0) {
					moveList += ", ";
				}
				moveList += this.getMove(i).getName() + " [" + this.getMove(i).getPP() + "]";
			} else {
				break;
			}
		}

		moveList += "]";

		return moveList;
	}

	public String getStatList() {
		String output = "[";
		for (int i = 0; i <= 8; i++) {
			if (this.getStat(i) != -1) {
				if (i > 0) {
					output += ", ";
				}
				output += this.getStat(i);
			} else {
				break;
			}
		}

		return output;
	}

	public String toString() {
		return "[" + this.getName() + ", lv:" + level + "]";
	}
	
	public void displayPokemon() {
		System.out.println(this.toString() + " " + this.getStatus().toString());
		System.out.println("[HP:" + this.getHP() +"/"+ this.getMaxHP() + ", XP:" + this.getExperience() + "]");
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
		return calculateStat(0);
	}

	/**
	 * Multiples the stat by the modifier
	 * @param statID
	 * Stats in order: HP, Atk, Def, SpAtk, SpDef, Speed, Accuracy, Evasion, Critical Hit
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

	/**
	 * 
	 * @param statID The number from 0-8 of the desired stat
	 * @return The stat, or if invalid StatID, returns -1
	 */
	public double getStat(int statID) {
		if (statID < 6) {
			return this.statList[statID];
		} else if (statID == 6) {
			return this.accuracy;
		} else if (statID == 7) {
			return this.evasion;
		} else if (statID == 8) {
			return this.criticalHit;
		} else {
			return -1;
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
	
	
	public abstract String getSpeciesName();
}
