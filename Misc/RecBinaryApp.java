
public class RecBinaryApp {
	public static void main(String args[])
	{
		RecBinarySearch rbs=new RecBinarySearch();
		rbs.insert(5);
		rbs.insert(7);
		rbs.insert(3);
		rbs.insert(4);
		rbs.display();
		System.out.println(rbs.search(3));
	}
}
