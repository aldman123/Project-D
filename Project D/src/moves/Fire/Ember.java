package moves.Fire;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class Ember extends Move_StatusEffect {

	public Ember(int level) {
		super(40, 25, 100, "EMBER", Type.FIRE, level, true, StatusEffect.BURN, 10, false);
	}

}
