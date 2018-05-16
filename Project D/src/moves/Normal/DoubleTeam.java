package moves.Normal;

import misc.Type;
import moves.Move_StatChange;

public class DoubleTeam extends Move_StatChange {
	
	/**
	 * The Pokemon moves so quickly that it appears to be two Pokemon
	 * Raises the evasion stat of the Pokemon
	 */
	public DoubleTeam(int learnLevel) {
		super(0, 15, Integer.MAX_VALUE, "Double Team", Type.NORMAL, learnLevel, false, 7, 1, true);
	}
	
}
