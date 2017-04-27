import java.util.List;

/**
 * The ThirteensBoard class represents a variation of the ElevensBoard game..
 */

public class ThirteensBoard extends Board {

	private static final int BOARD_SIZE = 10;

	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

	 public ThirteensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		return (selectedCards.size() == 2 && containsPairSum13(selectedCards)) ||(selectedCards.size() == 1 && containsK(selectedCards));
	}
	
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cardsOnBoard = cardIndexes();
		return containsPairSum13(cardsOnBoard) || containsK(cardsOnBoard);
	}

	private boolean containsPairSum13(List<Integer> selectedCards) {
		for (int i = 0; i < selectedCards.size() - 1; i++) {
			int p1 = cardAt(selectedCards.get(i).intValue()).pointValue();
			for (int j = i + 1; j < selectedCards.size(); j++) {
				int p2 = cardAt(selectedCards.get(j).intValue()).pointValue();
				if (p1 + p2 == 13)
					return true;
			}
		}
		return false;
	}

	private boolean containsK(List<Integer> selectedCards) {
		return cardAt(selectedCards.get(0).intValue()).pointValue() == 0;
	}
}
