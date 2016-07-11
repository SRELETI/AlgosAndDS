
public class KNodesPrint {

	private TreePrint head;
	
	public KNodesPrint()
	{
		head = null;
	}
	
	public void printNodes(TreePrint node, int distance)
	{
		if(node == null)
			return;
		if(distance == 0)
		{
			System.out.print(node.data+" ");
			return;
		}
		printNodes(node.left,distance-1);
		printNodes(node.right,distance-1);
	}
	
	public static void main(String args[])
	{
		KNodesPrint k = new KNodesPrint();
		k.head = new TreePrint(1);
		k.head.left = new TreePrint(2);
		k.head.right = new TreePrint(3);
		k.head.left.left = new TreePrint(4);
		k.head.left.right = new TreePrint(5);
		k.head.right.left = new TreePrint(6);
		
		k.printNodes(k.head, 2);
	}
}
