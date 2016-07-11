
public class CeilApp {

	public static void main(String args[])
	{
		Ceil c = new Ceil();
		
		c.insert(8);
		c.insert(4);
		c.insert(12);
		c.insert(2);
		c.insert(6);
		c.insert(10);
		c.insert(14);
		
		for(int i=0;i<16;i++)
		{
			int result = c.findFloor(i);
				//	c.findCeil(i);
			System.out.println(i+" "+result);
		}
	}
}
