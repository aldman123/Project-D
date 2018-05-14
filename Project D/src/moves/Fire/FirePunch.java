package moves.Fire;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class FirePunch extends Move_StatusEffect {

	public FirePunch(int level) {
		super(75, 15, 100, "Fire Punch", Type.FIRE, level, false, StatusEffect.BURN, 10, false);
	}

}
