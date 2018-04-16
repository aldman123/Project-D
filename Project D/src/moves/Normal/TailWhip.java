package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class TailWhip extends Move_StatChange {

	public TailWhip(int learnLevel) {
		super(0, 30, 100, "Tail Whip", Type.NORMAL, learnLevel, false, 2, -1, false);
	}
	
}
