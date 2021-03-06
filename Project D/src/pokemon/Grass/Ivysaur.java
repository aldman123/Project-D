package pokemon.Grass;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.Grass.Growth;
import moves.Grass.LeechSeed;
import moves.Grass.RazorLeaf;
import moves.Grass.SleepPowder;
import moves.Grass.SolarBeam;
import moves.Grass.SweetScent;
import moves.Grass.Synthesis;
import moves.Grass.VineWhip;
import moves.Normal.Growl;
import moves.Normal.Tackle;
import moves.Poison.PoisonPowder;
import pokemon.EvolveablePokemon;

public class Ivysaur extends EvolveablePokemon {
	
	static final int[] baseStatList = new int[]{60, 62, 63, 80, 80, 60};
	static final Type typeA = Type.GRASS;
	static final Type typeB = Type.POISON;
	static final String speciesName = "Ivysaur";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 141;
	static final Class<?> evolution = Venausaur.class;
	static final int evolutionLevel = 32;
	static final Move[] moveLearnset = new Move[]{
			new Tackle(1),
			new Growl(4),
			(LeechSeed) new LeechSeed(7),
			new VineWhip(10),
			new PoisonPowder(15),
			new SleepPowder(15),
			new RazorLeaf(22),
			new SweetScent(29),
			new Growth(38),
			new Synthesis(47),
			new SolarBeam(50)
	};
	
	/**
	 * With the bulb on it's back nearly about to bloom, Ivysaur evolves from Bulbasaur
	 * and is very similar with it's green appearance and body style.
	 */
	public Ivysaur(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType, evolution, evolutionLevel);
	}
	
	public Ivysaur(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType, evolution, evolutionLevel);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
