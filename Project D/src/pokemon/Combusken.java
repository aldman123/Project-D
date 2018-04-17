package pokemon;

import misc.Type;
import moves.*;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;

public class Combusken extends Pokemon {
	
	static int[] baseStatList = new int[]{60, 85, 60, 85, 60, 55};
	static Move[] moveLearnset = new Move[] {
			new Growl(1),
			new Scratch(1),
			new QuickAttack(32)
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
