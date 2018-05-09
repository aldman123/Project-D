package pokemon;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.PoisonPowder;
import moves.SweetScent;
import moves.Dark.Bite;
import moves.Dark.Rage;
import moves.Grass.Growth;
import moves.Grass.RazorLeaf;
import moves.Grass.SleepPowder;
import moves.Grass.SolarBeam;
import moves.Grass.Synthesis;
import moves.Grass.VineWhip;
import moves.Normal.Growl;
import moves.Normal.Leer;
import moves.Normal.ScaryFace;
import moves.Normal.Scratch;
import moves.Normal.Screech;
import moves.Normal.Slash;
import moves.Normal.Tackle;
import moves.Water.HydroPump;
import moves.Water.WaterGun;
import pokemon.Water.Croconaw;

public class Bulbasaur extends EvolveablePokemon {
	
	static final int[] baseStatList = new int[]{45, 49, 49, 65, 65, 45};
	static final Type typeA = Type.GRASS;
	static final Type typeB = Type.POISON;
	static final String speciesName = "Bulbasaur";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 64;
	static final Class evolution = null;
	static final int evolutionLevel = 16;
	static final Move[] moveLearnset = new Move[]{
			new Tackle(1),
			new Growl(4),
//			new LeechSeed(7),
			new VineWhip(10),
			new PoisonPowder(15),
			new SleepPowder(15),
			new RazorLeaf(20),
			new SweetScent(25),
			new Growth(32),
			new Synthesis(39),
			new SolarBeam(46)
	};
	
	public Bulbasaur(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType, evolution, evolutionLevel);
	}
	
	public Bulbasaur(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType, evolution, evolutionLevel);
	}

	public String getSpeciesName() {
		return evolution;
	}

}
