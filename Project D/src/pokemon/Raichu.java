package pokemon;

import misc.Type;
import moves.*;
import moves.Electric.ThunderBolt;
import moves.Electric.ThunderShock;
import moves.Normal.QuickAttack;
import moves.Normal.TailWhip;

public class Raichu extends Pokemon {
	
	static int[] baseStatList = new int[]{60, 90, 55, 90, 80, 100};
	static Move[] moveLearnset = new Move[] {
			new ThunderShock(0),
			new TailWhip(0),
			new QuickAttack(0),
			new ThunderBolt(0)
			};
	
	public Raichu(int level) {
		super(baseStatList, level, Type.ELECTRIC, null, moveLearnset, "Raichu");
	}
	
	public Raichu(int level, String name) {
		super(baseStatList, level, Type.ELECTRIC, null, moveLearnset, name);
	}
	
	public Raichu(Pokemon lastEvolution) {
		super(baseStatList, lastEvolution.getLevel(), Type.ELECTRIC, null, moveLearnset, lastEvolution.getName());
	}

}