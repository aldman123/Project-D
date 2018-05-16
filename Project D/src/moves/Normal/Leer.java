package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class Leer extends Move_StatChange {
	
	public Leer(int learnLevel) {
		super(0, 30, 100, "Leer", Type.NORMAL, learnLevel, false, 2, -1, false);
	}

}
