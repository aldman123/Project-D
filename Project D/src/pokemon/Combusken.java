package pokemon;

import misc.Experience;
import misc.Type;
import moves.*;
import moves.Fighting.BulkUp;
import moves.Fighting.DoubleKick;
import moves.Fighting.SkyUppercut;
import moves.Fire.Ember;
import moves.Flying.MirrorMove;
import moves.Flying.Peck;
import moves.Ground.SandAttack;
import moves.Normal.FocusEnergy;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;
import moves.Normal.Slash;

public class Combusken extends EvolveablePokemon{
	
	static int[] baseStatList = new int[]{60, 85, 60, 85, 60, 55};
	static final Type typeA = Type.FIRE;
	static final Type typeB = Type.FIGHT;
	static final String name = "Combusken";
	static final Experience experience = Experience.MEDIUM_SLOW;
	static final int evolutionLevel = 36;
	
	static Move[] moveLearnset = new Move[] {
			new Growl(0),
			new Scratch(0),
			new FocusEnergy(7),
			new Ember(13),
			new DoubleKick(16),
			new Peck(17),
			new SandAttack(21),
			new BulkUp(28),
			new QuickAttack(32),
			new Slash(39),
			new MirrorMove(43),
			new SkyUppercut(50)
			};
	
	public Combusken(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experience, Blaziken.class, evolutionLevel);
	}
	
	public Combusken(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experience, Blaziken.class, evolutionLevel);
	}
	
	public Combusken(Pokemon torchic) {
		super(baseStatList, torchic.getLevel(), typeA, typeB, moveLearnset, torchic.getName(), experience, Blaziken.class, evolutionLevel);
	}

}
