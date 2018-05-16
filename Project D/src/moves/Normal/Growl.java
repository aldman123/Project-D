package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class Growl extends Move_StatChange {
	
	/**
	 * The Pokemon growls at the foe, lowering their attack stat
	 */
	public Growl(int learnLevel) {
		super(0, 40, 100, "Growl", Type.NORMAL, learnLevel, false, 1, -1, false);
	}
	
}
