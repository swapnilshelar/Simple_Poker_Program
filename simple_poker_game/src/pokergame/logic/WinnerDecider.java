package pokergame.logic;

import java.util.Arrays;

//WinnerDecider class inherits all properties and methods of deck class
public class WinnerDecider extends Deck {
	int noOfPlayers;
	int arrOfPlayers[];

	public WinnerDecider(int noOfPlayers) {
		// Initializing parent class constructor
		super(noOfPlayers);
		// Initializing variables
		this.noOfPlayers = noOfPlayers;
		arrOfPlayers = new int[noOfPlayers];
	}

	// made this method to find winner by comparing cards of all players with each
	// other
	public void findOutWinner() {
		int k;
		// array of players 1,2,3,4...
		for (int i = 0; i < arrOfPlayers.length; i++) {
			arrOfPlayers[i] = i;
		}

		// sort players based on comparison
		for (int i = 0; i < arrOfPlayers.length; i++) {
			for (int j = i + 1; j < arrOfPlayers.length; j++) {
				k = compareTwoPlayer(arrOfPlayers[i], arrOfPlayers[j]);
				if (k == arrOfPlayers[j]) {
					int temp = arrOfPlayers[i];
					arrOfPlayers[i] = arrOfPlayers[j];
					arrOfPlayers[j] = temp;
				}
			}
		}

		// Declaring winner of game
		if ((arrOfPlayers[0] + 1) == 1) {
			System.out.println("Winner of game is you");
			System.out.println("Congrats!");
		} else {
			System.out.println("Winner of game is player number " + (arrOfPlayers[0] + 1));
			System.out.println("Better Luck Next Time...");
		}
	}

	// compare cards of two players and return most prior player number
	// Comparison between i and j number player

	public int compareTwoPlayer(int i, int j) {
		// cards sorted according to rank of card
		sort(i);
		sort(j);
		// Comparison based on same rank
		if (sameRank(i) == 1) {
			return i;
		} else if (sameRank(j) == 1) {
			return j;
		}
		// comparison based on pure Sequence
		// if both players has pure sequence then comparison based on high rank card
		if (pureSequence(i) == 1 && pureSequence(j) == 1) {
			if (player[i][0].rank <= player[j][0].rank) {
				return i;
			} else {
				return j;
			}
		} else if (pureSequence(i) == 1) {
			return i;
		} else if (pureSequence(j) == 1) {
			return j;
		}
		// comparison based on players has sequence with different color
		if (sequenceWithDiffColour(i) == 1 && sequenceWithDiffColour(j) == 1) {
			if (player[i][0].rank <= player[j][0].rank) {
				return i;
			} else {
				return j;
			}
		} else if (sequenceWithDiffColour(i) == 1) {
			return i;
		} else if (sequenceWithDiffColour(j) == 1) {
			return j;
		}
		// comparison based on players with same color cards
		if (sameColour(i) == 1 && sameColour(j) == 1) {
			if (player[i][0].rank <= player[j][0].rank) {
				return i;
			} else {
				return j;
			}
		} else if (sameColour(i) == 1) {
			return i;
		} else if (sameColour(j) == 1) {
			return j;
		}
		// comparison based on players has pair of cards
		if (pairOfTwoCards(i) == 1 && pairOfTwoCards(j) == 1) {
			if (player[i][1].rank <= player[j][1].rank) {
				return i;
			} else {
				return j;
			}
		} else if (pairOfTwoCards(i) == 1) {
			return i;
		} else if (pairOfTwoCards(j) == 1) {
			return j;
		} else {
			if (player[i][0].rank <= player[j][0].rank) {
				return i;
			} else {
				return j;
			}
		}
	}

}
