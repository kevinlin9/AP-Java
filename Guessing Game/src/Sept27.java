import java.util.Scanner;
public class Sept27 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		boolean ok = false;
		int menuChoice = 0;
		String[] levels = {"Beginner","Intermediate","Advanced","Expert"};
		String menuMsg = "";
		for (int i = 0; i < levels.length; i++){
			menuMsg = (i + 1) + ". " + levels[i] + "     ";
		}
		while (attempts <3 && !ok){
		if (attempts > 0)
			System.out.println("You must provide a valid level!");
		System.out.println(menuMsg);		
		System.out.println("Enter valid level: ");
		menuChoice = scanner.nextInt();
		if (menuChoice > 0 && menuChoice < 5){
			ok = true;
			System.out.println("You chose the " + levels[menuChoice - 1] + " level.");
		}
		else{
			attempts++;
			System.out.println("Invalid level...");
			if (attempts == 3)
				System.out.println("You've used up all your attempts. Goodbye.");
		}
		System.out.println();
		}
	}

}
