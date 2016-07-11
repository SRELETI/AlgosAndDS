
public class Foldable {
	
	private TreePrint head;
	
	public Foldable()
	{
		head = null;
	}
	
	public void check(TreePrint node)
	{
		boolean result = checkTree(node);
		System.out.println(result);
	}
	
	private boolean checkTree(TreePrint node)
	{
		if(node == null)
			return true;
		mirror(node.left);
		
		boolean result = isSame(node.left,node.right);
		
		mirror(node.left);
		
		return result;
	}
	
	private void mirror(TreePrint node)
	{
		if(node == null)
			return;
		TreePrint temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		mirror(node.left);
		mirror(node.right);
	}
	
	private boolean isSame(TreePrint node1, TreePrint node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		return isSame(node1.left,node2.left) == true && isSame(node1.right,node2.right)==true;
	}
	
	public static void main(String args[])
	{
		Foldable f = new Foldable();
		f.head = new TreePrint(1);
		f.head.left = new TreePrint (2);
		f.head.right = new TreePrint(3);
		f.head.left.right = new TreePrint (4);
		f.head.right.left = new TreePrint(5);
		
		f.check(f.head);
	}
}
