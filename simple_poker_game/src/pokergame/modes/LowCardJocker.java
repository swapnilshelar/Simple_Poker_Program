package pokergame.modes;

/*In Low Card Joker Mode 
 * Player needs to treat lowest card as Joker and makes best combination and bet that he has that Combination
 * */
import java.util.Scanner;

import pokergame.logic.WinnerDecider;

//LowCardJocker class inherits all properties and methods of WinnerDecider class
public class LowCardJocker extends WinnerDecider {
	int noOfPlayers;
	Scanner sc;
	boolean flagCard = true;
	boolean flagSeeCards = true;

	public LowCardJocker(int noOfPlayers) {
		super(noOfPlayers);
		this.noOfPlayers = noOfPlayers;
		sc = new Scanner(System.in);
	}

	// method states flow of Low card joker mode
	public void LowCardProcess() {
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
		sort(0);

		// User needs to treat lowest card as Joker
		System.out.println("Assumed Low card is jocker( " + suitNames[player[0][0].suit] + "  "
				+ rankNames[player[0][0].rank] + " )and make best combination...");

		// user can see order of rank and rank input respectively.
		// suit and suit input respectively
		sequenceOfSuitsAndRanks();

		do {
			// here user will select suit and rank for assumed card
			System.out.println("Select Suit for your card..");
			int suitOfCard = sc.nextInt();
			System.out.println("Select rank for your card..");
			int rankOfCard = sc.nextInt();
			if ((suitOfCard >= 1 && suitOfCard <= 4) && (rankOfCard >= 1 && rankOfCard <= 13)) {
				// Assumed Joker replaced by new card
				player[0][2].suit = suitOfCard - 1;
				player[0][2].rank = rankOfCard - 1;
				flagCard = false;
			} else {
				System.out.println("You selected wrong options ");
				flagCard = true;
			}
		} while (flagCard);

		// user will see his cards after making new combination
		System.out.println("Now, You bet that you have following cards");
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "." + suitNames[player[0][i].suit] + " " + rankNames[player[0][i].rank]);
		}

		// menu to display result, cards of other player will display
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
