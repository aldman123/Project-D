package moves.Grass;

import java.util.Calendar;

import misc.Type;
import moves.Move;
import pokemon.Pokemon;

/**
 * This move will restore health depending on the time of day
 * @author Alexander Aldridge
 *
 */
public class Synthesis extends Move {

	public Synthesis(int learnLevel) {
		super(0, 5, 100, "Synthesis", Type.GRASS, learnLevel, true);
	}
	
	public String start(Pokemon self, Pokemon foe) {
		double modifier;
		int hour = Calendar.HOUR_OF_DAY;
		int restoredHP;
		if (hour >= 8 && hour <= 16) {
			System.out.println("It's sunny outside!");
			modifier = 1/4;
		} else {
			System.out.println("The sun isn't so bright right now");
			modifier = 1/2;
		}
		
		restoredHP = (int) (self.getMaxHP() * modifier);
		self.setHP(self.getHP() + restoredHP);
		return self.getName() + " restored " + restoredHP + " Hit Points!";
	}
}
