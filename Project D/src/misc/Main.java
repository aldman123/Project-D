package misc;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import moves.Move;
import pokemon.*;

public class Main {
	
	private final long WAIT_TIME = 1600;
	
	private Pokemon user, foe;
	private Pokemon[] yourPokemon, foesPokemon;
	private int pokemonActiveFoe, pokemonActiveUser;


	Scanner scanner = new Scanner(System.in);
	Move selectedMoveUser, selectedMoveFoe;
	public static void main(String[] args) {

		Main battle = new Main();
		try {
			battle.startMatch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Main() {
		yourPokemon = new Pokemon[] {
				new Pikachu(1),
				new Pikachu(10, "Thor"),
				new Torchic(2, "Burny"),
				new Pikachu(5, "Lightning"),
				new Combusken(20, "Flame On"),
				new Combusken(50, "Get Burned")
		};
		foesPokemon = new Pokemon[] {
				new Torchic(1),
				new Pikachu(2, "Johney Torch"),
				new Torchic(5, "Ma Lighter"),
				new Pikachu(10, "Ma Lightning"),
				new Combusken(20, "Ma Fire"),
				new Pikachu(50)
		};
	}

	private void startMatch() throws InterruptedException {
		//Input Pokemons
		user = yourPokemon[0];
		foe = foesPokemon[0];
		calculateActivePokemon();

		//Start game loop
		while (pokemonActiveUser > 0 && pokemonActiveFoe > 0) {
			
			if (user.isKnockedOut()) {
				System.out.println(user.getName() + " was sent out!");
				user = yourPokemon[6 - pokemonActiveUser];
				System.out.println("Go " + user.getName() + "!");
			}
			
			if (foe.isKnockedOut()) {
				System.out.println(foe.getName() + " was knocked out!");
				foe = foesPokemon[6 - pokemonActiveFoe];
				System.out.println("Go " + foe.getName() + "!");
			}
			
			
			//Input selected move
			selectedMoveUser = null;
			while (selectedMoveUser == null) {
				
				//Display Foe
				System.out.println("FOE Pokemon");
				System.out.println(foe.toString() + " " + foe.getStatus().toString());
				System.out.println("[HP:" + foe.getHP() +"/"+ foe.getMaxHP() + "]");
				System.out.println("");

				//Display User Pokemon
				System.out.println("YOUR Pokemon");
				System.out.println(user.toString() + " " + foe.getStatus().toString());
				System.out.println("[HP:" + (user.getHP() +"/"+ user.getMaxHP()) + "]");
				
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
					for (int i = 0; i < user.getNumberOfMoves(); i++) {
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
			selectedMoveFoe = foe.getMove(generator.nextInt(foe.getNumberOfMoves()));
			

			//Run turn
			if (user.getSpeed() >= foe.getSpeed()) {
				System.out.println(selectedMoveUser.start(user, foe));
				TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
				System.out.println(selectedMoveFoe.start(foe, user));
				TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
			} else {
				System.out.println(selectedMoveFoe.start(foe, user));
				TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
				System.out.println(selectedMoveUser.start(user, foe));
				TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
			}
			
			
			calculateActivePokemon();
			System.out.println("");
			System.out.println("----");
			System.out.println("");
		}
		//Output results
		if (pokemonActiveFoe < 1) {
			//Game won!

			System.out.println("YOU WIN!");
		} else if (pokemonActiveUser < 1) {
			//Game lost
			System.out.println("All your Pokemon were knocked out...");
			System.out.println("You Lose");
		}
	}
	
	private void calculateActivePokemon() {
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
	}

}
