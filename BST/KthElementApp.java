
public class KthElementApp {

	public static void main(String args[])
	{
		KthElement k = new KthElement();
		k.insert(20);
		k.insert(8);
		k.insert(22);
		k.insert(4);
		k.insert(12);
		k.insert(10);
		k.insert(14);
		
		k.getKth(8);
	}
}
