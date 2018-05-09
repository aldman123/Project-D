package moves.Grass;

import misc.Type;
import moves.Move;

public class RazorLeaf extends Move {

	public RazorLeaf(int learnLevel) {
		super(55, 25, 95, "Razor Leaf", Type.GRASS, learnLevel, true);
		this.setHighCriticalHit(true);
	}

}
