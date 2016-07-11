
public class NodeDistanceApp {

	public static void main(String args[])
	{
		NodeDistance n = new NodeDistance();
		
		n.head = new TreePrint(1);
		n.head.left = new TreePrint(2);
		n.head.right = new TreePrint(3);
		n.head.left.left = new TreePrint(4);
		n.head.left.right = new TreePrint(5);
		n.head.right.left = new TreePrint(6);
		n.head.right.right = new TreePrint(7);
		n.head.right.left.right = new TreePrint(8);
		
		n.nodeDis(3, 4);
		n.nodeDis(2, 4);
		n.nodeDis(8, 5);
		
	}
}
