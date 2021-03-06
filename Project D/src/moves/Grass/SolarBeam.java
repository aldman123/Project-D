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
		super(0, 10, 100, "Solar Beam", Type.GRASS, learnLevel, true, 2, false);
	}

	protected void effect(Pokemon self, Pokemon foe) {
		if (this.getTurnNumber() == 1) {
			System.out.println("The Solar Beam is charging!");
			return;
		} else {
			this.setPower(120);
			this.start(self, foe);
			this.setPower(0);
		}
		System.out.println("The Solar Beam was used up!");
	}
	
}
