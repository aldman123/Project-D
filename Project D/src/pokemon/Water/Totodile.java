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

public class Totodile extends EvolveablePokemon {
	
	static final int[] baseStatList = new int[]{80, 120, 70, 110, 70, 80};
	static final Type typeA = Type.WATER;
	static final Type typeB = null;
	static final String speciesName = "Totodile";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 66;
	static final Class<?> evolution = Croconaw.class;
	static final int evolutionLevel = 18;
	static final Move[] moveLearnset = new Move[]{
		new Scratch(1),
		new Leer(1),
		new Rage(7),
		new WaterGun(13),
		new Bite(20),
		new ScaryFace(27),
		new Slash(35),
		new Screech(43),
		new HydroPump(50)
	};
	
	/**
	 * Totodile is a Water Pokemon and one of the three starter Pokemon in Pokemon Gold and Silver
	 * It is a blue, bipedal alligator Pokemon that enjoys biting it's foes.
	 */
	public Totodile(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType, evolution, evolutionLevel);
		this.setBaseExperienceYield(baseExperienceYield);
	}
	
	public Totodile(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType, evolution, evolutionLevel);
		this.setBaseExperienceYield(baseExperienceYield);
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
