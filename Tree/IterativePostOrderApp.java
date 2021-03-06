
public class IterativePostOrderApp {

	public static void main(String args[])
	{
		IterativePostOrder i = new IterativePostOrder();
		
		i.head = new TreePrint(1);
		i.head.left = new TreePrint(2);
		i.head.right = new TreePrint(3);
		i.head.left.left = new TreePrint(4);
		i.head.left.right = new TreePrint(5);
		i.head.right.left = new TreePrint(6);
		i.head.right.right = new TreePrint(7);
		
		i.iterative_order(i.head);
	}
}
