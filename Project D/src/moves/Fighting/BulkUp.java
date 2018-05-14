package moves.Fighting;

import misc.Type;
import moves.Move_StatChange;
import pokemon.Pokemon;

public class BulkUp extends Move_StatChange{
	
	/**
	 * Raises your Pokemon's Attack and Defense stats by one stage
	 */
	public BulkUp(int level) {
		super(0, 20, 100, "Bulk Up", Type.FIGHT, level, false, 1, 1, true);
	}
	
	public void start(Pokemon self, Pokemon foe) {
		this.setStatToChange(1);
		super.start(self, foe);
		this.setStatToChange(2);
		super.start(self, foe);
	}

}
