package moves.Ground;

import misc.Type;
import moves.Move_StatChange;

public class SandAttack extends Move_StatChange {
	
	/**
	 * Throws sand in the eyes of the foe, lowering accuracy
	 */
	public SandAttack(int level) {
		super(0, 35, 100, "Sand-Attack", Type.GROUND, level, false, 7, -1, false);
	}

}
