package pokemon;

import misc.Experience;
import misc.Type;
import moves.Move;

public class EvolveablePokemon extends Pokemon {
	private int evolveLevel;
	private Class evolution;
	
	public EvolveablePokemon(int[] baseStatList, int level, Type typeA, Type typeB, Move[] moveLearnset, String name,
			Experience experienceType, Class evolution, int evolveLevel) {
		super(baseStatList, level, typeA, typeB, moveLearnset, name, experienceType);
		this.evolution = evolution;
		this.evolveLevel = evolveLevel;
		
	}
	protected int getEvolveLevel() {
		return evolveLevel;
		
	}
	protected Class getEvolution() {
		return evolution;
		
	}
	protected void inputInheritedTraits(int level, Move[] moveLearnset, String name, int experience) {
		this.setLevel(level);
		for (int i = 0; i < moveLearnset.length; i++) {
			this.setMove(moveLearnset[i], i);
		}
		this.setName(name);
		this.setExperience(experience);
	}
}
