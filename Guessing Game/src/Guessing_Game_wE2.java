
import java.util.Scanner;
public class Guessing_Game_wE2
{
	public static void main(String[] args)
	{
		int response = 1;
		int numOfGames = 1;
		int[] gameResults = new int[numOfGames];
		String[] levels = {"Beginner","Intermediate","Advanced","Expert"};
		int[] levelMaxRanges = {10,100,1000,10000};
		Scanner input = new Scanner(System.in);
			boolean gameStart = false;
			while (!gameStart)
			{
					displayMenuChoices(levels,levelMaxRanges);
					int levelChoice = input.nextInt();
					if (levelChoice <= levels.length && levelChoice >= 1)
					{
						gameStart = true;
						while (response == 1)
						{
							int result = playGame(levelChoice - 1,levelMaxRanges);
							gameResults[gameResults.length - 1] = result;
							System.out.println("Would you like to play again? Enter 1 for Yes or any other integer for No.");
							System.out.println();
							response = input.nextInt();
							if (response != 1){
								System.out.println("All Game Results");
								System.out.println("----------------");
								for(int i = 0; i < gameResults.length; i++){
									System.out.println("Game " + (i + 1) + ": " + gameResults[i] + " guesses");
								}
								System.out.println("---Exited Game---");
							}
							else{
								//increase the length of gameResults array and then insert the current games result into the new open space
								int[] tempArr = gameResults;
								numOfGames++;
								gameResults = new int[numOfGames];
								for(int i = 0; i < tempArr.length; i++){
									gameResults[i] = tempArr[i];
								}
							}
						}
					}
			}
	}
	public static void displayMenuChoices(String[] levels, int[] levelMaxRanges)
	{
		System.out.println("Pick a difficulty (Choose from the number options)");
		for(int i = 0; i < levels.length; i++)
		{
			System.out.println((i + 1) + ". " + levels[i] + " Range: 1 to " + levelMaxRanges[i] + ".");
		}
	}
	public static int playGame(int levelChoice, int[] levelMaxRanges)
	{
		boolean gameOver = false;
		int attempts = 0;
		int max = levelMaxRanges[levelChoice];
		int trueAnswer = getRandomInteger(1,max);
		Scanner userInput = new Scanner(System.in);
		while (!gameOver)
		{
			System.out.println("Please type in a number between 1 and " + max + ". I won't count guesses out of this range!");
			int guess = userInput.nextInt();
			if (guess >= 1 && guess <= max)
			{
				if (guess > trueAnswer)
				{
					System.out.println("Too High!");
					attempts++;
				}					
				else
				{
					if (guess < trueAnswer)
					{
						System.out.println("Too Low!");
						attempts++;
					}
					else
					{
						attempts++;
						System.out.println("You did it! The number is " + trueAnswer + ". You took " + attempts + " guesses to get to the answer.");
						System.out.println();
						gameOver = true;
					}
				}
			}
			else
			{
				System.out.println("Please type in a valid number in the range (1 to " + max + ").");
				System.out.println("You will not gain an attempt for inputting an invalid number.");
				System.out.println();
			}
		}
		System.out.println(attempts);
		return attempts;		
	}
	public static int getRandomInteger(int min, int max){
		int result = (int)(min + Math.random() * (max - min) + 1);
		return result;
	}
}