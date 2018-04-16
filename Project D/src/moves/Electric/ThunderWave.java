package moves.Electric;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class ThunderWave extends Move_StatusEffect{

	public ThunderWave(int level) {
		super(0, 20, 100, "Thunder Wave", Type.ELECTRIC, level, false, StatusEffect.PARALYSIS, 100, false);
	}

}
