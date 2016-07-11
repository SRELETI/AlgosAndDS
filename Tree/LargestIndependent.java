
public class LargestIndependent {

	public TreePrint head;
	
	public LargestIndependent()
	{
		head = null;
	}
	
	public int largest(TreePrint node)
	{
		if(node == null)
			return 0;
		int excl = largest(node.left)+largest(node.right);
		
		int incl =1;
		if(node.left!=null)
			incl = incl + largest(node.left.left)+largest(node.left.right);
		if(node.right!=null)
			incl = incl + largest(node.right.right)+largest(node.right.left);
		
		return incl>excl ? incl : excl;
	}
	
	public static void main(String args[])
	{
		LargestIndependent l = new LargestIndependent();
		
		l.head = new TreePrint(10);
		l.head.left = new TreePrint(20);
		l.head.right = new TreePrint(30);
		l.head.left.left = new TreePrint(40);
		l.head.left.right = new TreePrint(50);
		l.head.left.right.left = new TreePrint(70);
		l.head.left.right.right = new TreePrint(80);
		l.head.right.right = new TreePrint(60);
		
		System.out.println(l.largest(l.head));
	}
}
