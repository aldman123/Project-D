package pokemon;

import misc.Type;
import moves.Move;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;

public class Torchic extends Pokemon {
	
	static Move[] moveLearnset = new Move[] {
			new Growl(1),
			new Scratch(1),
			new QuickAttack(28)
	};

	public Torchic(int level) {
		super(new int[] {45, 60, 40, 70, 50, 45}, level, Type.FIRE, Type.NORMAL, moveLearnset, "TORCHIC");
	}
	
	public Torchic(int level, String name) {
		super(new int[] {45, 60, 40, 70, 50, 45}, level, Type.FIRE, Type.NORMAL, moveLearnset, name);
	}

}
