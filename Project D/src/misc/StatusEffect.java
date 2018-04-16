package misc;

public enum StatusEffect {
	BURN,
	FREEZE,
	PARALYSIS,
	POISON,
	SLEEP,
	NOTHING;
	
	
	
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
}
