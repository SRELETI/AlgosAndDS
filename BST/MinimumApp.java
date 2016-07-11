public class MinimumApp {

	public static void main(String args[])
	{
		Minimum m = new Minimum();
		
		m.insert(20);
		m.insert(8);
		m.insert(22);
		m.insert(4);
		m.insert(12);
		m.insert(10);
		m.insert(14);
	//	m.insert(22);
		
		m.findMin();
		m.getPreS(10);
	}
}
