package pokemon.Fire;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.Fire.Ember;
import moves.Fire.FireSpin;
import moves.Fire.FlameThrower;
import moves.Flying.MirrorMove;
import moves.Flying.Peck;
import moves.Ground.SandAttack;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Scratch;
import moves.Normal.Slash;
import pokemon.EvolveablePokemon;

public class Torchic extends EvolveablePokemon {
	
	static final Type typeA = Type.FIRE;
	static final Type typeB = null;
	static final String speciesName = "Torchic";
	static final Experience experience = Experience.MEDIUM_SLOW;
	static final int evolutionLevel = 16;
	static final int baseExperienceYield = 65;
	static final int[] statList = new int[] {45, 60, 40, 70, 50, 45};
	static Move[] moveLearnset = new Move[] {
			new Growl(0),
			new Scratch(0),
			new Ember(10),
			new Peck(16),
			new SandAttack(19),
			new FireSpin(25),
			new QuickAttack(28),
			new Slash(34),
			new MirrorMove(37),
			new FlameThrower(43)
	};

	/**
	 * One of the three starting Pokemon from Pokemon Saffire, Ruby and Emerald, this firey bird Pokemon
	 * has a red and yellow color scheme. It has a flame sac inside its belly that perpetually burns. It feels warm if it is hugged.
	 * @param level
	 */
	public Torchic(int level) {
		super(statList, level, typeA, typeB, moveLearnset, speciesName, experience, Combusken.class, evolutionLevel);
		this.setBaseExperienceYield(baseExperienceYield);
	}
	
	public Torchic(int level, String name) {
		super(statList, level, typeA, typeB, moveLearnset, name, experience, Combusken.class, evolutionLevel);
		this.setBaseExperienceYield(baseExperienceYield);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
