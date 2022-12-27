package linkedList;

public class Node {

	private int data;
    private Node next;
    private Node prev;
  
    //Default constructor
    public Node()
    {
        data = -1;
        next = null;
        prev = null;
    }
    //Overload constructor for data
    public Node(int data){
   		this.data = data;
    }
   
   //Overload constructor for all variables
    public Node(int data, Node prev, Node next)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
   
   //GETTERS and SETTERS
    public int getData(){
   	    return data;
    }
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getNext(){
   		return next;
    }
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getPrev(){
   		return prev;
    }
	
	public void setPrev(Node prev){
		this.prev = prev;
	}
}
