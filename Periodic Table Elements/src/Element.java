import java.util.Comparator;

public class Element implements Comparable<Element>{
	private int atomicNumber;
	private String symbol;
	private String name;
	private double atomicWeight;
	private int mostStableOxidationState;
	private String family;
	private boolean metal;
	
	public Element(String name, int num, String symbol, double weight, int mostStableOxState, String family, boolean metal){
		this.name = name;
		atomicNumber = num;
		this.symbol = symbol;
		atomicWeight = weight;
		mostStableOxidationState = mostStableOxState;
		this.family = family;
		this.metal = metal;
	}
	public String getName(){ 
		return name;
	}
	public int getAtomicNumber(){ 
		return atomicNumber; 
	}
	public String getSymbol(){ 
		return symbol; 
	}
	public double getAtomicWeight(){
		return atomicWeight; 
	}
	public int getMostStableOxidationState(){
		return mostStableOxidationState; 
	}
	public String getFamily(){
		return family; 
	}
	public boolean isMetal(){
		return metal; 
	}	
	public String toString(){
		String output = "";
		if (atomicNumber < 10)
			output += getSpaces(2) + atomicNumber;
		else if (atomicNumber < 100)
			output += getSpaces(1) + atomicNumber;
		else
			output += atomicNumber;
		output += getSpaces(2);
		output += name;
		output += getSpaces(15 - name.length());
		output += symbol + getSpaces(5 - symbol.length());
		String weight = "";
		if (atomicWeight < 10.0)
			weight = getSpaces(2) + atomicWeight;
		else if (atomicWeight < 100.0)
			weight = getSpaces(1) + atomicWeight;
		else
			weight += atomicWeight;
		output += weight + getSpaces(11 - weight.length());
		output += family;
		output += getSpaces(18 - family.length());
		return output;
	}
	public static String getSpaces(int numOfSpaces){
		String spaces = "";
		for (int i = 0; i < numOfSpaces; i++)
			spaces += " ";
		return spaces;
	}
	public int compareTo(Element element){
		String compareElementSymbol = element.getSymbol();
		return this.getSymbol().compareTo(compareElementSymbol);
	}
	public static Comparator<Element> ElementNameComparator = new Comparator<Element>(){
		public int compare(Element element1, Element element2){
			return element1.getName().compareTo(element2.getName());
		}
	};
}