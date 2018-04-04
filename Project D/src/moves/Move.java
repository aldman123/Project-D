package moves;

import java.util.Random;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move {
	private final int power, accuracy, learnLevel;
	private final String name;
	private final Type type;
	private int pp, maxPP;
	
	
	
	/**
	 * 
	 * @param power: The Power of the move
	 * @param pp: How many times you may use the move
	 * @param accuracy: Likelihood of missing in percent
	 * @param name: The name of the move
	 * @param type: The Type of damage
	 * @param level: When is the move learned?
	 */
	public Move(int power, int pp, int accuracy, String name, Type type, int level) {
		this.power = power;
		this.accuracy = accuracy;
		this.name = name;
		this.type = type;
		this.learnLevel = level;
		this.maxPP = pp;
		this.pp = pp;
	}
	
	/**
	 * This method calculates and applies the effects of the move
	 * @param self: Pokemon performing the move
	 * @param foe:	Opponent Pokemon
	 */
	public void start(Pokemon self, Pokemon foe) {
		self.doDamage(foe, power, type);
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
	
	public int getPower() {
		return power;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getLearnLevel() {
		return learnLevel;
	}
	
}
