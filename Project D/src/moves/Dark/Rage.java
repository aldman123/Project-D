package moves.Dark;

import misc.Type;
import moves.Move_Recurring;
import pokemon.Pokemon;

public class Rage extends Move_Recurring {
	
	static private int basePower = 20;
	private boolean increaseRage;
	/**
	 * This move increases in power each turn
	 * @param learnLevel
	 */
	public Rage(int learnLevel) {
		super(basePower, 20, 100, "Rage", Type.DARK, learnLevel, false, 1, true);
		this.resetRage();
	}
	
	public void resetRage() {
		this.increaseRage = false;
		this.setPower(basePower);
	}
	
	public void increaseRage() {
		this.increaseRage = true;
	}
	
	public void start(Pokemon self, Pokemon foe) {
		if (increaseRage) {
			this.setPower(this.getPower() + 5);
		} else {
			resetRage();
		}
		super.start(self, foe);
		
	}

	protected void effect(Pokemon self, Pokemon foe) {
		this.increaseRage();
		System.out.println(self.getName() + " is getting angrier!");
	}
	

}
