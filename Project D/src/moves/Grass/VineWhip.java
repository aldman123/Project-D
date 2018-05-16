package moves.Grass;

import misc.Type;
import moves.Move;

public class VineWhip extends Move {
	
	/**
	 * The Pokemon lashes out with vines; damaging the foe's Pokemon
	 */
	public VineWhip(int learnLevel) {
		super(45, 25, 100, "Vine Whip", Type.GRASS, learnLevel, false);
	}

}
