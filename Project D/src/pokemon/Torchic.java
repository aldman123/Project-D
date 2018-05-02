package pokemon;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.Fire.Ember;
import moves.Fire.FlameThrower;
import moves.Flying.MirrorMove;
import moves.Flying.Peck;
import moves.Ground.SandAttack;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;
import moves.Normal.Slash;

public class Torchic extends Pokemon {
	
	static Move[] moveLearnset = new Move[] {
			new Growl(0),
			new Scratch(0),
			new Ember(10),
			new Peck(16),
			new SandAttack(19),
			//new FireSpin(25),
			new QuickAttack(28),
			new Slash(34),
			new MirrorMove(37),
			new FlameThrower(43)
	};

	public Torchic(int level) {
		super(new int[] {45, 60, 40, 70, 50, 45}, level, Type.FIRE, Type.NORMAL, moveLearnset, "TORCHIC", Experience.MEDIUM_SLOW);
	}
	
	public Torchic(int level, String name) {
		super(new int[] {45, 60, 40, 70, 50, 45}, level, Type.FIRE, Type.NORMAL, moveLearnset, name, Experience.MEDIUM_SLOW);
	}

}
