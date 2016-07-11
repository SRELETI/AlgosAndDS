
public class SumTreeOptApp {

	public static void main(String args[])
	{
		SumTreeOpt s = new SumTreeOpt();
		s.head = new TreePrint(28);
		s.head.left = new TreePrint(10);
		s.head.right = new TreePrint(3);
		s.head.left.left = new TreePrint(4);
		s.head.left.right = new TreePrint(6);
		s.head.right.right = new TreePrint(3);
		
		s.sum();
	}
}
