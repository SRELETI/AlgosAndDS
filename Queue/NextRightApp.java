
public class NextRightApp {

	public static void main(String args[])
	{
		NextRight n = new NextRight();
		n.head = new TreePrint(10);
		n.head.left = new TreePrint(2);
		n.head.left.left = new TreePrint(8);
		n.head.left.right = new TreePrint(4);
		
		n.head.right = new TreePrint(6);
		n.head.right.right = new TreePrint(5);
		
		n.nextRight(10);
	}
}
