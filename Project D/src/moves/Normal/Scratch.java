package moves.Normal;

import misc.Type;
import moves.Move;

public class Scratch extends Move{

	/**
	 * The Pokemon uses it claw or feet to scratch the foe
	 */
	public Scratch(int learnLevel) {
		super(40, 35, 100, "Scratch", Type.NORMAL, learnLevel, false);
	}

}
