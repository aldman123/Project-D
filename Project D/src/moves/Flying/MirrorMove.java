package moves.Flying;

import misc.Type;
import moves.Move;

public class MirrorMove extends Move {
	
	/**
	 * A move that copies the move used last by the opposing Pokemon
	 * @param level
	 */
	public MirrorMove(int level) {
		super(0, 20, 100, "Mirror Move", Type.FLYING, level, true);
	}

}
