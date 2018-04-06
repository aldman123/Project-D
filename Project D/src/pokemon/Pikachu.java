package pokemon;

import misc.Type;
import moves.*;

public class Pikachu extends Pokemon{
	static Move[] moveList = new Move[]{
			new ThunderShock(1),
			new Growl(1),
			new TailWhip(6)
			};
	
	public Pikachu(int level) {
		super(new int[]{35, 55, 30, 50, 50, 90}, level, Type.ELECTRIC, Type.NORMAL, moveList);
		this.setName("PIKACHU");
	}
	
	public Pikachu(int level, String name) {
		super(new int[]{35, 55, 30, 50, 50, 90}, level, Type.ELECTRIC, Type.NORMAL, moveList);
		this.setName(name);
	}
	
}
