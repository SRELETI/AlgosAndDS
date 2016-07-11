
public class DoubleLinkedListApp {
	public static void main(String args[])
	{
		DoubleLinkedList dll=new DoubleLinkedList();
		dll.insertionFirst(1);
		dll.insertAfter(1,4);
		dll.insertionLast(5);
		System.out.println("Increasing order");
		dll.traverseForward();
		System.out.println("Decreasing Order");
		dll.traverseBackward();
		//dll.deleteFirst();
		//dll.traverseForward();
		dll.deleteKey(4);
		dll.traverseForward();
	}
}	
