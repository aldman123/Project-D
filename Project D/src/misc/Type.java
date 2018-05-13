package misc;

//http://www.generalresumes.info/wp-content/uploads/2017/05/pokemon-type-chart-gen-3-odouges-1.jpg
//I am not implementing FAIRY, because I have never played with any fairy Pokemon before
public enum Type {
	NORMAL,
	FIGHT,
	PSYCHIC,
	DARK,
	FIRE,
	WATER,
	GRASS,
	BUG,
	FLYING,
	GROUND,
	ROCK,
	ICE,
	STEEL,
	POISON,
	ELECTRIC,
	DRAGON,
	GHOST;
	
	/**
	 * @param p2
	 * @return The modifier for the damage from this onto p2
	 */
	public double against(Type p2) {
		Type p1 = this;
		
		double output = 1;
		
		switch (p1) {
		case GRASS:
			
			//Weakness
			for (Type t : new Type[]{FIRE, ICE, POISON, FLYING, BUG}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{WATER, GROUND, ROCK}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case ROCK:
			//Weakness
			for (Type t : new Type[]{WATER, GRASS, FIGHT, GROUND, STEEL}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, ICE, FLYING, BUG}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case ICE:
			//Weakness
			for (Type t : new Type[]{FIRE, FIGHT, ROCK, STEEL}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, GROUND, FLYING, DRAGON}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case DRAGON:
			//Weakness
			if (p2 == ICE) {
				output = 1/2;
			}
			
			//Strength
			if (p2 == DRAGON) {
				output = 2;
			}
			
		case DARK:
			//Weakness
			for (Type t : new Type[]{FIGHT, BUG}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{PSYCHIC, GHOST}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case PSYCHIC:
			//Weakness
			for (Type t : new Type[]{BUG, GHOST, DARK}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIGHT, POISON}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case BUG:
			//Weakness
			for (Type t : new Type[]{FIRE, FLYING, ROCK}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, PSYCHIC, DARK}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case FLYING:
			//Weakness
			for (Type t : new Type[]{ELECTRIC, ICE, ROCK}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, FIGHT, BUG}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case STEEL:
			//Weakness
			for (Type t : new Type[]{FIRE, FIGHT, GROUND}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{ICE, ROCK}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case FIRE:
			//Weakness
			for (Type t : new Type[]{WATER, GROUND, ROCK}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, ICE, BUG, STEEL}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case FIGHT:
			//Weakness
			for (Type t : new Type[]{FLYING, PSYCHIC}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{NORMAL, ICE, ROCK, DARK, STEEL}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case GROUND:
			//Weakness
			for (Type t : new Type[]{WATER, GRASS, ICE}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, ELECTRIC, POISON, ROCK, STEEL}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case GHOST:
			//Weakness
			if (p2 == DARK) {
				output = 1/2;
			}
			
			//Strength
			for (Type t : new Type[]{PSYCHIC, GHOST}) {
				if (p2 == t) {
					output = 2;
				}
			}
			
		case POISON:
			//Weakness
			for (Type t : new Type[]{GROUND, PSYCHIC}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			if (p2 == GRASS) {
				output = 2;
			}
			
		case WATER:
			//Weakness
			for (Type t : new Type[]{ELECTRIC, GRASS}) {
				if (p2 == t) {
					output = 1/2;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, GROUND, ROCK}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case ELECTRIC:
			//Weakness
			if (p2 == GROUND) {
				output = 1/2;
			}
			
			//Strength
			for (Type t : new Type[]{WATER, FLYING}) {
				if (p2 == t) {
					output = 2;
				}
			}
		case NORMAL:
			if (p2 == FIGHT) {
				output = 1/2;
			}
			
		}
		
		return output;
		
		
	}
	
}
