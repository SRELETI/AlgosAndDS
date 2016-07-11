
public class ChildSum {

	private TreePrint head;
	
	public ChildSum()
	{
		head = null;
	}
	
	public boolean child(TreePrint node)
	{
		if(node==null || node.left==null && node.right == null)
			return true;
		int left=0;
		int right=0;
		if(node.left!=null)
			left = node.left.data;
		if(node.right!=null)
			right = node.right.data;
		return ((node.data == left+right) && child(node.left)==true && child(node.right)==true);
	}
	
	public static void main(String args[])
	{
		ChildSum cs = new ChildSum();
		cs.head = new TreePrint(10);
		cs.head.left = new TreePrint(8);
		cs.head.right = new TreePrint(2);
		cs.head.left.left = new TreePrint(3);
		cs.head.left.right = new TreePrint(5);
		cs.head.right.right = new TreePrint(4);
		
		System.out.println(cs.child(cs.head));
	}
}
