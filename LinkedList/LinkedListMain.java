
public class LinkedListMain {
	public static void main(String args[])
	{
		LinkedListAdd lla = new LinkedListAdd();
		/*lla.addFront(4);
		lla.addFront(3);
		lla.addFront(2);
		lla.addFront(1);*/
		/*lla.addLast(1);
		lla.addLast(2);
		lla.addLast(3);
		lla.addLast(4);*/
		lla.addAfter(0, 2);
		lla.addFront(1);
		lla.addAfter(1, 2);
		lla.addAfter(2, 3);
		lla.addAfter(3, 4);
		lla.addAfter(5, 7);
		lla.display();
		
	}
}
