// 2013 AP Problem #2 TokenPass
public class TokenPass {
	private int[] board;
	private int currentPlayer;
	
	public TokenPass(int playerCount){
		board = new int[playerCount];
		for(int i = 0; i < board.length; i++){
			board[i] = (int)(Math.random() * 10) + 1;
		}
		currentPlayer = (int)(Math.random() * playerCount);
	}
	public void distributeCurrentPlayerTokens(){
		int numTokens = board[currentPlayer];
		board[currentPlayer] = 0;
		if(currentPlayer + 1 != board.length){
			for(int i = currentPlayer + 1; i < board.length; i++){
				if(numTokens > 0){
					board[i] += 1;
					numTokens--;
				}
			}
		}
		while(numTokens > 0){
			for(int i = 0; i < board.length; i++){
				if(numTokens > 0){
					board[i] += 1;
					numTokens--;
				}
			}
		}
	}
}
