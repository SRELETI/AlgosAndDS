
public class MaxPathBLeafApp {

	public static void main(String args[])
	{
		MaxPathBLeaf m = new MaxPathBLeaf();
		
		m.head = new TreePrint(-15);
		m.head.left = new TreePrint(5);
		m.head.left.left = new TreePrint(-8);
		m.head.left.right = new TreePrint(1);
		m.head.left.left.left = new TreePrint(2);
		m.head.left.left.right = new TreePrint(6);
		
		m.head.right = new TreePrint(6);
		m.head.right.left = new TreePrint(3);
		m.head.right.right = new TreePrint(9);
		m.head.right.right.right = new TreePrint(0);
		m.head.right.right.right.left = new TreePrint(4);
		m.head.right.right.right.right = new TreePrint(-1);
		m.head.right.right.right.right.left = new TreePrint(10);
		
		m.maxSum();
		
	}
}
