package linkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node reference = new Node();
		list.push(1);
		list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
		list.display();
        //list.pop();
        /*list.display();
        list.pop();
        list.display();
        list.pop();
        list.display();*/
        /*reference = list.find(5);
        if(reference == null)
          System.out.println("The number was not present in the list.");
        else
          System.out.println("The number was found at "+reference);*/
        
        list.swap(list.find(6), list.find(1));
        //list.pop(2);
        list.display();

	}

}
