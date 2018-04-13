package misc;

import java.util.Random;
import java.util.Scanner;

import moves.Move;
import pokemon.*;

public class Main {

	private Pokemon user, foe;
	private Pokemon[] yourPokemon, foesPokemon;
	private boolean gameOver;
	private int pokemonActiveFoe, pokemonActiveUser;


	Scanner scanner = new Scanner(System.in);
	Move selectedMoveUser, selectedMoveFoe;
	public static void main(String[] args) {

		Main battle = new Main();
		battle.startMatch();
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
				new Torchic(1, "Johney Torch"),
				new Pikachu(2),
				new Torchic(5, "Ma Lighter"),
				new Pikachu(10, "Ma Lightning"),
				new Torchic(20, "Ma Fire"),
				new Pikachu(50)
		};
	}

	private void startMatch() {
		//Input Pokemons
		user = yourPokemon[0];
		foe = foesPokemon[0];


		//Start game loop
		while (!gameOver) {
			pokemonActiveUser = 0;
			pokemonActiveFoe = 0;
			for (Pokemon pokemon : yourPokemon) {
				if (pokemon.isKnockedOut() == false) {
					pokemonActiveUser++;
				}
			}
			
			for (Pokemon pokemon : foesPokemon) {
				if (pokemon.isKnockedOut() == false) {
					pokemonActiveFoe++;
				}
			}
			
			
			//Input selected move
			selectedMoveUser = null;
			while (selectedMoveUser == null) {
				
				//Display Foe
				System.out.println("FOE Pokemon");
				System.out.println(foe.toString() + " " + foe.getStatus().toString());
				System.out.println("[HP:" + (foe.getHP() / foe.getMaxHP() * 100) + "%]");
				System.out.println("");

				//Display User Pokemon
				System.out.println("YOUR Pokemon");
				System.out.println(user.toString() + " " + foe.getStatus().toString());
				System.out.println("[HP:" + (user.getHP() / user.getMaxHP() * 100) + "%]");
				
				//Display active Pokemon's moves
				String moveList = "[";
				for (int i = 0; i < 4; i++) {
					if (user.getMove(i) != null) {
						if (i > 0) {
							moveList += ", ";
						}
						moveList += user.getMove(i).getName();
					} else {
						break;
					}
				}
				
				moveList += "]";
				
				System.out.println(moveList);
				
				System.out.print("Select Move: ");
				String input = scanner.next().trim().toUpperCase();
				
				if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
					selectedMoveUser = user.getMove(Integer.parseInt(input) - 1);
				} else {
					for (int i = 0; i < 4; i++) {
						if (user.getMove(i).toString().trim().toUpperCase() == input) {
							selectedMoveUser = user.getMove(i);
						}
					}
				}
				
				if (selectedMoveUser == null) {
					System.out.println("Please enter valid input");
				}
			}
			

			//Select move for foe Pokemon
			Random generator = new Random();
			selectedMoveFoe = foe.getMove(generator.nextInt(4));
			

			//Run turn
			if (user.getSpeed() >= foe.getSpeed()) {
				System.out.println(selectedMoveUser.start(user, foe));
				System.out.println(selectedMoveFoe.start(foe, user));
			} else {
				System.out.println(selectedMoveFoe.start(foe, user));
				System.out.println(selectedMoveUser.start(user, foe));
			}



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

}
