
public class ConvertTreeToSum {

	private TreePrint head;
	
	public ConvertTreeToSum()
	{
		head = null;
	}
	
	public void convert()
	{
		conversion(head);
		inorder(head);
	}
	
	private void inorder(TreePrint node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	private void conversion(TreePrint node)
	{
		if(node == null || node.left == null && node.right ==null)
			return;
		conversion(node.left);
		conversion(node.right);
		int left =0;
		int right = 0;
		if(node.left != null)
			left = node.left.data;
		if(node.right!=null)
			right = node.right.data;
		int diff = left+right-node.data;
		if(diff>0)
			node.data = node.data+diff;
		else
		{
			if(node.left!=null)
				callFix(node.left, -diff);
			else if(node.right!=null)
				callFix(node.right,-diff);
		}
	}
	private void callFix(TreePrint node, int diff)
	{
		if(node!=null)
		{
			node.data = node.data+diff;
			if(node.left!=null)
			{
				callFix(node.left,diff);
			}
			else if(node.right!=null)
				callFix(node.right,diff);
		}
	}
	
	public static void main(String args[])
	{
		ConvertTreeToSum c = new ConvertTreeToSum();
		c.head = new TreePrint(50);
		c.head.left = new TreePrint(7);
		c.head.right = new TreePrint(2);
	//	c.head.left.left = new TreePrint(3);
		c.head.left.right = new TreePrint(5);
		
		c.head.right.left = new TreePrint(1);
		c.head.right.right = new TreePrint(30);
		
		c.convert();
	}
	
}
