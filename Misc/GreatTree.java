
public class GreatTree {

	public TreePrint head;
	
	public GreatTree()
	{
		head = null;
	}
	
	public void cons()
	{
		head= constructList(head);
		print (head);
	}
	
	private void print(TreePrint node)
	{
		System.out.print(node.data+" ");
		TreePrint cur = node.right;
		while(cur!=node)
		{
			cur.display();
			cur = cur.right;
		}
	}
	public TreePrint constructList(TreePrint node)
	{
		if(node == null)
			return null;
		TreePrint lList = constructList(node.left);
		TreePrint rList = constructList(node.right);
		
		node.left = node;
		node.right = node;
		
		lList = append(lList,node);
		lList = append(lList,rList);
		
		return lList;
	}
	
	private TreePrint append(TreePrint node, TreePrint node1)
	{
		if(node == null)
			return node1;
		if(node1==null)
			return node;
		TreePrint aLast = node.left;
		TreePrint bLast = node1.left;
		
		join(aLast,node1);
		join(bLast,node);
		
		return node;
		
	}
	
	private void join(TreePrint a, TreePrint b)
	{
		a.right = b;
		b.left = a;
	}
	
	public static void main(String args[])
	{
		GreatTree g = new GreatTree();
		
		g.head = new TreePrint(4);
		g.head.left = new TreePrint(2);
		g.head.right = new TreePrint(5);
		g.head.left.left = new TreePrint(1);
		g.head.left.right = new TreePrint(3);
		
		g.cons();
	}
}

