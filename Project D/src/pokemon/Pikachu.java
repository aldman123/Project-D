package pokemon;

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

public class Pikachu extends Pokemon{
	static int[] baseStats = new int[]{35, 55, 30, 50, 50, 90};
	static Move[] learnSet = new Move[]{
			new ThunderShock(1),
			new Growl(1),
			new TailWhip(6),
			new ThunderWave(8),
			new QuickAttack(11),
			new DoubleTeam(15),
			new Slam(20),
			new ThunderBolt(26),
			new Agility(33),
			new Thunder(41)
			};
	
	public Pikachu(int level) {
		super(baseStats, level, Type.ELECTRIC, null, learnSet, "PIKACHU");
	}
	
	public Pikachu(int level, String name) {
		super(baseStats, level, Type.ELECTRIC, null, learnSet, name);
	}
	
}
