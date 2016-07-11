
public class DoubleHashApp {

	public static void main(String args[])
	{
		DoubleHash d = new DoubleHash(9);
		Hash h = new Hash(2);
		Hash h1 = new Hash(11);
		Hash h2 = new Hash(20);
		Hash h3 = new Hash(29);
		
		
		d.insert(h);
		d.insert(h1);
		d.insert(h2);
		d.insert(h3);
		
		d.display();
		d.delete(29);
		System.out.println();
		d.display();
		
		d.insert(h3);
		System.out.println();
		d.display();
		
		
	}
}
