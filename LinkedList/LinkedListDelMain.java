
public class LinkedListDelMain {
	public static void main(String args[])
	{
		LinkedListDelete lld = new LinkedListDelete();
		lld.addFront(4);
		lld.addFront(3);
		lld.addFront(2);
		lld.addFront(1);
		//lld.display();
		//lld.delete(5);
		lld.display();
		lld.reverse();
		lld.display();
		
	}
}
