package pokergame.logic;

/* Winner will decide on basis of following condition
 *      1-   All same number card
        2-   Sequence with Color 
        3-   Sequence without Color
        4-   Same color
        5-   Pair
        6-   Highest Cards Win*/
public class Deck {
	public final int size = 52;
	Card[] card;
	public Card player[][];
	// array of suit s and ranks
	public String suitNames[] = { "Spades", "Heart", "Clubs", "Diomands" };
	public String rankNames[] = { "Ace", "King", "Jack", "Queen", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

	public Deck(int noOfplayers) {
		card = new Card[size];
		player = new Card[noOfplayers][3];
	}

	// made this method to add cards in deck
	public void addCardsInDeck() {
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card[counter] = new Card();
				card[counter].suit = i;
				card[counter].rank = j;
				counter++;
			}
		}
	}

	// made this method to display cards that player have
	public void display(int noOfPlayers) {
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Cards of player no. " + (i + 1) + " ");
			for (int j = 0; j < 3; j++) {
				System.out.print((j + 1) + "." + suitNames[player[i][j].suit] + " " + rankNames[player[i][j].rank]+" | ");
			}
			System.out.println();
		}
	}

	// made this method to shuffle cards
	public void shuffle() {
		System.out.println("Cards are shuffled...");
		for (int i = 0; i < card.length / 2; i++) {
			int j = (int) (Math.random() * card.length);
			Card temp = card[i];
			card[i] = card[j];
			card[j] = temp;
		}
	}

	// user can see order of rank and rank input respectively. e.g Spades=1 ,
	// Heart=2 ...etc
	// suit and suit input respectively. e.g Ace=1, King=2, ...etc
	// it will help user to give input
	public void sequenceOfSuitsAndRanks() {
		for (int i = 0; i < suitNames.length; i++) {
			System.out.print(suitNames[i] + " = " + (i + 1) + " | ");
		}
		System.out.println();
		for (int i = 0; i < rankNames.length; i++) {
			System.out.print(rankNames[i] + " = " + (i + 1) + " | ");
		}
		System.out.println();
	}

	// made this method to distribute three cards to each player
	public void pickThreeCards(int noOfPlayers) {
		System.out.println("Cards are distributed among " + noOfPlayers + " players...");
		int count = 0;

		for (int j = 0; j < noOfPlayers; j++) {
			for (int i = 0; i < 3; i++) {
				player[j][i] = card[count];
				count++;
			}
		}

	}

	// made this method to sort cards of every player as per ranks
	public void sort(int i) {
		for (int j = 0; j < 3; j++) {
			for (int k = j + 1; k < 3; k++) {
				if (player[i][j].compareTo(player[i][k]) == 1) {
					Card temp = player[i][j];
					player[i][j] = player[i][k];
					player[i][k] = temp;
				}
			}
		}
	}

	// made this method to see whether player has all same number card
	public int sameRank(int i) {
		if ((player[i][0].rank == player[i][1].rank) && (player[i][1].rank == player[i][2].rank)) {
			return 1;
		} else {
			return 0;
		}
	}

	// made this method to see whether player has Sequence with Color
	public int pureSequence(int i) {
		if ((player[i][0].suit == player[i][1].suit) && (player[i][0].suit == player[i][2].suit)) {
			if ((player[i][0].rank - player[i][1].rank == -1) && (player[i][1].rank - player[i][2].rank == -1)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	// made this method to see whether player has Sequence without Color
	public int sequenceWithDiffColour(int i) {
		if ((player[i][0].rank - player[i][1].rank == -1) && (player[i][1].rank - player[i][2].rank == -1)
				&& (player[i][0].suit != player[i][1].suit)) {
			return 1;
		} else {
			return 0;
		}
	}

	// made this method to see whether player has cards of Same color
	public int sameColour(int i) {
		if ((player[i][0].suit == player[i][1].suit) && (player[i][0].suit == player[i][2].suit)) {
			return 1;
		} else {
			return 0;
		}
	}

	// made this method to see whether player has pair of two cards
	public int pairOfTwoCards(int i) {
		if ((player[i][0].rank == player[i][1].rank) || (player[i][1].rank == player[i][2].rank)) {
			return 1;
		} else {
			return 0;
		}
	}

}
