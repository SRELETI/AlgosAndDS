
public class BoundaryNodesApp {

	public static void main(String args[])
	{
		BoundaryTrees b = new BoundaryTrees();
		
		b.head = new TreePrint(20);
		b.head.left = new TreePrint(8);
		b.head.right = new TreePrint(22);
		
		b.head.left.left = new TreePrint(4);
		b.head.left.right = new TreePrint(12);
		b.head.left.right.left = new TreePrint(10);
		b.head.left.right.right = new TreePrint(14);
		
		b.head.right.left = new TreePrint(25);
		
		b.boundary(b.head);
	}
}
