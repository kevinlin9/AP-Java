import java.util.Arrays;

//@author Kevin Lin
public class PeriodicTable {
	private Element[] elements;
	
	public PeriodicTable(Element[] elements){
		this.elements = elements;
	}
	public Element getElementBySymbol(String symbol){
		sortElementsBySymbol();
		int minIndex = 0;
		int maxIndex = elements.length - 1;
		int midIndex = -1;
		while(minIndex <= maxIndex){
			midIndex = (maxIndex + minIndex) / 2;
			if(symbol.compareTo(elements[midIndex].getSymbol()) < 0)
				maxIndex = midIndex - 1;
			else{
				if(symbol.compareTo(elements[midIndex].getSymbol()) > 0)
					minIndex = midIndex + 1;
				else
					return elements[midIndex];
			}
		}
		if(midIndex == -1)
			return null;
		return elements[midIndex];
	}
	public Element getElementByName(String name){
		sortElementsByName();
		int minIndex = 0;
		int maxIndex = elements.length - 1;
		int midIndex = -1;
		while(minIndex <= maxIndex){
			midIndex = (maxIndex + minIndex) / 2;
			if(name.compareTo(elements[midIndex].getName()) < 0)
				maxIndex = midIndex - 1;
			else{
				if(name.compareTo(elements[midIndex].getName()) > 0)
					minIndex = midIndex + 1;
				else
					return elements[midIndex];
			}
		}
		if(midIndex == -1)
			return null;
		return elements[midIndex];
	}
	public Element[] getElements(){
		return elements;
	}
	public void sortElementsBySymbol(){
		Arrays.sort(elements);
	}
	public void sortElementsByName(){
		Arrays.sort(elements, Element.ElementNameComparator);
	}
	public String toString(){
		String output = "";
		for(Element element : elements)
			output += element + "\n";
		return output;
	}
	
	public static void main(String[] args) {
		
		// Sorting tests successful
		Element[] eTest = new Element[10];
		for(int i = 0; i < eTest.length; i++){
			Element element = new Element("a", 1, "Q", 15, 0, "asd", true);
			eTest[i] = element;
			i++;
			element = new Element("b", 3, "Cu", 45, 5, "qweqwe", false);
			eTest[i] = element;
		}
		PeriodicTable pTest = new PeriodicTable(eTest);
		System.out.println(pTest);
		pTest.sortElementsByName();
		System.out.println(pTest);
		pTest.sortElementsBySymbol();
		System.out.println(pTest);
		
		// Retrieval tests successful
		Element[] elementsToRetrieve = {new Element("Aaslnite", 1, "As" , 15, 67, "Alien", false), new Element("Belsibum", 2, "Be", 23, 17, "Alien", false), new Element("Curdlinite", 4, "Cu", 55, 78, "Alien", true), new Element("Hunkidon", 65, "Hu", 88, 54, "Alien", true), new Element("Jukonars", 90, "Ju", 43, 42, "Alien", false)};
		PeriodicTable retrievalTest = new PeriodicTable(elementsToRetrieve);
		System.out.println(retrievalTest);
		System.out.println(retrievalTest.getElementByName("Hunkidon"));
		System.out.println(retrievalTest.getElementBySymbol("Ju"));
	}
}
