package moves;

import java.util.Random;

import misc.StatusEffect;
import misc.Type;
import pokemon.Pokemon;

public abstract class Move_StatusEffect extends Move {
	
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
		Pokemon target;
		if (onSelf) {
			target = self;
		} else {
			target = foe;
		}
		
		if (new Random().nextInt(100) <= probability) {
			target.setStatus(newStatus);
			System.out.println(target.getName() + " was " + newStatus.getEffect() + "!");
		}
		
		return super.start(self, foe);
	}

}
