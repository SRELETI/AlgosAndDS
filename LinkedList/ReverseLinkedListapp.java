
public class ReverseLinkedListapp {
	public static void main(String args[])
	{
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.addFront(4);
		rll.addFront(3);
		rll.addFront(2);
		rll.addFront(1);
		rll.display();
		//rll.reverse();
		rll.reverse_rec(rll.head);
		System.out.println("After reverse ");
		rll.display();
	}
}
