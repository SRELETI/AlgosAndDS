
public class BoundaryTree {
	
	public TreePrint head;
	
	public BoundaryTree()
	{
		head = null;
	}
	
	public void boundaryTree(TreePrint node)
	{
		if(node !=null)
		{
			System.out.print(node.data+" ");
			printBoundaryLeft(node.left);
			
			printBoundaryLeaves(node.left);
			printBoundaryLeaves(node.right);
			
			printBoundaryRight(node.right);
		}
	}
	
	private void printBoundaryLeft(TreePrint node)
	{
		if(node !=null )
		{
			if(node.left!=null)
			{
				System.out.print(node.data+" ");
				printBoundaryLeft(node.left);
			}
			else if(node.right !=null)
			{
				System.out.print(node.data+" ");
				printBoundaryLeft(node.right);
			}
		}
	}
	
	private void printBoundaryLeaves(TreePrint node)
	{
		if(node != null)
		{
			printBoundaryLeaves(node.left);
			
			if(node.left == null && node.right == null)
				System.out.print(node.data+" ");
			
			printBoundaryLeaves(node.right);
		}
	}
	
	private void printBoundaryRight(TreePrint node)
	{
		if(node !=null)
		{
			if(node.right != null)
			{
				printBoundaryRight(node.right);
				System.out.print(node.data+" ");
			}
			else if(node.left !=null)
			{
				printBoundaryRight(node.left);
				System.out.print(node.data+" ");
			}
		}
	}
	
	
}
