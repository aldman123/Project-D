package moves.Grass;

import misc.Type;
import moves.Move_StatChange;

public class Growth extends Move_StatChange {

	public Growth(int learnLevel) {
		super(0, 20, 100, "Growth", Type.GRASS, learnLevel, false, 3, 1, true);
	}
	
}
