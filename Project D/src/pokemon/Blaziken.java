package pokemon;

import misc.Experience;
import misc.Type;
import moves.*;
import moves.Fighting.BulkUp;
import moves.Fighting.DoubleKick;
import moves.Fire.BlazeKick;
import moves.Fire.Ember;
import moves.Fire.FirePunch;
import moves.Flying.MirrorMove;
import moves.Flying.Peck;
import moves.Ground.SandAttack;
import moves.Normal.FocusEnergy;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;
import moves.Normal.Slash;

public class Blaziken extends Pokemon{
	
	static final int[] baseStatList = new int[]{80, 120, 70, 110, 70, 80};
	static final Type typeA = Type.FIRE;
	static final Type typeB = Type.FIGHT;
	static final String name = "Blaziken";
	static final Experience experience = Experience.MEDIUM_SLOW;
	static final Move[] moveLearnset = new Move[] {
			new FirePunch(0),
			new Scratch(0),
			new Growl(0),
			new FocusEnergy(7),
			new Ember(13),
			new DoubleKick(16),
			new Peck(17),
			new SandAttack(21),
			new BulkUp(28),
			new QuickAttack(32),
			new BlazeKick(36),
			new Slash(42),
			new MirrorMove(49)
			};
	
	public Blaziken(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experience);
	}
	
	public Blaziken(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experience);
	}
	
	public Blaziken(Pokemon combusken) {
		super(baseStatList, combusken.getLevel(), typeA, typeB, moveLearnset, combusken.getName(), experience);
	}

}
