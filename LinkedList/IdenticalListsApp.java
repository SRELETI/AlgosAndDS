
public class IdenticalListsApp {
	public static void main(String args[])
	{
		IdenticalLists il = new IdenticalLists();
		il.addFront(3);
		il.addFront(2);
		il.addFront(1);
		il.addFront2(3);
		il.addFront2(2);
		il.addFront2(4);
		il.display();
		il.display2();
		System.out.println(il.check());
	}
}
