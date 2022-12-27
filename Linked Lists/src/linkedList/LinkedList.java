package linkedList;

public class LinkedList {
	private Node first;
   	private Node last;
   	private int counter;
   
    //Default Constructor
   	public LinkedList()
    {
   	    first = null;
		last = null;
		counter = 0;
    }
    
    //Method adds number to end of list
   	public void push(int data)
   	{
   		Node temp = new Node(data);
		
		if(first == null)
			first = temp;
		else
			last.setNext(temp);
			
		temp.setPrev(last);
		last = temp;
		
		counter++;
   	}
    
    //Displays LinkedList
   	public void display()
   	{
   		if(first != null){
		 	Node temp = first;
			while(temp != null){
              System.out.print(temp.getData() +" ");
				temp = temp.getNext();
			}
			
			//Checks backwards display
			/*System.out.println();
			
			temp = last;
			while(temp != null){
				System.out.print(temp.getData() +" "); 
				temp = temp.getPrev();
			}*/
			
			System.out.println();
			System.out.println("Size: " +counter);
		
		}
		else
			System.out.println("List is empty.");
   	}
    //Removes node from end of the list
   	public void pop()
   	{
   	    //If the list is greater than 1
   		if(counter > 1){
			last = last.getPrev();
			last.setNext(null);
			counter--;   	
		}
		//If the list is equal to 1
		else if(counter == 1){
			first = null;
			last = null;
			counter--;
		}
   	}
   	
   	//Finds a specific number in the list
    public Node find(int number)
    {
        Node temp = first;
        while(temp != null){
            if(temp.getData() == number)
                break;
            else{
                temp = temp.getNext();
            }
        }
        if(temp == null)
            return null;
        else
            return temp;
    }
    
    //Removes first instance of specific number in list
    public void pop(int number)
    {
        //If the first and ONLY number is to be removed
        if(first.getData() == number && counter == 1){
            first = null;
            last = null;
            counter--;
        } 
        //If the first and only node data is not the number
        else if(first.getData() != number && counter == 1)
            System.out.println("The number did not appear in the list.");
        //If the list is greater than 1
        else if(counter > 1){
            Node tempPrev = first; //Tracks previous node of the temp node
            Node temp = first.getNext();
            while(temp != null){
                if(temp.getData() == number){
                    Node tempNext = temp.getNext();
                    tempPrev.setNext(tempNext);
                    if(tempNext != null)
                        tempNext.setPrev(tempPrev);
                    counter--;
                    break;
                }
                else{
                    tempPrev = tempPrev.getNext();
                    temp = temp.getNext();
                }
            }
        }
    }
    
    public void swap(Node node1, Node node2)
    {
        //Setting previous and next values into temp variables
        Node node1Prev = node1.getPrev();
        Node node1Next = node1.getNext();
        Node node2Prev = node2.getPrev();
        Node node2Next = node2.getNext();
        
        //If the two nodes are the same
        if(node1 == node2){
            System.out.println("Node cannot be swapped with itself.");
            return;
        }
      
        //If node1 and node2 two are in order and side by side
        if(node1 == node2Prev){
            node1.setNext(node2Next);
            node1.setPrev(node2);
            if(node2Next != null)
                node2Next.setPrev(node1);
            else
                last = node1;
            node2.setNext(node1);
            node2.setPrev(node1Prev);
            if(node1Prev != null)
                node1Prev.setNext(node2);
            else
                first = node2;
        }
        
        //If node1 and node2 are reversed and side by side
        else if(node1 == node2Next){
            node1.setNext(node2);
            node1.setPrev(node2Prev);
            if(node2Prev != null)
                node2Prev.setNext(node1);
            else
               first = node1;
            node2.setNext(node1Next);
            node2.setPrev(node1);
            if(node1Next != null)
                node1Next.setPrev(node2);
            else
                last = node2;
        }
      
        //Anything else
        else{
            node1.setNext(node2Next);
            node1.setPrev(node2Prev);
            if(node2Prev != null)
                node2Prev.setNext(node1);
            else
                first = node1;
            if(node2Next != null)
                node2Next.setPrev(node1);
            else 
                last = node1;
            node2.setNext(node1Next);
            node2.setPrev(node1Prev);
            if(node1Prev != null)
                node1Prev.setNext(node2);
            else
                first = node2;
            if(node1Next != null)
                node1Next.setPrev(node2);
            else 
                last = node2;
        }
      
    }
}
