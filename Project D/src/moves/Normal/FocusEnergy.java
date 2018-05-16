package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class FocusEnergy extends Move_StatChange {
	
	/**
	 * The Pokemon uses deep focus to improve it's odds of achieving a critical hit
	 */
	public FocusEnergy(int level) {
		super(0, 30, 100, "Focus Energy", Type.NORMAL, level, false, 8, 1, true);
	}

}
