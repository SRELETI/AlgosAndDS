
public class IterativePreOrderApp {

	public static void main(String args[])
	{
		IterativePreorder i = new IterativePreorder();
		i.head = new TreePrint(10);
		i.head.left = new TreePrint(8);
		i.head.right = new TreePrint(2);
		i.head.left.left = new TreePrint(3);
		i.head.left.right = new TreePrint(5);
		i.head.right.left = new TreePrint(2);
		
		i.iterative(i.head);
		
		
	}
}
