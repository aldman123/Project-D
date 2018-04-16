package moves.Electric;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class ThunderBolt extends Move_StatusEffect{

	public ThunderBolt(int learnLevel) {
		super(95, 15, 100, "Thunder Bolt", Type.ELECTRIC, learnLevel, true, StatusEffect.PARALYSIS, 10, false);
	}

}
