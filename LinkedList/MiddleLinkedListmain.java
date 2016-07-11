
public class MiddleLinkedListmain {
	public static void main(String args[])
	{
		MiddleLinkedList mll = new MiddleLinkedList();
		mll.addFront(4);
		mll.addFront(3);
		mll.addFront(2);
		mll.addFront(1);
		mll.addFront(0);
		mll.display();
		System.out.println("The middle element is "+mll.middle());
		mll.middle_2();
	}
	
}
