package moves.Grass;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class SleepPowder extends Move_StatusEffect {
	
	/**
	 * The foe is put to sleep
	 * @param learnLevel
	 */
	public SleepPowder(int learnLevel) {
		super(0, 15, 75, "Sleep Powder", Type.GRASS, learnLevel, true, StatusEffect.SLEEP, 100, false);
	}

}
