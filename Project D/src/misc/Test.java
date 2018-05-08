package misc;

import pokemon.Pokemon;
import pokemon.Torchic;

public class Test {
	public static void main(String args[]) {
		Pokemon torchic = new Torchic(15);
		displayPokemon(torchic);
		for (int i = 0; i < 4; i++) {
			torchic.resetStats();
			displayPokemon(torchic);
		}
		torchic.addExperience(100);
	}
	
	private static void displayPokemon(Pokemon pokemon) {
		System.out.println(pokemon.toString() + " " + pokemon.getStatus().toString());
		System.out.println("[HP:" + pokemon.getHP() +"/"+ pokemon.getMaxHP() + ", " + pokemon.getExperience() + "]");
	}
}
