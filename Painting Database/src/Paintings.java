//@author Kevin Lin	
import java.util.ArrayList;
public class Paintings {
	private ArrayList<Painting> paintings;
	
	public Paintings(ArrayList<Painting> thePaintings){
		paintings = thePaintings;
	}
	public String toString(){
		String output = "";
		for(Painting painting : paintings)
			output += painting.toString() + "\n";
		output += "\n";
		return output;
	}
	private static void swap(ArrayList<Painting> arr,int valueIndex, int pivotIndex){
		arr.set(valueIndex, arr.set(pivotIndex, arr.get(valueIndex)));
	}
	public void sortByAuthor(){
		for(int j = 0; j < paintings.size() - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < paintings.size(); k++)
				if(paintings.get(k).getAuthor().compareTo(paintings.get(minIndex).getAuthor()) < 0 )
					minIndex = k;
			swap(paintings, minIndex, j);
		}
	}
	public void sortByCost(){
		for(int j = 0; j < paintings.size() - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < paintings.size(); k++)
				if(paintings.get(k).getCost() > paintings.get(minIndex).getCost())
					minIndex = k;
			swap(paintings, minIndex, j);
		}
	}
	public void sortByDateCreated(){
		for(int j = 0; j < paintings.size() - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < paintings.size(); k++)
				if(paintings.get(k).getDateCreated() > paintings.get(minIndex).getDateCreated())
					minIndex = k;
			swap(paintings, minIndex, j);
		}
	}
	public void sortByGenre(){
		for(int j = 0; j < paintings.size() - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < paintings.size(); k++)
				if(paintings.get(k).getGenre().compareTo(paintings.get(minIndex).getGenre()) < 0)
					minIndex = k;
			swap(paintings, minIndex, j);
		}
	}
	public Painting findPainting(String pName, String aName){
		Painting pResult = null;
		for(int i = 0; i < paintings.size(); i++)
			if(paintings.get(i).getName().equals(pName) && paintings.get(i).getAuthor().equals(aName))
				pResult = paintings.get(i);
		return pResult;
	}
	public Paintings getPaintingsByAuthor(String aName){
		ArrayList<Painting> authorList = new ArrayList<Painting>();
		for(Painting painting : paintings)
			if(painting.getAuthor().equals(aName))
				authorList.add(painting);
		return new Paintings(authorList);
	}
	public Paintings getPaintingByGenre(String genreName){
		ArrayList<Painting> genreList = new ArrayList<Painting>();
		for(Painting painting : paintings)
			if(painting.getGenre().equals(genreName))
				genreList.add(painting);
		return new Paintings(genreList);
	}
	public long getAverageCost(){
		long result = 0;
		for(Painting painting : paintings)
			result += painting.getCost();
		return result / paintings.size();
	}
}
