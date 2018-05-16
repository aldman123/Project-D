package moves.Normal;

import misc.Type;
import moves.Move;

public class Slam extends Move{

	/**
	 * The Pokemon slams into the foe with all it's weight
	 * @param learnLevel
	 */
	public Slam(int learnLevel) {
		super(80, 20, 75, "Slam", Type.NORMAL, learnLevel, false);
	}

}
