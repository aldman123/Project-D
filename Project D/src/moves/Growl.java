package moves;

import misc.Type;

public class Growl extends Move_StatChange {

	public Growl(int learnLevel) {
		super(0, 40, 100, "Growl", Type.NORMAL, learnLevel, 1, -1, false);
	}
	
}
