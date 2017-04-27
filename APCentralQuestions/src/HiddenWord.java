import java.util.Scanner;

// 2015 AP Problem #2
public class HiddenWord {
	private String word;
	
	public HiddenWord(String hWord){
		this.word = hWord;
	}
	public String getWord(){
		return word;
	}
	public String getHint(String guess){
		if(guess.length() != word.length())
			return "Your guess isn't the same length as the word you stupid duwang!";
		else{
			String hint = "";
			for(int i = 0; i < word.length(); i++){
				if(word.substring(i, i + 1).equals(guess.substring(i, i + 1))){
					hint += word.substring(i, i + 1);
				}
				else{
					if(word.contains(guess.substring(i, i + 1))){
						hint += "+";
					}
					else{
						hint += "-";
					}
				}
			}
			return hint;
		}
	}	
	
	public static void main(String[] args) {
		HiddenWord theWord = new HiddenWord("THEWORLD");
		int theWordLength = theWord.getWord().length();
		Scanner reader = new Scanner(System.in);
		String guess = "";
		boolean playingGame = true;
		int counter = 0;
		System.out.println("*** It's time to play Guess the Hidden Word! ***");
		while(playingGame){
			System.out.println("Enter a guess. The word is all CAPITALIZED and the length of the hidden word is " + theWordLength);
			guess = reader.nextLine();
			System.out.println(theWord.getHint(guess));
			counter++;
			System.out.print(" Number of guesses: " + counter + ". ");			
			if(guess.equals(theWord.getWord()))
				playingGame = false;
		}
		reader.close();
		System.out.println("Congratulations! The word was " + theWord.getWord());
	}
}
