
public class LCAApp {

	public static void main(String args[])
	{
		LCA l = new LCA();
		
		l.insert(20);
		l.insert(8);
		l.insert(22);
		l.insert(4);
		l.insert(12);
		l.insert(14);
		l.insert(10);
		
		l.check(8, 14);
	}
}
