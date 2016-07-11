
public class LeafNodes {
	
	private TreePrint head;
	public static int count=0;
	public LeafNodes()
	{
		head = null;
	}
	
	public void leafNodesCount(TreePrint node)
	{
		leafNode(node);
		System.out.println(count);
	}
	
	public void leafNode(TreePrint node)
	{
		if(node == null)
			return;
		if(node.left == null && node.right==null)
		{
			count++;
			return;
		}
		leafNode(node.left);
		leafNode(node.right);
	}
	
	public int leafNode2(TreePrint node)
	{
		if(node == null)
			return 0;
		if(node.left == null && node.right==null)
		{
			return 1;
		}
		return (leafNode2(node.left)+leafNode2(node.right));
	}
	
	public static void main(String args[])
	{
		LeafNodes l = new LeafNodes();
		l.head = new TreePrint(1);
		l.head.left = new TreePrint(2);
		l.head.right = new TreePrint(3);
		l.head.left.left = new TreePrint(4);
		l.head.left.right = new TreePrint(5);
		
		l.leafNodesCount(l.head);
		System.out.println(l.leafNode2(l.head));
	}
}
