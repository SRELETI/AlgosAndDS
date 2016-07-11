
public class ListDApp {
	public static void main(String args[])
	{
		ListDeque ld=new ListDeque();
		ld.insertLast(1);
		ld.insertLast(2);
		ld.insertLast(0);
		ld.insertLast(3);
		ld.deleteLast();
		ld.deleteLast();
		ld.deleteLast();
		ld.deleteLast();
		ld.display();
	}
}
