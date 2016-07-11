
public class BoundaryTrees {

	public TreePrint head;
	
	public BoundaryTrees()
	{
		head = null;
	}
	
	public void boundary(TreePrint node)
	{
		if(node == null)
			return;
		System.out.print(node.data+" ");
		
		printLeft(node.left);
		printLeaves(node.left);
		printLeaves(node.right);
		
		printRight(node.right);
	}
	
	
	private void printRight(TreePrint node)
	{
		if(node != null)
		{
			if(node.right!=null)
			{
				printRight(node.right);
				System.out.print(node.data+" ");
			}
			else if(node.left!=null)
			{
				printRight(node.left);
				System.out.print(node.data+" ");
			}
		}
	}
	private void printLeft(TreePrint node)
	{
		if(node!=null)
		{
			if(node.left!=null)
			{
				System.out.print(node.data+" ");
				printLeft(node.left);
			}
			else if(node.right != null)
			{
				System.out.print(node.data+" ");
				printLeft(node.right);
			}
		}
	}
	
	private void printLeaves(TreePrint node)
	{
		if(node == null)
			return;
		if(node.left == null && node.right == null)
		{
			System.out.print(node.data+" ");
			return;
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}
}
