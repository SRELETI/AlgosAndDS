
public class TreeLinkedList {

	public TreePrint tree;
	public TreePrint list;
	
	public TreeLinkedList()
	{
		tree = null;
		list = null;
	}
	
	public void tree()
	{
		TreePrint node = print(tree);
		display(node);
		display_list();
	}
	
	private void display(TreePrint node)
	{
		if(node == null)
			return;
		display(node.left);
		System.out.print(node.data+" ");
		display(node.right);
	}
	
	private void display_list()
	{
		System.out.println();
		TreePrint temp = list;
		while(temp!=null)
		{
			temp.display();
			temp= temp.right;
		}
	}
	
	private TreePrint print(TreePrint node)
	{
		if(node == null)
			return null;
		if(node.left == null && node.right == null)
		{
			node.right = list;
			if(list!=null)
				list.left = node;
			list = node;
			return null;
		}
		
		node.right =print(node.right);
		node.left = print(node.left);
		
		return node;
	}
	
}
