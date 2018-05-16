package moves.Water;

import misc.Type;
import moves.Move;

public class HydroPump extends Move {

	/**
	 * The Pokemon pumps incredible amounts of water in the direction of the foe, causing high damage
	 */
	public HydroPump(int learnLevel) {
		super(110, 5, 80, "Hydro Pump", Type.WATER, learnLevel, true);
	}

}
