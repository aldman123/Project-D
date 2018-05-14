package moves.Poison;

import misc.StatusEffect;
import misc.Type;
import moves.Move_StatusEffect;

public class PoisonPowder extends Move_StatusEffect {

	public PoisonPowder(int learnLevel) {
		super(0, 35, 75, "Poison Powder", Type.POISON, learnLevel, true, StatusEffect.POISON, 100, false);
	}

}
