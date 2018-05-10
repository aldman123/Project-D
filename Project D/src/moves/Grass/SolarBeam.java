package moves.Grass;

import misc.Type;
import moves.Move_Recurring;
import pokemon.Pokemon;

public class SolarBeam extends Move_Recurring {
	
	
	/**
	 * This move takes one turn to charge up, but afterwards
	 * does a high amount of damage to the opponent.
	 */
	public SolarBeam(int learnLevel) {
		super(0, 10, 100, "Solar Beam", Type.GRASS, learnLevel, true, 2);
	}

	protected String effect(Pokemon self, Pokemon foe) {
		if (this.getTurnNumber() == 1) {
			return "The solar beam is charging!";
		} else {
			this.setPower(120);
			return this.start(self, foe);
		}
	}
	
}
