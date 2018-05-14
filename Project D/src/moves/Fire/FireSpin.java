package moves.Fire;

import misc.StatusEffect;
import misc.Type;
import moves.Move_Recurring;
import pokemon.Pokemon;

public class FireSpin extends Move_Recurring {

	public FireSpin(int learnLevel) {
		super(35, 15, 85, "Fire Spin", Type.FIRE, learnLevel, true, 5, false);
		
	}
	/**
	 * The foe is dealt 1/16 of it's max HP in damage
	 */
	protected void effect(Pokemon self, Pokemon foe) {
		foe.reduceHP(foe.getMaxHP() / 16);
		System.out.println(foe.getName() + " was burned by the Fire Vortex!");
		if (foe.getStatus() == StatusEffect.FREEZE) {
			foe.setStatus(StatusEffect.NOTHING);
			System.out.println(foe.getName() + " was thawed out!");
		}
	}

}
