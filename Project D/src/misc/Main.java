package misc;

import java.util.Scanner;

import pokemon.Pikachu;
import pokemon.Pokemon;

public class Main {
	
	private Pokemon user;
	private Pokemon foe;
	private Pokemon[] yourPokemon, foesPokemon;
	private boolean gameOver;
	private int pokemonActiveFoe, pokemonActiveUser;
	
	
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		Main battle = new Main();
		battle.startMatch();
	}
	
	private void startMatch() {
		//Input Pokemons
				user = yourPokemon[0];
				foe = foesPokemon[0];
				
				
				//Start game loop
				while (!gameOver) {
					//Display Foe
					
					//Display User Pokemon
					
					//Display active Pokemon's moves
					
					//Input selected move
					
					//Select move for foe Pokemon
					
					//Run turn
					

					
					
					if (pokemonActiveFoe < 1) {
						gameOver = true;
						//Game won!
						
						System.out.println("YOU WIN!");
					} else if (pokemonActiveUser < 1) {
						gameOver = true;
						//Game lost
						System.out.println("All your Pokemon were knocked out...");
						System.out.println("You Lose");
					}
				}
				
				//Output results
	}
	
	
	private Main() {
		yourPokemon = new Pokemon[] {
				new Pikachu(1),
				new Pikachu(2, "Shocky"),
				new Pikachu(5, "Lightning"),
				new Pikachu(10, "Thor"),
				new Pikachu(20, "Zap Zap"),
				new Pikachu(50, "Palpatine")
			};
		foesPokemon = new Pokemon[] {
				new Pikachu(1),
				new Pikachu(2),
				new Pikachu(5),
				new Pikachu(10),
				new Pikachu(20),
				new Pikachu(50)
			};
	}
	
	
	private void getSelectedMoves() {
		
	}

}
