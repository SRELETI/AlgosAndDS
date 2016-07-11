
public class CountingSortApp {
	public static void main(String args[])
	{
		CountingSort cs = new CountingSort(8,-2,5);
		cs.add(5);
		cs.add(3);
		cs.add(3);
		cs.add(4);
		cs.add(3);
		cs.add(4);
		cs.add(-2);
		cs.add(-1);
		
		cs.display();
		cs.countingSortNeg();
		cs.display();
	}
}
