
public class SumLeafPathApp {

	public static void main(String args[])
	{
		SumLeafPath s = new SumLeafPath();
		
		s.head = new TreePrint(6);
		s.head.left = new TreePrint(3);
		s.head.right = new TreePrint(5);
		s.head.left.left = new TreePrint(2);
		s.head.left.right = new TreePrint(5);
		
		s.head.left.right.left = new TreePrint(7);
		s.head.left.right.right = new TreePrint(4);
		
		s.head.right.right = new TreePrint(4);
		
		s.sum();
	}
}
