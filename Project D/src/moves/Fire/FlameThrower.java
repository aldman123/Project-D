package moves.Fire;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class FlameThrower extends Move_StatusEffect {

	public FlameThrower(int level) {
		super(90, 15, 100, "Flame Thrower", Type.FIRE, level, true, StatusEffect.BURN, 10, false);
	}

}
