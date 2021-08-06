package pokergame.modes;

/*In Any Card Joker Mode 
 * Player can assume any card as Joker and makes best combination and bet that he has that Combination
 * */
import java.util.Scanner;

import pokergame.logic.WinnerDecider;

//AnyCardJocker class inherits all properties and methods of WinnerDecider class
public class AnyCardJocker extends WinnerDecider {
	int noOfPlayers;
	Scanner sc;
	boolean flagCard = true;
	boolean flagCardChoice = true;
	boolean flagSeeCards = true;

	public AnyCardJocker(int noOfPlayers) {
		super(noOfPlayers);
		this.noOfPlayers = noOfPlayers;
		sc = new Scanner(System.in);
	}

	// method states flow of any card joker mode
	public void AnyCardProcess() {
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

		// here joker card is assumed and any best combination can be make
		do {
			// here user will assume joker card
			System.out.println("Select card you want to Assume joker...");
			int jockerCard = sc.nextInt();
			if (jockerCard >= 1 && jockerCard <= 3) {
				System.out.println("Reset card and make best combination...");

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
						player[0][jockerCard - 1].suit = suitOfCard - 1;
						player[0][jockerCard - 1].rank = rankOfCard - 1;
						flagCard = false;
					} else {
						System.out.println("You selected wrong options ");
						flagCard = true;
					}
				} while (flagCard);
				flagCardChoice = false;
			} else {
				System.out.println("You selected wrong options ");
				flagCardChoice = true;
			}
		} while (flagCardChoice);

		// user will see his cards after making new combination
		System.out.println("Now, You bet that you have following cards");
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
