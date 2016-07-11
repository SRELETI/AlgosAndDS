
public class MinSubArrSortApp {
	public static void main(String args[])
	{
		MinSubArrSort ms = new MinSubArrSort(11);
		ms.add(10);
		ms.add(12);
		ms.add(20);
		ms.add(30);
		ms.add(25);
		ms.add(40);
		ms.add(32);
		ms.add(31);
		ms.add(35);
		ms.add(50);
		ms.add(60);
		ms.display();
		ms.sort();
		
	}
}
