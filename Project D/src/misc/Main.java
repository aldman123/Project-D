package misc;

public class Main {
	
	public static void main(String[] args) {

		Battle battle = new Battle();
		try {
			battle.startMatch();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
