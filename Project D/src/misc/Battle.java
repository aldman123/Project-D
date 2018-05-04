package misc;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import moves.Move;
import moves.Flying.MirrorMove;
import pokemon.*;

public class Battle {
	
	private final long WAIT_TIME = 1600;
	
	private Pokemon user, foe;
	private Pokemon[] yourPokemon, foesPokemon;
	private int pokemonActiveFoe, pokemonActiveUser;
	private boolean userGoesFirst;


	Scanner scanner = new Scanner(System.in);
	private Move selectedMoveUser, selectedMoveFoe, usersLastMove;
	
	public Battle() {
		yourPokemon = new Pokemon[] {
				new Pikachu(1),
				new Pikachu(10, "Thor"),
				new Torchic(2, "Burny"),
				new Raichu(5),
				new Combusken(20),
				new Blaziken(50)
		};
		foesPokemon = new Pokemon[] {
				new Torchic(1),
				new Pikachu(2, "Johney Torch"),
				new Combusken(5),
				new Raichu(10),
				new Blaziken(20),
				new Pikachu(50)
		};
		
	}
	
	public Battle(Pokemon[] yourPokemon, Pokemon[] foePokemon) {
		this.yourPokemon = yourPokemon;
		this.foesPokemon = foePokemon;
	}

	public void startMatch() throws InterruptedException {
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
				displayPokemon(foe);
				System.out.println(foe.getStatList());
				

				//Display User Pokemon
				System.out.println("YOUR Pokemon");
				displayPokemon(user);
				
				//Display active Pokemon's moves
				System.out.println(user.getMoveList());
				System.out.println(user.getStatList());
				
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
				
				//Uses lazy evaluation
				if (selectedMoveUser != null && selectedMoveUser.getPP() < 1) {
					System.out.println("");
					System.out.println("That move is out of PP!");
					selectedMoveUser = null;
					TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
				}
				
				if (selectedMoveUser == null) {
					System.out.println("");
					System.out.println("Please enter valid input");
					TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
				}
			}
			
			
			//Is someone using Mirror Move?
			if (selectedMoveUser instanceof MirrorMove) {
				if (selectedMoveFoe == null) {
					System.out.println(user.getName() + " failed to use " + selectedMoveUser.getName());
				} else {
					selectedMoveUser = selectedMoveFoe;
					System.out.println(user.getName() + " copied " + foe.getName() + "'s last move!");
				}
			}
			if (selectedMoveFoe instanceof MirrorMove) {
				if (usersLastMove == null) {
					System.out.println(foe.getName() + " failed to use " + selectedMoveFoe.getName());
				} else {
					selectedMoveFoe = usersLastMove;
					System.out.println(foe.getName() + " copied " + user.getName() + "'s last move!");
				}
			}

			
			//Select move for foe Pokemon
			Random generator = new Random();
			selectedMoveFoe = foe.getMove(generator.nextInt(foe.getNumberOfMoves()));
			
			

			//Who goes first?
			if (selectedMoveUser.isFast() && !(selectedMoveFoe.isFast())) {
				userGoesFirst = true;
			} else if (selectedMoveFoe.isFast() && !(selectedMoveUser.isFast())) {
				userGoesFirst = false;
			} else {
				userGoesFirst = user.getSpeed() >= foe.getSpeed();
			}
			
			
			//Run Turn
			if (userGoesFirst) {
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
			
			//Distribute experience
			if (foe.isKnockedOut() && user.isKnockedOut() == false) {
				System.out.println("Foe's Pokemon " + foe.getName() + " was knocked out!");
				user = user.addExperience((int) (foe.getBaseExperienceYield() * 1.5 * foe.getLevel()));
			} else if (user.isKnockedOut() && foe.isKnockedOut() == false) {
				System.out.println("Your Pokemon " + user.getName() + " was knocked out!");
				 foe = foe.addExperience((int) (user.getBaseExperienceYield() * 1.5 * user.getLevel()));
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
	
	
	private void displayPokemon(Pokemon pokemon) {
		System.out.println(pokemon.toString() + " " + pokemon.getStatus().toString());
		System.out.println("[HP:" + pokemon.getHP() +"/"+ pokemon.getMaxHP() + "]");
		System.out.println("");
	}

}
