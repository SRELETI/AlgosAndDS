
public class SortedIntersectionApp {
	public static void main(String args[])
	{
		SortedIntersection si = new SortedIntersection();
		si.addFront(6);
		si.addFront(4);
		si.addFront(3);
		si.addFront(2);
		si.addFront(1);
		si.addFront2(8);
		si.addFront2(6);
		si.addFront2(4);
		si.addFront2(2);
		si.display();
		si.display2();
		//si.sortedInt();
		si.sorted_rec(si.first, si.second, si.result);
		si.display_result();
	}
}
