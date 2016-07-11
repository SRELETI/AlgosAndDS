
public class DoubleTreeConv {

	private TreePrint head;
	
	public DoubleTreeConv()
	{
		head = null;
	}
	
	public void convDouble(TreePrint node)
	{
		if(node == null)
			return ;
		convDouble(node.left);
		convDouble(node.right);
		
		TreePrint oldLeft = node.left;
		node.left = new TreePrint(node.data);
		node.left.left = oldLeft;
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
		DoubleTreeConv dc = new DoubleTreeConv();
		dc.head = new TreePrint(1);
		dc.head.left = new TreePrint(2);
		dc.head.right = new TreePrint(3);
		dc.head.left.left = new TreePrint(4);
		dc.head.left.right = new TreePrint(5);
		
		dc.inorder(dc.head);
		dc.convDouble(dc.head);
		System.out.println();
		dc.inorder(dc.head);
	}
}
