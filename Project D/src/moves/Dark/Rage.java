package moves.Dark;

import misc.Type;
import moves.Move;
import pokemon.Pokemon;

public class Rage extends Move {
	
	static private int basePower = 20;
	private boolean increaseRage;
	public Rage(int learnLevel) {
		super(basePower, 20, 100, "Rage", Type.DARK, learnLevel, false);
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
			System.out.println(self.getName() + "'s rage is rising!");
		} else {
			resetRage();
		}
		return super.start(self, foe);
		
	}
	

}
