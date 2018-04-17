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
				System.out.println("[HP:" + (foe.getHP() + "/" + foe.getMaxHP()) + "]");
				System.out.println("");

				//Display User Pokemon
				System.out.println("YOUR Pokemon");
				System.out.println(user.toString() + " " + foe.getStatus().toString());
				System.out.println("[HP:" + (user.getHP() + "/" + user.getMaxHP()) + "]");
				
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
			int foesMoves = 0;
			for (int i = 0; i < 4; i++) {
				if (foe.getMove(i) != null) {
					foesMoves++;
				}
			}
			selectedMoveFoe = foe.getMove(generator.nextInt(foesMoves));
			

			//Run turn
			if (user.getSpeed() >= foe.getSpeed()) {
				if (user.isKnockedOut() == false) {
					System.out.println(user.getName() + " used " + selectedMoveUser.getName() + "!");
					System.out.println(selectedMoveUser.start(user, foe));
				}
				if (foe.isKnockedOut() == false) {
					System.out.println(foe.getName() + " used " + selectedMoveFoe.getName() + "!");
					System.out.println(selectedMoveFoe.start(foe, user));
				}
			} else {
				if (foe.isKnockedOut() == false) {
					System.out.println(foe.getName() + " used " + selectedMoveFoe.getName() + "!");
					System.out.println(selectedMoveFoe.start(foe, user));
				}
				if (user.isKnockedOut() == false) {
					System.out.println(user.getName() + " used " + selectedMoveUser.getName() + "!");
					System.out.println(selectedMoveUser.start(user, foe));
				}
			}

			
			//Is anyone knocked out?
			if (user.isKnockedOut()) {
				System.out.println(user.getName() + " fainted!");
				pokemonActiveUser--;
				user = yourPokemon[6 - pokemonActiveUser];
				user.resetStats();
				System.out.println(user.getName() + " was sent out!");
			}
			
			if (foe.isKnockedOut()) {
				System.out.println(foe.getName() + " fainted!");
				pokemonActiveFoe--;
				foe = foesPokemon[6 - pokemonActiveFoe];
				foe.resetStats();
				System.out.println(foe.getName() + " was sent out!");
			}
			
			System.out.println("");
			
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
