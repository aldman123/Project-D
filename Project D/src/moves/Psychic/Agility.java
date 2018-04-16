package moves.Psychic;

import misc.Type;
import moves.Move_StatChange;

public class Agility extends Move_StatChange{

	public Agility(int learnLevel) {
		super(0, 30, Integer.MAX_VALUE, "Agility", Type.PSYCHIC, learnLevel, true, 5, 2, true);
	}

}
