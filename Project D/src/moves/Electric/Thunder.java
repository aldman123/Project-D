package moves.Electric;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class Thunder extends Move_StatusEffect{

	public Thunder(int learnLevel) {
		super(110, 10, 70, "Thunder", Type.ELECTRIC, learnLevel, true, StatusEffect.PARALYSIS, 30, false);
	}

}
