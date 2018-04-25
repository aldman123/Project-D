package moves.Fire;

import misc.Type;
import moves.Move;

public class BlazeKick extends Move {

	public BlazeKick(int level) {
		super(85, 10, 90, "Blaze Kick", Type.FIRE, level, false);
		this.setHighCriticalHit(true);
	}

}
