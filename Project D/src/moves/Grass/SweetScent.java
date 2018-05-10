package moves.Grass;

import misc.Type;
import moves.Move_StatChange;

public class SweetScent extends Move_StatChange {

	public SweetScent(int learnLevel) {
		super(0, 20, 100, "Sweet Scent", Type.BUG, learnLevel, false, 7, -1, false);
	}

}
