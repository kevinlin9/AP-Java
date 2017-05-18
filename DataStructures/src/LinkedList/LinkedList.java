package LinkedList;

abstract public class LinkedList {
	protected Node head;
	protected int length;
	
	public LinkedList(){
		head = new Node();
		length++;
	}
	
	public LinkedList(Node n){
		head = n;
		length++;
	}
	
	public LinkedList(int data){
		head = new Node(data);
		length++;
	}
	
	public Node search(int target){
		Node x = head;
		while(x.getNext() != null && x.getData() != target){
			x = x.getNext();
		}
		if(x.getNext() == null && x.getData() != target)
			return null;
		return x;				
	}
	
	public abstract void add();
	
	public abstract void delete();
	
	public abstract void insert();
	
	public int size(){
		return length;
	}
	
	public void display(){
		Node x = head;
		for(int i = 0; i < length; i++){
			System.out.println(x.getData());
			x = x.getNext();
		}
	}
}
