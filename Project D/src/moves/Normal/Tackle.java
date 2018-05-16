package moves.Normal;

import misc.Type;
import moves.Move;

public class Tackle extends Move{

	/**
	 * The most common move, the Pokemon tackles the foe with a little power
	 * @param learnLevel
	 */
	public Tackle(int learnLevel) {
		super(40, 35, 100, "Tackle", Type.NORMAL, learnLevel, false);
	}

}
