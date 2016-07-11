
public class ChainHashApp {

	public static void main(String args[])
	{
		ChainHash c= new ChainHash(10);
		
		LinkL h = new LinkL(5);
		LinkL h1 = new LinkL(10);
		
		c.insert(h);
		c.insert(h1);
		c.insert(h);
		
		c.displayHash();
	}
}
