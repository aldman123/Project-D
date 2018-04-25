package moves;

import java.util.Random;

import misc.Type;
import pokemon.Pokemon;

public class Move_MultyStrike extends Move {
	
	private int numberOfRepeatsMin = 2;	//Standard Value
	private int numberOfRepeatsMax = 5;	//Standard Value
	
	public Move_MultyStrike(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack) {
		super(power, pp, accuracy, name, type, level, specialAttack);
	}
	
	public void setRepetitions(int min, int max) {
		this.numberOfRepeatsMin = min;
		this.numberOfRepeatsMax = max;
	}
	
	public String start(Pokemon self, Pokemon foe) {
		Random generator = new Random();
		
		int numberOfStrikes = generator.nextInt(numberOfRepeatsMax - numberOfRepeatsMin) + numberOfRepeatsMin;
		for (int i = 0; i < numberOfStrikes; i++) {
			System.out.println(super.start(self, foe));
		}
		
		return self.getName() + " hit " + foe.getName() + " " + numberOfStrikes + " times!";
		
	}

}
