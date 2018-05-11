package misc;

import java.util.Random;

import pokemon.Pokemon;

public enum StatusEffect {
	BURN,
	FREEZE,
	PARALYSIS,
	POISON,
	SLEEP,
	NOTHING;
	
	
	/**
	 * @return The 3 char shorthand for the effect
	 */
	public String toString() {
		if (this == BURN) {
			return "BRN";
		} else if (this == FREEZE) {
			return "FRZ";
		} else if (this == PARALYSIS) {
			return "PAR";
		} else if (this == POISON) {
			return "PSN";
		} else if (this == SLEEP) {
			return "SLP";
		} else {
			return "";
		}
	}
	/**
	 * @return The pokemon was ___
	 */
	public String getEffect() {
		if (this == BURN) {
			return "BURNED";
		} else if (this == FREEZE) {
			return "FROZEN";
		} else if (this == PARALYSIS) {
			return "PARALYSED";
		} else if (this == POISON) {
			return "POISONED";
		} else if (this == SLEEP) {
			return "PUT TO SLEEP";
		} else {
			return "LEFT THE SAME";
		}
	}
	/**
	 * @return The name of the effect
	 */
	public String getName() {
		if (this == BURN) {
			return "BURN";
		} else if (this == FREEZE) {
			return "FREEZE";
		} else if (this == PARALYSIS) {
			return "PARALYSIS";
		} else if (this == POISON) {
			return "POISON";
		} else if (this == SLEEP) {
			return "SLEEP";
		} else {
			return "NOTHING";
		}
	}
	
	/**
	 * Calculate the effects of the move at the end of the turn
	 * @param self
	 * @param foe
	 */
	public void endOfTurn(Pokemon self) {
		if (this == BURN) {
			System.out.println(self.getName() + " was hurt by the BURN!");
			self.reduceHP(self.getMaxHP() / 8);
			wearOff(self, 5);
		} else if (this == FREEZE) {
			wearOff(self, 10);
		} else if (this == PARALYSIS) {
			wearOff(self, 5);
		} else if (this == POISON) {
			System.out.println(self.getName() + " was hurt by the POISON!");
			self.reduceHP(self.getMaxHP() / 8);
			wearOff(self, 5);
		} else if (this == SLEEP) {
			wearOff(self, 15);
		}
	}
	
	/**
	 * Calculate whether the effect wears off or not
	 * @param self
	 * @param percentChance
	 */
	private void wearOff(Pokemon self, int percentChance) {
		Random generator = new Random();
		if (generator.nextInt(100) < percentChance) {
			self.setStatus(NOTHING);
			if (this != SLEEP) {
				System.out.println(self.getName() + "'s " + this.getName() + " wore off!");
			} else {
				System.out.println(self.getName() + " woke up!");
			}
		}
	}
	
}
