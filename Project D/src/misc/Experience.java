package misc;

public enum Experience {
	FAST,
	MEDIUM_FAST,
	MEDIUM_SLOW,
	SLOW,
	ERRATIC,
	FLUCTUATING;
	
	/**
	 * https://bulbapedia.bulbagarden.net/wiki/Experience
	 * This implementation is designed to work up until level 50
	 * @param Which level to evolve to
	 * @return Minimum experience required
	 */
	public int getExperienceToLevelUp(int desiredLevel) {
		switch (this) {
		case FAST:
			return (int) (4/5 * Math.pow(desiredLevel, 3));
		case MEDIUM_FAST:
			return (int) (Math.pow(desiredLevel, 3));
		case MEDIUM_SLOW:
			return (int) (6/5 * Math.pow(desiredLevel, 3) - 15*Math.pow(desiredLevel, 2) + 100*desiredLevel - 140);
		case SLOW:
			return (int) (5/4 * Math.pow(desiredLevel, 3));
		case ERRATIC:
			return (int) (Math.pow(desiredLevel, 3) * (100 - desiredLevel) / 50);
		case FLUCTUATING:
			if (desiredLevel < 16) {
				return (int) (Math.pow(desiredLevel, 3) * ((desiredLevel+1)/3 + 24)/50);
			} else if (desiredLevel < 37) {
				return (int) (Math.pow(desiredLevel, 3) * ( desiredLevel+14 )/50);
			} else {
				return (int) (Math.pow(desiredLevel, 3) * (desiredLevel/2 + 32)/50);
			}
		default:
			return -1;
		}
	}
}
