package moves;

import misc.Type;

public class TailWhip extends Move_StatChange {

	public TailWhip(int learnLevel) {
		super(0, 30, 100, "Tail Whip", Type.NORMAL, learnLevel, 2, -1, false);
	}
	
}
