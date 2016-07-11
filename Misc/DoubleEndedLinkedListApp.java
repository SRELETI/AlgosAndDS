
public class DoubleEndedLinkedListApp {
	public static void main(String args[])
	{
		DoubleEndedLinkedList dd=new DoubleEndedLinkedList();
		dd.insertFirst(3);
		dd.insertFirst(2);
		dd.insertFirst(1);
		dd.insertLast(4);
		dd.display();
		dd.deleteFirst();
		System.out.println("After deletion :");
		dd.display();
		dd.deleteFirst();
		System.out.println();
		dd.display();
		dd.deleteFirst();
		System.out.println();
		dd.display();
		dd.deleteFirst();
		System.out.println("after final deletion: ");
		dd.display();
	}
}
