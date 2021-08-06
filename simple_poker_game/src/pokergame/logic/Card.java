package pokergame.logic;

public class Card implements Comparable {
	// An Card have Suit and rank
	public int suit;
	public int rank;

	// Override CompareTo method from Comparable interface
	public int compareTo(Object o) {
		Card c = (Card) o;
		if (this.rank == (c.rank))
			return 0;
		else if ((this.rank) > (c.rank))
			return 1;
		else
			return -1;
	}
}
