package misc;


/**
 * Each Pokemon and Move has a type/types that are vulnerable or durable to some other types.
 * I am not implementing FAIRY, because I have never played with any fairy Pokemon before
 * @author 50108002
 * http://www.generalresumes.info/wp-content/uploads/2017/05/pokemon-type-chart-gen-3-odouges-1.jpg
 */
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
	
	final private double weakMod = 0.5;
	final private double striongMod = 2.0;
	/**
	 * @param p2
	 * @return The modifier for the damage from this onto p2
	 */
	public double against(Type p2) {
		double output = 1;
		
		//Most Types are resistant to themselves
		if (this == p2 && p2 != NORMAL && p2 != DRAGON) {
			output *= weakMod;
		}
		
		switch (this) {
		case GRASS:
			//Weakness
			for (Type t : new Type[]{FIRE, ICE, POISON, FLYING, BUG}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{WATER, GROUND, ROCK}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case ROCK:
			//Weakness
			for (Type t : new Type[]{WATER, GRASS, FIGHT, GROUND, STEEL}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, ICE, FLYING, BUG}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case ICE:
			//Weakness
			for (Type t : new Type[]{FIRE, FIGHT, ROCK, STEEL}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, GROUND, FLYING, DRAGON}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case DRAGON:
			//Weakness
			if (p2 == ICE) {
				output *= weakMod;
			}
			
			//Strength
			if (p2 == DRAGON) {
				output *= striongMod;
			}
			break;
		case DARK:
			//Weakness
			for (Type t : new Type[]{FIGHT, BUG}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{PSYCHIC, GHOST}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case PSYCHIC:
			//Weakness
			for (Type t : new Type[]{BUG, GHOST, DARK}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIGHT, POISON}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case BUG:
			//Weakness
			for (Type t : new Type[]{FIRE, FLYING, ROCK}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, PSYCHIC, DARK}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case FLYING:
			//Weakness
			for (Type t : new Type[]{ELECTRIC, ICE, ROCK}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, FIGHT, BUG}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case STEEL:
			//Weakness
			for (Type t : new Type[]{FIRE, FIGHT, GROUND}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{ICE, ROCK}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case FIRE:
			//Weakness
			for (Type t : new Type[]{WATER, GROUND, ROCK}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{GRASS, ICE, BUG, STEEL}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case FIGHT:
			//Weakness
			for (Type t : new Type[]{FLYING, PSYCHIC}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{NORMAL, ICE, ROCK, DARK, STEEL}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case GROUND:
			//Weakness
			for (Type t : new Type[]{WATER, GRASS, ICE}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, ELECTRIC, POISON, ROCK, STEEL}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case GHOST:
			//Weakness
			if (p2 == DARK) {
				output *= weakMod;
			}
			
			//Strength
			for (Type t : new Type[]{PSYCHIC, GHOST}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
			
		case POISON:
			//Weakness
			for (Type t : new Type[]{GROUND, PSYCHIC}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			if (p2 == GRASS) {
				output *= striongMod;
			}
			break;
			
		case WATER:
			//Weakness
			for (Type t : new Type[]{ELECTRIC, GRASS}) {
				if (p2 == t) {
					output *= weakMod;
				}
			}
			
			//Strength
			for (Type t : new Type[]{FIRE, GROUND, ROCK}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case ELECTRIC:
			//Weakness
			if (p2 == GROUND) {
				output *= weakMod;
			}
			
			//Strength
			for (Type t : new Type[]{WATER, FLYING}) {
				if (p2 == t) {
					output *= striongMod;
				}
			}
			break;
		case NORMAL:
			if (p2 == FIGHT) {
				output *= weakMod;
			}
			break;
		}
		
		return output;
		
	}
	
}
