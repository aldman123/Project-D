package misc;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("-------------------------------------------");
		System.out.println("Pokemon Battle Engine by Alexander Aldridge");
		System.out.println("-------------------------------------------");
		System.out.println("Use your six Pokemon to defeat the Foe's six Pokemon!");
		System.out.println("Select a move to tell your Pokemon to use by inputting a number from 1-4");
		System.out.println("Good luck!");
		System.out.println();
		System.out.println();
		Battle battle = new Battle();
		try {
			battle.startMatch();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
