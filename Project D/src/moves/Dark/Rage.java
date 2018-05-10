package moves.Dark;

import misc.Type;
import moves.Move_Recurring;
import pokemon.Pokemon;

public class Rage extends Move_Recurring {
	
	static private int basePower = 20;
	private boolean increaseRage;
	public Rage(int learnLevel) {
		super(basePower, 20, 100, "Rage", Type.DARK, learnLevel, false, 1);
		this.resetRage();
	}
	
	public void resetRage() {
		this.increaseRage = false;
		this.setPower(basePower);
	}
	
	public void increaseRage() {
		this.increaseRage = true;
	}
	
	public String start(Pokemon self, Pokemon foe) {
		if (increaseRage) {
			this.setPower(this.getPower() + 5);
		} else {
			resetRage();
		}
		return super.start(self, foe);
		
	}

	protected String effect(Pokemon self, Pokemon foe) {
		this.increaseRage();
		return self.getName() + " is getting angrier!";
	}
	

}
