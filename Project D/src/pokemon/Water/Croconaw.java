package pokemon.Water;

import misc.Experience;
import misc.Type;
import moves.Move;
import moves.Dark.Bite;
import moves.Dark.Rage;
import moves.Normal.Leer;
import moves.Normal.ScaryFace;
import moves.Normal.Scratch;
import moves.Normal.Screech;
import moves.Normal.Slash;
import moves.Water.HydroPump;
import moves.Water.WaterGun;
import pokemon.EvolveablePokemon;

public class Croconaw extends EvolveablePokemon {
	
	static final int[] baseStatList = new int[]{65, 80, 80, 59, 63, 58};
	static final Type typeA = Type.WATER;
	static final Type typeB = null;
	static final String speciesName = "Croconaw";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 143;
	static final Class evolution = Feraligatr.class;
	static final int evolutionLevel = 30;
	static final Move[] moveLearnset = new Move[]{
			new Scratch(1),
			new Leer(1),
			new Rage(7),
			new WaterGun(13),
			new Bite(21),
			new ScaryFace(28),
			new Slash(37),
			new Screech(45),
			new HydroPump(50)
	};
	
	public Croconaw(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType, evolution, evolutionLevel);
	}
	
	public Croconaw(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType, evolution, evolutionLevel);
	}


	public String getSpeciesName() {
		return speciesName;
	}

}
