
public class LinkedListBubbleApp {
	public static void main(String args[])
	{
		LinkedListBubble lb = new LinkedListBubble();
		lb.addFront(4);
		lb.addFront(5);
		lb.addFront(1);
		lb.addFront(3);
		lb.display();
		lb.bubbleSort();
		lb.display();
	}
}
