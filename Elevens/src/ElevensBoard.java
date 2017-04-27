import java.util.ArrayList;
import java.util.List;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */

/*
 * Steps to Play a game of Elevens
 * -------------------------------
 * 1. Create the board and deck
 * 2. Shuffle the deck
 * 3. Deal the cards from the deck to the board
 * 4. Check if there are any legal plays
 * 		if there are any plays (a pair of cards that has a total point value of 11 or 3 cards that are a Jack, a Queen, and a King in any order), continue the game
 * 			replace cards until you have no more legal plays or when there are no cards left in the deck and on the board
 * 		otherwise, the game is over and you will have to restart the game from Step 2.
 * -------------------------------
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	//private static final boolean I_AM_DEBUGGING = false;

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		return (selectedCards.size() == 2 && findPairSum11().contains(selectedCards)) ||(selectedCards.size() == 3 && findJQK().contains(selectedCards));
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		return findPairSum11().size() > 0 || findJQK().size() > 0;
	}
	/*public boolean anotherPlayIsPossible() {
		List<Integer> cardsOnBoard = cardIndexes();
		return containsPairSum11(cardsOnBoard) || containsJQK(cardsOnBoard);
	}*/

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	/*private boolean containsPairSum11(List<Integer> selectedCards) { 
		for (int i = 0; i < selectedCards.size() - 1; i++) {
			int p1 = cardAt(selectedCards.get(i).intValue()).pointValue();
			for (int j = i + 1; j < selectedCards.size(); j++) {
				int p2 = cardAt(selectedCards.get(j).intValue()).pointValue();
				if (p1 + p2 == 11)
					return true;
			}
		}
		return false;
	}*/
	private List<Integer> findPairSum11() {
		List<Integer> cards = cardIndexes();
		List<Integer> pairList = new ArrayList<Integer>();
		for (int i = 0; i < cards.size() - 1; i++) {
			int p1 = cardAt(cards.get(i).intValue()).pointValue();
			for (int j = i + 1; j < cards.size(); j++) {
				int p2 = cardAt(cards.get(j).intValue()).pointValue();
				if (p1 + p2 == 11) {
					pairList.add(new Integer(i));
					pairList.add(new Integer(j));
					return pairList;
				}					
			}
		}
		return pairList;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	/*private boolean containsJQK(List<Integer> selectedCards) {
		boolean jackPresent = false;
		boolean queenPresent = false;
		boolean kingPresent = false;
		for (Integer i : selectedCards) {
			Card c = this.cardAt(i.intValue());
			if (c.rank().equals("jack"))
				jackPresent = true;
			else if (c.rank().equals("queen"))
				queenPresent = true;
			else if (c.rank().equals("king")) {
				kingPresent = true;
			}
		}
		return jackPresent && queenPresent && kingPresent;
	}*/
	
	private List<Integer> findJQK() {
		List<Integer> cards = cardIndexes();
		List<Integer> jqkList = new ArrayList<Integer>();
		boolean jackPresent = false;
		boolean queenPresent = false;
		boolean kingPresent = false;
		for (int i = 0; i < cards.size() && (!jackPresent && !queenPresent && !kingPresent); i++) {
			Card c = cardAt(cards.get(i).intValue());
			if (c.rank().equals("jack")) {
				jackPresent = true;
				jqkList.add(new Integer(i));
			}
			else if (c.rank().equals("queen")) {
				queenPresent = true;
				jqkList.add(new Integer(i));
			}
			else if (c.rank().equals("king")) {
				kingPresent = true;
				jqkList.add(new Integer(i));
			}
		}
		if (jackPresent && queenPresent && kingPresent)
			return jqkList;
		return new ArrayList<Integer>();
	}

	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		return playPairSum11IfPossible() || playJQKIfPossible();
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if an 11-pair play was found (and made); false othewise.
	 */
	private boolean playPairSum11IfPossible() {
		List<Integer> setOfCards = findPairSum11();
		if (setOfCards.size() > 0) {
			replaceSelectedCards(setOfCards);
			return true;
		}
		return false;
	}

	/**
	 * Looks for a group of three face cards JQK.
	 * If found, replace them with the next three cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if a JQK play was found (and made); false othewise.
	 */
	private boolean playJQKIfPossible() {
		List<Integer> setOfCards = findJQK();
		if (setOfCards.size() > 0) {
			replaceSelectedCards(setOfCards);
			return true;
		}
		return false;
	}
	
	/* helper method
	public static void printCards(ElevensBoard board) {
		List<Integer> cIndexes = board.cardIndexes();
		for (Integer i : cIndexes) {
			System.out.println(board.cardAt(i.intValue()));
			
		}
	}
	*/
}