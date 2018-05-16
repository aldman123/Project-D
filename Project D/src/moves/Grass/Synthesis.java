package moves.Grass;

import java.util.Calendar;

import misc.Type;
import moves.Move;
import pokemon.Pokemon;

/**
 * This move will restore health depending on the time of day in the real world
 *
 */
public class Synthesis extends Move {

	public Synthesis(int learnLevel) {
		super(0, 5, 100, "Synthesis", Type.GRASS, learnLevel, true);
	}
	
	protected void start(Pokemon self, Pokemon foe) {
		double modifier;
		int hour = Calendar.HOUR_OF_DAY;
		if (hour >= 8 && hour <= 16) {
			System.out.println("It's sunny outside!");
			modifier = 1/2;
		} else {
			System.out.println("The sun isn't so bright right now");
			modifier = 1/4;
		}
		
		int restoredHP = (int) (self.getMaxHP() * modifier);
		self.setHP(self.getHP() + restoredHP);
		System.out.println(self.getName() + " restored " + restoredHP + " Hit Points!");
	}
}
