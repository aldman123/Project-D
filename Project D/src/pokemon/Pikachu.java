package pokemon;

import misc.Experience;
import misc.Type;
import moves.*;
import moves.Electric.Thunder;
import moves.Electric.ThunderBolt;
import moves.Electric.ThunderShock;
import moves.Electric.ThunderWave;
import moves.Normal.DoubleTeam;
import moves.Normal.Growl;
import moves.Normal.QuickAttack;
import moves.Normal.Slam;
import moves.Normal.TailWhip;
import moves.Psychic.Agility;

public class Pikachu extends EvolveablePokemon{
	static int evolveLevel = 42;
	static int[] baseStats = new int[]{35, 55, 30, 50, 50, 90};
	static final String speciesName = "Pikachu";
	static Move[] learnSet = new Move[]{
			new ThunderShock(0),
			new Growl(0),
			new TailWhip(6),
			new ThunderWave(8),
			new QuickAttack(11),
			new DoubleTeam(15),
			new Slam(20),
			new ThunderBolt(26),
			new Agility(33),
			new Thunder(41)
			};
	
	/**
	 * The icon of the series, Pikachu is an electric rat like Pokemon, famous for it's bright yellow color.
	 * @param level
	 */
	public Pikachu(int level) {
		super(baseStats, level, Type.ELECTRIC, null, learnSet, speciesName, Experience.MEDIUM_FAST, Raichu.class, evolveLevel);
	}
	
	public Pikachu(int level, String name) {
		super(baseStats, level, Type.ELECTRIC, null, learnSet, name, Experience.MEDIUM_FAST, Raichu.class, evolveLevel);
	}

	public String getSpeciesName() {
		return speciesName;
	}
	
}
