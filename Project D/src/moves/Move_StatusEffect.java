package moves;

import java.util.Random;

import misc.StatusEffect;
import misc.Type;
import pokemon.Pokemon;

public class Move_StatusEffect extends Move {
	
	private boolean onSelf = false;
	private StatusEffect newStatus;
	private int probability;
	public Move_StatusEffect(int power, int pp, int accuracy, String name, Type type, int level, boolean specialAttack,
			StatusEffect newStatus, int probability, boolean onSelf) {
		super(power, pp, accuracy, name, type, level, specialAttack);
		
		this.onSelf = onSelf;
		this.newStatus = newStatus;
		this.probability = probability;
	}
	
	public String start(Pokemon self, Pokemon foe) {
		System.out.println(super.start(self, foe));
		Pokemon target;
		if (onSelf) {
			target = self;
		} else {
			target = foe;
		}
		
		if (new Random().nextInt(100) <= probability) {
			target.setStatus(newStatus);
			return target.getName() + " was " + newStatus.getEffect() + "!";
		} else {
			return target.getName() + " was not " + newStatus.getEffect().toLowerCase() + "...";
		}
	}

	public Move clone() {
		return new Move_StatusEffect(
				this.getPower(), this.getPP(), this.getAccuracy(), this.getName(), this.getType(),
				this.getLearnLevel(), this.getSpecialAttack(), newStatus, probability, onSelf
				);
	}

}
