package pokemon;

import misc.Type;
import moves.*;
import moves.Fighting.DoubleKick;
import moves.Fire.Ember;
import moves.Flying.MirrorMove;
import moves.Flying.Peck;
import moves.Ground.SandAttack;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;
import moves.Normal.Slash;

public class Combusken extends Pokemon {
	
	static int[] baseStatList = new int[]{60, 85, 60, 85, 60, 55};
	static Move[] moveLearnset = new Move[] {
			new Growl(1),
			new Scratch(1),
//			new FocusEnergy(7),
			new Ember(13),
			new DoubleKick(16),
			new Peck(17),
			new SandAttack(21),
//			new BulkUp(28),
			new QuickAttack(32),
			new Slash(39),
			new MirrorMove(43),
//			new SkyUppercut(50)
			};
	
	public Combusken(int level) {
		super(baseStatList, level, Type.FIRE, Type.FIGHT, moveLearnset, "COMBUSKEN");
	}
	
	public Combusken(int level, String name) {
		super(baseStatList, level, Type.FIRE, Type.FIGHT, moveLearnset, name);
	}
	
	public Combusken(Pokemon torchic) {
		super(baseStatList, torchic.getLevel(), Type.FIRE, Type.FIGHT, moveLearnset, torchic.getName());
	}

}
