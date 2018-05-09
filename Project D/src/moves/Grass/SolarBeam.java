package moves.Grass;

import misc.Type;
import moves.Move;

public class SolarBeam extends Move {
	
	private boolean firstTurn;
	
	
	/**
	 * This move takes one turn to charge up, but afterwards
	 * does a high amount of damage to the opponent.
	 */
	public SolarBeam(int learnLevel) {
		super(120, 10, 100, "Solar Beam", Type.GRASS, learnLevel, true);
		firstTurn = true;
	}
	
	public void setFirstTurn(boolean isFirstTurn) {
		this.firstTurn = isFirstTurn;
	}
	
	error
	fix this
	
}
