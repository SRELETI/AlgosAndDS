
public class isBSTApp {

	public static void main(String args[])
	{
		isBST b = new isBST();
		
		b.insert(50);
		b.insert(70);
		b.insert(30);
		b.insert(80);
		b.insert(60);
		b.insert(20);
		b.insert(40);
	//	b.largest();
		
		
		int[] arr = {8,3,6,1,4,7,10,14,13};
		int[] arr2 = {8,10,14,3,6,4,1,7,13};
		
		System.out.println(b.isSame(arr, arr2));
		
		b.addGreater();
		
	}
}
