package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class Screech extends Move_StatChange {

	public Screech(int learnLevel) {
		super(0, 40, 85, "Screech", Type.NORMAL, learnLevel, false, 2, -2, false);
	}

}
