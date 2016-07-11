
public class CheckCusionsApp {

	public static void main(String args[])
	{
		CheckCousions c = new CheckCousions();
		c.insert(4);
		c.insert(6);
		c.insert(5);
		c.insert(7);
		c.insert(2);
		c.insert(3);
		c.insert(1);
		
		System.out.println(c.checkCousion(3, 2));
	}
}
