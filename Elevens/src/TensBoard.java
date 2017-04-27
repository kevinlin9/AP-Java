import java.util.ArrayList;
import java.util.List;

public class TensBoard extends Board {

	private static final int BOARD_SIZE = 13;

	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	 public TensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		return (selectedCards.size() == 2 && containsPairSum10(selectedCards)) ||(selectedCards.size() == 4 && containsQuartets(selectedCards));
	}
	
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cardsOnBoard = cardIndexes();
		return containsPairSum10(cardsOnBoard) || containsQuartets(cardsOnBoard);
	}

	private boolean containsPairSum10(List<Integer> selectedCards) {
		for (int i = 0; i < selectedCards.size() - 1; i++) {
			int p1 = cardAt(selectedCards.get(i).intValue()).pointValue();
			for (int j = i + 1; j < selectedCards.size(); j++) {
				int p2 = cardAt(selectedCards.get(j).intValue()).pointValue();
				if (p1 + p2 == 10)
					return true;
			}
		}
		return false;
	}

	private boolean containsQuartets(List<Integer> selectedCards) {
		int numTens = 0;
		int numJacks = 0;
		int numQueens = 0;
		int numKings = 0;
		List<String> cards = new ArrayList<String>();
		for (Integer i : selectedCards) {
			cards.add(cardAt(i.intValue()).rank());
		}
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals("10"))
				numTens++;
			else if (cards.get(i).equals("jack"))
				numJacks++;
			else if (cards.get(i).equals("queen"))
				numQueens++;
			else if (cards.get(i).equals("king"))
				numKings++;
		}
		return (numTens == 4 || numJacks == 4 || numQueens == 4 || numKings == 4);
		
	}
}
