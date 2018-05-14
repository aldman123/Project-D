package moves.Fighting;

import misc.Type;
import moves.Move_MultyStrike;

public class DoubleKick extends Move_MultyStrike {

	public DoubleKick(int level){
		super(30, 30, 100, "Double Kick", Type.FIGHT, level, false, "Jump Kick!");
		this.setRepetitions(2, 2);
	}

}
