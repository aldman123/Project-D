package moves.Psychic;

import misc.Type;
import moves.Move_StatChange;

public class Agility extends Move_StatChange{

	/**
	 * The Pokemon speeds up and increases it's evasiveness drastically
	 */
	public Agility(int learnLevel) {
		super(0, 30, 100, "Agility", Type.PSYCHIC, learnLevel, true, 5, 2, true);
	}

}
