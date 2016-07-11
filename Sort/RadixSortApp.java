
public class RadixSortApp {
	public static void main(String args[])
	
	{
		RadixSort rs = new RadixSort(5);
		rs.add(5);
		rs.add(1);
		rs.add(2);
		rs.add(4);
		rs.add(3);
		rs.display();
		rs.radixSort(1);
	}
}
