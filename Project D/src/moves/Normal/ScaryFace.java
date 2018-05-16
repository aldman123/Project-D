package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class ScaryFace extends Move_StatChange {
	
	/**
	 * The Pokemon makes a horrendous grimace, lowering the speed of the foe
	 */
	public ScaryFace(int learnLevel) {
		super(0, 10, 100, "Scary Face", Type.NORMAL, learnLevel, false, 5, -2, false);
	}

}
