
public class MorrisPreOrder {

	
	public TreePrint head;
	
	public MorrisPreOrder()
	{
		head = null;
	}
	
	public void Morris(TreePrint node)
	{
		if(node == null)
			return;
		while(node!=null)
		{
			if(node.left == null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				while(temp.left!=null && temp.right != null)
					temp = temp.right;
				
				if(temp.right == null)
				{
					temp.right= node;
					System.out.print(node.data+" ");
					node = node.left;
				}
				else
				{
					temp.right = null;
					node = node.right;
				}
			}
		}
	}
	
	
	public void morris_inorder(TreePrint node )
	{
		if(node == null)
			return;
		while(node!=null)
		{
			if(node.left == null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				while(temp.right != null && temp.left !=null)
					temp = temp.right;
				
				if(temp.right==null)
				{
					temp.right = node;
					node = node.left;
				}
				else
				{
					temp.right = null;
					System.out.print(node.data+" ");
					node = node.right;
				}
			}
		}
	}
	
	
}
