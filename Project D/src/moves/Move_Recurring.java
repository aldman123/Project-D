package moves;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_Recurring extends Move {
	
	private int maxTurns, numberOfRepetitions;
	
	/**
	 * 
	 * @param maxTurns The maximum number of turns that this effect will last
	 */
	public Move_Recurring(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack, int maxTurns) {
		super(power, pp, accuracy, name, type, level, specialAttack);
		this.maxTurns = maxTurns;
		this.numberOfRepetitions = 0;
	}
	
	public boolean isActive() {
		return numberOfRepetitions <= maxTurns;
	}
	
	protected int getTurnNumber() {
		return this.numberOfRepetitions;
	}
	
	public String periodicEffect(Pokemon self, Pokemon foe) {
		numberOfRepetitions++;
		if (isActive()) {
			return this.effect(self, foe);
		} else {
			return self.getName() + "'s " + this.getName() + " has worn off!";
		}
	}
	
	protected abstract String effect(Pokemon self, Pokemon foe);

}
