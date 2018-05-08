package pokemon;

import misc.Experience;
import misc.Type;
import moves.*;
import moves.Electric.ThunderBolt;
import moves.Electric.ThunderShock;
import moves.Normal.QuickAttack;
import moves.Normal.TailWhip;

public class Raichu extends Pokemon {
	
	static int[] baseStatList = new int[]{60, 90, 55, 90, 80, 100};
	static final String speciesName = "Raichu";
	static final int baseExperienceYield = 122;
	static Move[] moveLearnset = new Move[] {
			new ThunderShock(0),
			new TailWhip(0),
			new QuickAttack(0),
			new ThunderBolt(0)
			};
	
	public Raichu(int level) {
		super(baseStatList, level, Type.ELECTRIC, null, moveLearnset, speciesName, Experience.MEDIUM_FAST);
		this.setBaseExperienceYield(baseExperienceYield);
	}
	
	public Raichu(int level, String name) {
		super(baseStatList, level, Type.ELECTRIC, null, moveLearnset, name, Experience.MEDIUM_FAST);
		this.setBaseExperienceYield(baseExperienceYield);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
