
public class QuickSortApp {
	public static void main(String args[])
	{
		QuickSortArr qs = new QuickSortArr(5);
		qs.insert(4);
		qs.insert(5);
		qs.insert(3);
		qs.insert(2);
		qs.insert(6);
		qs.display();
		qs.quickSort(qs.arr, 0, 4);
		qs.display();
		
	}
}
