//@author Kevin Lin
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PaintingReader {
		public static void main(String[] args) throws Exception{
			String fileName = "Paintings.csv";
			File inputFile = new File(fileName);
			if(!inputFile.exists())
				System.out.println("Files does not exist.");
			else {
				Scanner input = new Scanner(inputFile);
				ArrayList<Painting> myPaintings = new ArrayList<Painting>();
				input.nextLine();
				String rowOfData, name, author, condition, genre, origin;
				String[] splitRowOfData;
				while (input.hasNextLine()) {
					rowOfData = input.nextLine();
					splitRowOfData = rowOfData.split(",");
					name = splitRowOfData[0];
					author = splitRowOfData[1];
					condition = splitRowOfData[2];
					genre = splitRowOfData[6];
					origin = splitRowOfData[7];
					int cost = Integer.parseInt(splitRowOfData[3]);
					int length = Integer.parseInt(splitRowOfData[4]);
					int width = Integer.parseInt(splitRowOfData[5]);
					int dateCreated = Integer.parseInt(splitRowOfData[8]);
					myPaintings.add(new Painting(name, author, condition, cost, length, width, genre, origin, dateCreated));
				}
				Paintings paintingCollection = new Paintings(myPaintings);
				input.close();
				
				Scanner response = new Scanner(System.in);
				System.out.println("--- Paintings Database Collection by Kevin Lin ---");
				System.out.println("The format of the database will be:");
				System.out.println("Name: " + "  Author: " + "  Condition: " + "  Cost: $" + "  Length: " + "cm  Width: " + "cm  Genre: " + "  Origin: " + "  Date Created:   ");
				System.out.println("Please press enter to continue.");
				String r = response.nextLine();				
				System.out.println(paintingCollection);
								
				System.out.println("Sorting by Author...");
				System.out.println("Please press enter to continue.");
				r = response.nextLine();
				paintingCollection.sortByAuthor();
				System.out.println(paintingCollection);
				
				System.out.println("Sorting by Cost...");
				System.out.println("Please press enter to continue.");
				r = response.nextLine();
				paintingCollection.sortByCost();
				System.out.println(paintingCollection);
				
				System.out.println("Sorting by Date Created...");
				System.out.println("Please press enter to continue.");
				r = response.nextLine();
				paintingCollection.sortByDateCreated();
				System.out.println(paintingCollection);
				
				System.out.println("Sorting by Genre...");
				System.out.println("Please press enter to continue.");
				r = response.nextLine();
				paintingCollection.sortByGenre();
				System.out.println(paintingCollection);
				
				System.out.println("Enter the name of the painting you wish to find: ");
				String paintingName = response.nextLine();
				System.out.println("Enter the name of the author of the painting you wish to find: ");
				String authorName = response.nextLine();
				System.out.println("Finding " + paintingName + " by " + authorName + "...");
				System.out.println(paintingCollection.findPainting(paintingName, authorName));
				
				r = null;
				while(r == null){
					System.out.println("Enter the name of the Author to find his or her paintings: ");
					r = response.nextLine();
				}
				System.out.println(paintingCollection.getPaintingsByAuthor(r));
				
				r = null;
				while(r == null){
					System.out.println("Enter the genre name to find paintings of that genre: ");
					r = response.nextLine();
				}
				System.out.println(paintingCollection.getPaintingByGenre(r));
				
				System.out.println("Calculating average cost of all paintings... ");
				System.out.println("Please press enter to continue.");
				r = response.nextLine();
				System.out.println("Average cost of paintings: $" + paintingCollection.getAverageCost());
				
				System.out.println("--- Painting Database Shutting Down. Good Bye. ---");
			}
		}
}
