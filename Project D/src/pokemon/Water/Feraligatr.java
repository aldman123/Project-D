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
import pokemon.Pokemon;

public class Feraligatr extends Pokemon {
	
	static final int[] baseStatList = new int[]{85, 105, 100, 79, 83, 78};
	static final Type typeA = Type.WATER;
	static final Type typeB = null;
	static final String speciesName = "Feraligatr";
	static final Experience experienceType = Experience.MEDIUM_SLOW;
	static final int baseExperienceYield = 210;
	static final Move[] moveLearnset = new Move[]{
			new Scratch(1),
			new Leer(1),
			new Rage(7),
			new WaterGun(13),
			new Bite(21),
			new ScaryFace(28),
			new Slash(38),
			new Screech(47),
			new HydroPump(50)
	};
	
	/**
	 * With much larger arms and tail than it's earlier evolutions, Feraligatr
	 * is a large humanoid Pokemon that is adept at slashing and smashing it's foes
	 * @param level
	 */
	public Feraligatr(int level) {
		super(baseStatList, level, typeA, typeB, moveLearnset, speciesName, experienceType);
	}
	
	public Feraligatr(int level, String name) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType);
	}


	public String getSpeciesName() {
		return speciesName;
	}

}
