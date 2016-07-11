
public class PrintKeysApp {

	public static void main(String args[])
	{
		PrintKeys p = new PrintKeys();
		
		p.insert(20);
		p.insert(8);
		p.insert(22);
		p.insert(4);
		p.insert(12);
		
	//	p.keysPrint(10, 22);
		
		int[] arr = {1,2,3,4};
		p.construct(arr);
	}
}
