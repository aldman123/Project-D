package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class Screech extends Move_StatChange {

	/**
	 * A high pitched scream is emitted, drastically lowering the defense of the foe
	 */
	public Screech(int learnLevel) {
		super(0, 40, 85, "Screech", Type.NORMAL, learnLevel, false, 2, -2, false);
	}

}
