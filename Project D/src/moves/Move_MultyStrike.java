package moves;

import java.util.Random;

import misc.Type;
import pokemon.Pokemon;

public abstract class Move_MultyStrike extends Move {
	
	private int numberOfRepeatsMin = 2;	//Standard Value
	private int numberOfRepeatsMax = 5;	//Standard Value
	private String individualAttackDescription;
	
	public Move_MultyStrike(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack, String individualAttackDescription) {
		super(power, pp, accuracy, name, type, level, specialAttack);
		this.individualAttackDescription = individualAttackDescription;
	}
	
	public void setRepetitions(int min, int max) {
		this.numberOfRepeatsMin = min;
		this.numberOfRepeatsMax = max;
	}
	
	protected void start(Pokemon self, Pokemon foe) {
		Random generator = new Random();
		int numberOfStrikes;
		if (numberOfRepeatsMax - numberOfRepeatsMin < 1) {
			numberOfStrikes = numberOfRepeatsMin;
		} else {
			numberOfStrikes = generator.nextInt(numberOfRepeatsMax - numberOfRepeatsMin) + numberOfRepeatsMin;
		}
		for (int i = 0; i < numberOfStrikes; i++) {
			super.start(self, foe);
			System.out.println(individualAttackDescription);
		}
		
		System.out.println(self.getName() + " hit " + foe.getName() + " " + numberOfStrikes + " times!");
		
	}

}
