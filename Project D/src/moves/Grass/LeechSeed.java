package moves.Grass;

import misc.Type;
import moves.Move_Recurring;
import pokemon.Pokemon;

public class LeechSeed extends Move_Recurring {

	public LeechSeed(int learnLevel) {
		super(0, 10, 90, "Leech Seed", Type.GRASS, learnLevel, true, 12, false);
	}

	protected void effect(Pokemon self, Pokemon foe) {
		int absorbedHP = foe.getHP() / 8;
		if (absorbedHP < 1) {
			absorbedHP = 1;
		}
		
		foe.reduceHP(absorbedHP);
		if (self.getHP() + absorbedHP >= self.getMaxHP()) {
			self.setHP(self.getMaxHP());
		} else {
			self.setHP(self.getHP() + absorbedHP);
		}
		System.out.println(self.getName() + " absorbed " + foe.getName() + "'s health!");
	}

}
