
public class Mirror {
	
	private TreePrint head;
	
	public Mirror()
	{
		head = null;
	}
	
	public void mirror(TreePrint node)
	{
		if(node == null || node.left==null && node.right==null)
			return;
		mirror(node.left);
		mirror(node.right);
		
		TreePrint temp = node.left;
		node.left = node.right;
		node.right=temp;
	}
	
	public void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	public static void main(String args[])
	{
		Mirror m = new Mirror();
		m.head = new TreePrint(1);
		m.head.left = new TreePrint(2);
		m.head.right = new TreePrint(3);
		m.head.left.left = new TreePrint(4);
		m.head.left.right = new TreePrint(5);
		m.inorder(m.head);
		m.mirror(m.head);
		System.out.println();
		m.inorder(m.head);
	}
}
