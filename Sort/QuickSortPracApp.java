
public class QuickSortPracApp {
	public static void main(String args[])
	{
		QuickSortPractice qs = new QuickSortPractice(5);
		qs.add(4);
		qs.add(2);
		qs.add(7);
		qs.add(6);
		qs.add(5);
		qs.display();
		qs.quick(0, 4);
		qs.display();
	}
}
