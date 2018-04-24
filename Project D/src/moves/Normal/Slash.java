package moves.Normal;

import misc.Type;
import moves.Move;

public class Slash extends Move {

	public Slash(int level) {
		super(70, 20, 100, "Slash", Type.NORMAL, level, false);
		this.setHighCriticalHit(true);
	}

}
