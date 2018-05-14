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
		switch (this) {
		case BURN:
			return "BRN";
		case FREEZE:
			return "FRZ";
		case PARALYSIS:
			return "PAR";
		case POISON:
			return "PSN";
		case SLEEP:
			return "SLP";
		default:
			return "";

		}
	}
	/**
	 * @return The pokemon was ___
	 */
	public String getEffect() {
		switch (this) {
		case BURN:
			return "BURNED";
		case FREEZE:
			return "FROZEN";
		case PARALYSIS:
			return "PARALYSED";
		case POISON:
			return "POISONED";
		case SLEEP:
			return "PUT TO SLEEP";
		default:
			return "LEFT THE SAME";
		}
	}
	/**
	 * @return The name of the effect
	 */
	public String getName() {
		switch (this) {
		case BURN:
			return "BURN";
		case FREEZE:
			return "FREEZE";
		case PARALYSIS:
			return "PARALYSIS";
		case POISON:
			return "POISON";
		case SLEEP:
			return "SLEEP";
		default:
			return "NOTHING";
		}
	}

	/**
	 * Calculate the effects of the move at the end of the turn
	 * @param self
	 * @param foe
	 */
	public void endOfTurn(Pokemon self) {
		switch (this) {
		case BURN:
			System.out.println(self.getName() + " was hurt by the BURN!");
			self.reduceHP(self.getMaxHP() / 8);
			wearOff(self, 5);
			break;
		case FREEZE:
			wearOff(self, 10);
			break;
		case PARALYSIS:
			wearOff(self, 5);
			break;
		case POISON:
			System.out.println(self.getName() + " was hurt by the POISON!");
			self.reduceHP(self.getMaxHP() / 8);
			wearOff(self, 5);
			break;
		case SLEEP:
			wearOff(self, 15);
			break;
		default:
			break;
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
