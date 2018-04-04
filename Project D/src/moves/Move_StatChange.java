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
	
	public void start(Pokemon self, Pokemon foe) {
		if (onSelf) {
			self.modifyStat(statToChange, statChangeModifier);
		} else {
			foe.modifyStat(statToChange, statChangeModifier);
		}
		super.start(self, foe);
	}

}
