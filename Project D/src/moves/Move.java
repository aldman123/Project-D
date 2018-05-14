package moves;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import misc.StatusEffect;
import misc.Type;
import pokemon.Pokemon;

public abstract class Move {
	private final int accuracy, learnLevel;
	private final String name;
	private final Type type;
	private final boolean specialAttack;
	private int power, pp, maxPP;
	private boolean highCriticalHit, isFast;
	private static Random generator = new Random();

	
	/**
	 * A basic move that deals damage to the other Pokemon
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
		this.isFast = false;
	}
	
	public void doMove(Pokemon self, Pokemon foe) {
		if (self.isKnockedOut() || foe.isKnockedOut()) {
			return;
		}
		
		if (self.getStatus() == StatusEffect.SLEEP) {
			System.out.println(self.getName() + " is still Sleeping!");
			return;
		} else if (self.getStatus() == StatusEffect.FREEZE) {
			System.out.println(self.getName() + " is frozen solid!");
			return;
		} else if (self.getStatus() == StatusEffect.PARALYSIS) {
			if (generator.nextInt(4) == 1) {
				System.out.println(self.getName() + " is paralyzed and unable to move!");
				return;
			}
		}
		
		if (!(this instanceof Move_MultyStrike)) {
			pp--;
		}
		System.out.println(self.getName() + " used " + this.name + "!");
		this.start(self, foe);
	}
	
	/**
	 * This method calculates and applies the effects of the move
	 * @param self: Pokemon performing the move
	 * @param foe:	Opponent Pokemon
	 */
	protected void start(Pokemon self, Pokemon foe) {
		if (power != 0) {
			foe.receiveDamageFrom(self, this);
		}
		return;

	}
	
	/**
	 * Returns a cloned copy of the child class
	 */
	public final Move clone() {
		try {
			return this.getClass().getDeclaredConstructor(int.class).newInstance(this.getLearnLevel());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
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
	
	protected void setFast(boolean isFast) {
		this.isFast = isFast;
	}
	
	public boolean isFast() {
		return this.isFast;
	}
	
	public void setPower(int newPower) {
		this.power = newPower;
	}
}
