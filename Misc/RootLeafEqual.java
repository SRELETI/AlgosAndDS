
public class RootLeafEqual {
	
	private TreePrint head;
	
	public RootLeafEqual()
	{
		head = null;
	}
	
	public boolean isEqual(TreePrint node, int sum)
	{
		if(node == null)
		{
			return sum==0;
		}
		int subsum = sum-node.data;
		
		return (isEqual(node.left,subsum)==true || isEqual(node.right,subsum)==true);
	}
	
	public static void main(String args[])
	{
		RootLeafEqual r = new RootLeafEqual();
		r.head = new TreePrint(10);
		r.head.left = new TreePrint(8);
		r.head.right = new TreePrint(2);
		r.head.left.left = new TreePrint(3);
		r.head.left.right = new TreePrint(5);
		r.head.right.left = new TreePrint(2);
		
		System.out.println(r.isEqual(r.head, 0));
	}
}
