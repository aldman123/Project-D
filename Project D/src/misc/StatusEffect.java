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
			return "[BRN]";
		} else if (this == FREEZE) {
			return "[FRZ]";
		} else if (this == PARALYSIS) {
			return "[PAR]";
		} else if (this == POISON) {
			return "[PSN]";
		} else if (this == SLEEP) {
			return "[SLP]";
		} else {
			return "";
		}
	}
}
