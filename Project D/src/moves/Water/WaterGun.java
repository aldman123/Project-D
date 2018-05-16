package moves.Water;

import misc.Type;
import moves.Move;

public class WaterGun extends Move {

	/**
	 * The Pokemon throws a little water at the foe
	 */
	public WaterGun(int learnLevel) {
		super(40, 25, 100, "Water Gun", Type.WATER, learnLevel, true);
	}

}
