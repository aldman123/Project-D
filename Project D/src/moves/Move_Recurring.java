package moves;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_Recurring extends Move {
	
	private int maxTurns, numberOfRepetitions;
	private boolean hidden;
	
	/**
	 * 
	 * @param maxTurns The maximum number of turns that this effect will last
	 * @param hiddent Is the user notified when the effect terminates?
	 */
	public Move_Recurring(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack, int maxTurns, boolean hidden) {
		super(power, pp, accuracy, name, type, level, specialAttack);
		this.maxTurns = maxTurns;
		this.numberOfRepetitions = 0;
		this.hidden = hidden;
	}
	
	public boolean isActive() {
		return numberOfRepetitions <= maxTurns;
	}
	
	protected int getTurnNumber() {
		return this.numberOfRepetitions;
	}
	
	public void periodicEffect(Pokemon self, Pokemon foe) {
		numberOfRepetitions++;
		if (isActive()) {
			this.effect(self, foe);
		} else if (!this.hidden){
			System.out.println(self.getName() + "'s " + this.getName() + " has worn off!");
		}
	}
	
	protected abstract void effect(Pokemon self, Pokemon foe);

}
