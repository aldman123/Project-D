package pokemon.Fire;

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
import pokemon.Pokemon;

public class Blaziken extends Pokemon {
	
	static final int[] baseStatList = new int[]{80, 120, 70, 110, 70, 80};
	static final Type typeA = Type.FIRE;
	static final Type typeB = Type.FIGHT;
	static final String speciesName = "Blaziken";
	static final Experience experience = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 209;
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
	
	/**
	 * Blaziken is a bipedal fire Pokemon with long white hair and yellow fur towards it's feet.
	 * It is well known for it's signature move Blaze Kick
	 */
	public Blaziken(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experience);
		this.setBaseExperienceYield(baseExperienceYield);
	}
	
	public Blaziken(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experience);
		this.setBaseExperienceYield(baseExperienceYield);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
