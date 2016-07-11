
public class ConvertTree {

	public TreePrint head;
	
	public ConvertTree()
	{
		head = null;
	}
	
	public void isSumTree()
	{
		System.out.println("Before converting to sum Tree ");
		inorder(head);
		System.out.println();
		convert(head);
		System.out.println("After converting to sum tree ");
		inorder(head);
		System.out.println();
	}
	
	private int convert(TreePrint node)
	{
		if(node == null)
			return 0;
		int old_value = node.data;
		
		node.data = convert(node.left)+convert(node.right);
		
		return node.data+old_value;
	}
	
	public void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	
}
