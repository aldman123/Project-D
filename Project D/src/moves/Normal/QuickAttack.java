package moves.Normal;

import misc.Type;
import moves.Move;

public class QuickAttack extends Move{
	
	/**
	 * The Pokemon puts all it's effort into hitting the foe first, and normally strikes far before the foe can react
	 */
	public QuickAttack(int level) {
		super(40, 30, 100, "Quick Attack", Type.NORMAL, level, false);
		this.setFast(true);
	}

}
