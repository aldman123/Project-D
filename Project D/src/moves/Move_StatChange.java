package moves;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_StatChange extends Move{
	private int statToChange, statChangeModifier;
	/**
	 * This move will raise or lower an individual stat of a Pokemon during the turn
	 * @param statToChange stat index to change [HP. Atk, Def, SpAtk, SpDef, Speed, Accuracy, Evasion, CriticalHit]
	 */
	public Move_StatChange(
			int damage, int pp, int accuracy, String name, Type type,
			int level, boolean specialAttack, int statToChange, int statChangeModifier, boolean onSelf) {
		super(damage, pp, accuracy, name, type, level, specialAttack);
		this.onSelf = onSelf;
		this.statChangeModifier = statChangeModifier;
		this.statToChange = statToChange;
		
	}
	
	protected void start(Pokemon self, Pokemon foe) {
		super.start(self, foe);
		
		String output = "";
		if (onSelf) {
			output += self.getName();
			self.modifyStat(statToChange, statChangeModifier);
		} else {
			output += foe.getName();
			foe.modifyStat(statToChange, statChangeModifier);
		}
		output += "'s " + self.getStatName(statToChange) + " was ";
		if (statChangeModifier < 0) {
			output += "decreased!";
		} else {
			output += "increased!";
		}
		
		System.out.println(output);
	}
	
	public int getStatToChange() {
		return statToChange;
	}

	public void setStatToChange(int statToChange) {
		this.statToChange = statToChange;
	}

	public int getStatChangeModifier() {
		return statChangeModifier;
	}

	public void setStatChangeModifier(int statChangeModifier) {
		this.statChangeModifier = statChangeModifier;
	}

	private final boolean onSelf;
}
