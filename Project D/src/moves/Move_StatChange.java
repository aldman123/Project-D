package moves;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_StatChange extends Move{
	
	private int statToChange, statChangeModifier;
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
	
	/*
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
	
	public String start(Pokemon self, Pokemon foe) {
		System.out.println(super.start(self, foe));
		
		String output = "";
		if (onSelf) {
			output += self.getName();
			self.modifyStat(statToChange, statChangeModifier);
		} else {
			output += foe.getName();
			foe.modifyStat(statToChange, statChangeModifier);
		}
		output += "'s ";
		if (statToChange == 1) {
			output += "Attack";
		} else if (statToChange == 2) {
			output += "Defence";
		} else if (statToChange == 3) {
			output += "Special Attack";
		} else if (statToChange == 4) {
			output += "Special Defence";
		} else if (statToChange == 5) {
			output += "Speed";
		} else if (statToChange  == 6) {
			output += "Accuracy";
		} else if (statToChange  == 7) {
			output += "Evasion";
		} else if (statToChange  == 8) {
			output += "Critical Hit Ratio";
		} else {
			output += "Stat";
		}
		output += " was ";
		if (statChangeModifier < 0) {
			output += "decreased!";
		} else {
			output += "increased!";
		}
		
		return output;
	}

}
