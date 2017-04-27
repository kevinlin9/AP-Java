//@author Kevin Lin
public class Painting {
	private String name;
	private String author;
	private String condition;
	private long cost;
	private double length;
	private double width;
	private String genre;
	private String origin;
	private int dateCreated;
	
	public Painting(String name, String author, String condition, long cost, double length, double width, String genre, String origin, int dateCreated){
		this.name = name;
		this.author = author;
		if(condition.equals("New") || condition.equals("Worn") || condition.equals("Old"))
			this.condition = condition;
		this.cost = cost;
		this.length = length;
		this.width = width;
		this.genre = genre;
		this.origin = origin;
		this.dateCreated = dateCreated;
	}
	
	public String getName(){
		return name;
	}
	public String getAuthor(){
		return author;
	}
	public String getCondition(){
		return condition;
	}
	public long getCost(){
		return cost;
	}
	public String getGenre(){
		return genre;
	}
	public int getDateCreated(){
		return dateCreated;
	}
	public int compareTo(Painting other){
		int nameCompare = this.name.compareTo(other.name);
		if(nameCompare == 0)
			return this.author.compareTo(other.author);
		return nameCompare;
	}
	public String toString(){
		return "Name: " + name + "  Author: " + author + "  Condition: " + condition + "  Cost: $" + cost + "  Length: " + length + "cm  Width: " + width + "cm  Genre: " + genre + "  Origin: " + origin + "  Date Created: " + dateCreated;
	}
}
