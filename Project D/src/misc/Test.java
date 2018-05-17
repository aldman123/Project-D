package misc;

import pokemon.Pokemon;
import pokemon.Grass.Venausaur;

public class Test {
	public static void main(String args[]) {
		Pokemon[] foePokemon = new Pokemon[] {
				new Venausaur(50)
		};
		
		Pokemon[] yourPokemon = new Pokemon[] {
				new Venausaur(50)
		};
		Battle game = new Battle(yourPokemon, foePokemon);
		try {
			game.startMatch();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
