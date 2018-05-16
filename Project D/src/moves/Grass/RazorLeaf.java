package moves.Grass;

import misc.Type;
import moves.Move;

public class RazorLeaf extends Move {
	/**
	 * The Pokemon throws razor sharp leafs at the foe causing damage
	 * @param learnLevel
	 */
	public RazorLeaf(int learnLevel) {
		super(55, 25, 95, "Razor Leaf", Type.GRASS, learnLevel, true);
		this.setHighCriticalHit(true);
	}

}
