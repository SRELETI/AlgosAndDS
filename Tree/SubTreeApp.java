
public class SubTreeApp {
	
	public static void main(String args[])
	{
		SubTreeCheck s = new SubTreeCheck();
		
		s.insert(4);
		s.insert(5);
		s.insert(2);
		s.insert(3);
		s.insert(1);
		
		s.insert_sub(2);
		s.insert_sub(1);
		s.insert_sub(5);
		
		s.checkSubTree();
		
	}
}
