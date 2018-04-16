package moves.Normal;

import misc.Type;
import moves.Move;

public class Tackle extends Move{

	public Tackle(int learnLevel) {
		super(40, 35, 100, "Tackle", Type.NORMAL, learnLevel, false);
	}

}
