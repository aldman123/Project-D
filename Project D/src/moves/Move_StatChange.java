package moves;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_StatChange extends Move{
	
	private final int statToChange, statChangeModifier;
	private final boolean onSelf;
	
	public Move_StatChange(
			int damage, int pp, int accuracy, String name, Type type,
			int level, int statToChange, int statChangeModifier, boolean onSelf	) {
		super(damage, pp, accuracy, name, type, level);
		this.onSelf = onSelf;
		this.statChangeModifier = statChangeModifier;
		this.statToChange = statToChange;
		
	}
	
	public String start(Pokemon self, Pokemon foe) {
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
		} else {
			output += "Stat";
		}
		output += " was ";
		if (statChangeModifier < 0) {
			output += "decreased!";
		} else {
			output += "increased!";
		}
		
		System.out.println(output);
		return super.start(self, foe);
	}

}
