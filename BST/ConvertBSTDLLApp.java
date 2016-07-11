
public class ConvertBSTDLLApp {

	public static void main(String args[])
	{
		ConvertBSTDLL c = new ConvertBSTDLL();
		
		c.insert(6);
		c.insert(-13);
		c.insert(14);
		c.insert(-8);
		c.insert(13);
		c.insert(7);
		c.insert(15);
		
		c.convert();
	}
}
