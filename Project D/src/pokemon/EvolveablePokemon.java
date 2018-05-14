package pokemon;

import java.lang.reflect.InvocationTargetException;

import misc.Experience;
import misc.Type;
import moves.Move;

public abstract class EvolveablePokemon extends Pokemon {
	private int evolveLevel;
	private final Class evolution;
	
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
	
	protected Pokemon levelUp() {
		EvolveablePokemon me = (EvolveablePokemon) this;
		if (me.getEvolveLevel() <= me.getLevel() + 1) {
			me.setLevel(me.getLevel() + 1);
			System.out.println(me.getName() + " is evolving!");
			
			try {
				me = (EvolveablePokemon) me.getEvolution().getDeclaredConstructor(int.class).newInstance(me.getLevel());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				System.out.println("Error in evolution");
				e.printStackTrace();
				return me;
			}
			
			System.out.println("The Pokemon evolved into " + me.getName() + "!");
		}
		return (Pokemon) me;
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
