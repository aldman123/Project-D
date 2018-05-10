package pokemon.Grass;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.PoisonPowder;
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
import pokemon.Pokemon;

public class Venausaur extends Pokemon {
	
	static final int[] baseStatList = new int[]{80, 82, 83, 100, 100, 80};
	static final Type typeA = Type.GRASS;
	static final Type typeB = Type.POISON;
	static final String speciesName = "Venusaur";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 208;
	static final Move[] moveLearnset = new Move[]{
			new Tackle(1),
			new Growl(4),
			new LeechSeed(7),
			new VineWhip(10),
			new PoisonPowder(15),
			new SleepPowder(15),
			new RazorLeaf(22),
			new SweetScent(29),
			new Growth(41),
			new Synthesis(45),
			new SolarBeam(65)
			
	};
	
	public Venausaur(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType);
	}
	
	public Venausaur(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
