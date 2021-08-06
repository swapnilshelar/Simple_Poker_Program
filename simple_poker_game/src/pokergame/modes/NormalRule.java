package pokergame.modes;

//In Normal rule mode normal rules are applied
import java.util.Scanner;

import pokergame.logic.WinnerDecider;

//NormalRule class inherits all properties and methods of WinnerDecider class
public class NormalRule extends WinnerDecider {
	int noOfPlayers;
	boolean flagSeeCards = true;
	Scanner sc;

	public NormalRule(int noOfPlayers) {
		super(noOfPlayers);
		this.noOfPlayers = noOfPlayers;
		sc = new Scanner(System.in);
	}

	public void normalMode() {
		// fill and shuffle cards in deck
		addCardsInDeck();
		shuffle();
		// three cards distributed to each player
		pickThreeCards(noOfPlayers);

		// after distribution user will get to see your card
		System.out.println("See your cards....");
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "." + suitNames[player[0][i].suit] + " " + rankNames[player[0][i].rank]);
		}

		// result will display, cards of other players will display
		do {
			System.out.println("_____Result Menu_____");
			System.out.println("1.To see result...");
			System.out.println("2.To see cards of all players...");
			System.out.println("3.To go back to Main Menu");
			System.out.println("Enter your choice...");
			int choice = sc.nextInt();
			if (choice == 1) {
				findOutWinner();

			} else if (choice == 2) {
				display(noOfPlayers);
			} else if (choice == 3) {
				System.out.println("Thanks for playing!");
				flagSeeCards = false;
			} else {
				System.out.println("you entered Wrong choice ");
			}
		} while (flagSeeCards);
	}
}
