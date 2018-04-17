package moves.Electric;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class ThunderShock extends Move_StatusEffect{

	public ThunderShock(int learnLevel) {
		super(40, 30, 100, "Thunder Shock", Type.ELECTRIC, learnLevel, true, StatusEffect.PARALYSIS, 10, false);
	}

}
