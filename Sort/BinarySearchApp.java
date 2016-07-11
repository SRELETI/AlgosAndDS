
public class BinarySearchApp {
	public static void main(String args[])
	{
		BinarySearch2 bs = new BinarySearch2(5);
		bs.add(5);
		bs.add(6);
		bs.add(7);
		bs.add(8);
		bs.add(9); 
		bs.display();
		System.out.println(bs.binarySearch(10,0,4));
		
	}
}
