package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class DoubleTeam extends Move_StatChange {

	public DoubleTeam(int learnLevel) {
		super(0, 15, Integer.MAX_VALUE, "Double Team", Type.NORMAL, learnLevel, false, 7, 1, true);
	}
	
}
