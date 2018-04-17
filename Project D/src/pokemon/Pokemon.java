package pokemon;

import java.util.Random;

import misc.*;
import moves.Move;

public abstract class Pokemon {
	final private double STAB_MODIFIER = 1.5;
	
	final private Type typeA, typeB;
	private boolean knockedOut = false;
	private Move[] moveList, moveLearnset;
	private int[] ivList, baseStatList, statList;
	private int level, accuracy, evasion;
	private String name;
	private StatusEffect status = StatusEffect.NOTHING;
	
	/**
	 * 
	 * @param baseStatList: Base stats in order: HP, Atk, Def, SpAtk, SpDef, Speed
	 * @param level: What level is the Pokemon?
	 * @param typeA: The main or first type of the Pokemon
	 * @param typeB: The optional secondary type of Pokemon
	 * @param moveLearnset: What moves will this Pokemon learn?
	 */
	public Pokemon(int[] baseStatList, int level, Type typeA, Type typeB, Move[] moveLearnset, String name) {
		this.name = name;
		
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
	
	public boolean levelUp() {
		if (this.level < 50) {
			this.level++;
			
			for (Move newMove : this.moveLearnset) {
				if (newMove.getLearnLevel() == this.level) {
					//TODO Decide if this pokemon should learn the new move
				}
			}
			
			this.resetStats();
			return true;
		} else {
			return false;
		}
		
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
		
		
	}
	
	public int calculateStat(int statID) {
		return calculateStat(this.statList[statID], this.ivList[statID], this.level, statID == 0);
	}
	
	private int calculateStat(int base, int iv, int level, boolean isHP) {
		int stat = 2*(base + iv) * level / 100 + level + 5;
		if (isHP) {
			stat += 5;
		}
		return stat;
	}
	

	public void doDamageTo(Pokemon opponent, int power, Type type, boolean specialAttack) {
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
		if (opponent.getSpeed()/2 >= generator.nextInt(256)) {
			modifier *= 2;
			System.out.println("Critical Hit!");
		}
		
		//Get STAB bonus
		modifier *= this.getSTAB(type);
		
		//Calculate damage based on modifier and stats
		int damage;
		if (specialAttack) {
			damage = (int) Math.round((((2*this.level)/5 + 2)/50 * power * opponent.getSpAtk() * this.getSpDef() + 2) * modifier);
		} else {
			damage = (int) Math.round((((2*this.level)/5 + 2)/50 * power * opponent.getAtk() * this.getDef() + 2) * modifier);
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
	
	public int getDef() {
		return statList[1];
	}

	public int getAtk() {
		return statList[2];
	}

	public int getSpDef() {
		return statList[3];
	}

	public int getSpAtk() {
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
		if (modifier <= -2) {
			modifier = 2/4;
		} else if (modifier < 0) {
			modifier = 2/3;
		} else if (modifier == 0) {
			modifier = 1/1;
		} else if (modifier <= 1) {
			modifier = 3/2;
		}
		
		
		
		if (statID < 6) {
			this.statList[statID] *= modifier;
		} else if (statID == 6) {
			this.accuracy *= modifier;
		} else if (statID == 7) {
			this.evasion *= modifier;
		}
	}
	
}
