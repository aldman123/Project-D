package moves;

import java.util.Random;

import misc.StatusEffect;
import misc.Type;
import pokemon.Pokemon;

public abstract class Move {
	private final int power, accuracy, learnLevel;
	private final String name;
	private final Type type;
	private final boolean specialAttack;
	private int pp, maxPP;
	private boolean highCriticalHit;
	private Random generator = new Random();
	
	
	
	/**
	 * 
	 * @param power: The Power of the move
	 * @param pp: How many times you may use the move
	 * @param accuracy: Likelihood of missing in percent
	 * @param name: The name of the move
	 * @param type: The Type of damage
	 * @param level: When is the move learned?
	 */
	public Move(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack) {
		this.power = power;
		this.accuracy = accuracy;
		this.name = name;
		this.type = type;
		this.learnLevel = level;
		this.maxPP = pp;
		this.pp = pp;
		this.specialAttack = specialAttack;
		this.highCriticalHit = false;
	}
	
	/**
	 * This method calculates and applies the effects of the move
	 * @param self: Pokemon performing the move
	 * @param foe:	Opponent Pokemon
	 */
	public String start(Pokemon self, Pokemon foe) {
		
		if (self.isKnockedOut() || foe.isKnockedOut()) {
			return "";
		} else if (!(this instanceof Move_MultyStrike)) {
			pp--;
		}
		
		if (self.getStatus() == StatusEffect.SLEEP) {
			return self.toString() + " is still Sleeping!";
		} else if (self.getStatus() == StatusEffect.FREEZE) {
			return self.toString() + " is frozen solid!";
		} else if (self.getStatus() == StatusEffect.PARALYSIS) {
			if (generator.nextInt(4) == 1) {
				return self.toString() + " is paralyzed and unable to move!";
			}
		}

		if (power == 0) {
			return self.getName() + " used " + this.name + "!";
		}
		foe.doDamageFrom(self, this);
		return self.getName() + " did damage to " + foe.getName() + "!";

	}
	
	public int getPP() {
		return pp;
	}

	public void setPp(int newPP) {
		this.pp = newPP;
	}
	
	public void resetPP() {
		this.pp = this.maxPP;
	}

	public Type getType() {
		return type;
	}
	
	public String toString() {
		return "[" + name + "]";
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getLearnLevel() {
		return learnLevel;
	}
	
	public void setHighCriticalHit(boolean highCriticalHit) {
		this.highCriticalHit = highCriticalHit;
	}
	
	public boolean getHighCriticalHit() {
		return highCriticalHit;
	}

	public boolean getSpecialAttack() {
		return specialAttack;
	}
}
