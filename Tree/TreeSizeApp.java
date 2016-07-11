
public class TreeSizeApp {
	public static void  main(String args[])
	{
		TreeSize ts = new TreeSize();
		ts.insert(6);
		ts.insert(4);
		ts.insert(5);
		ts.insert(7);
		ts.insert(3);
		ts.insert(2);
		//System.out.println(ts.call_size());
		//System.out.println(ts.size_it());
		//System.out.println(ts.depth_fun());
		ts.delete();
		//System.out.println(ts.size_it());
	}
}
