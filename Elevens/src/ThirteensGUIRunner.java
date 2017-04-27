/**
 * The ThirteensGUIRunner class represents a variation of the ElevensGUIRunner GUI runner class.
 */
public class ThirteensGUIRunner {

	public static void main(String[] args) {
		Board board = new ThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
