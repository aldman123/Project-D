package misc;

import pokemon.Pokemon;
import pokemon.Fire.Torchic;

public class Test {
	public static void main(String args[]) {
		Pokemon torchic = new Torchic(15);
		torchic.displayPokemon();
		for (int i = 0; i < 4; i++) {
			torchic.resetStats();
			torchic.displayPokemon();
		}
		torchic.addExperience(100);
	}
}
