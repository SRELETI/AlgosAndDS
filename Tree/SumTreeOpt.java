
public class SumTreeOpt {

	public  TreePrint head;
	
	public SumTreeOpt()
	{
		head = null;
	}
	
	public void sum()
	{
		boolean result = sumTree(head);
		System.out.println(result == true ? "yes, it is a sum tree" : "No, it is not a sum tree");
	}
	
	private boolean isLeaf(TreePrint node)
	{
		if(node == null)
			return false;
		if(node.left == null && node.right == null)
			return true;
		else
			return false;
	}
	private boolean sumTree(TreePrint node)
	{
		if(node == null || node.left == null && node.right == null)
			return true;
		
		int ls=0;
		int rs =0;
		if(sumTree(node.left) == true && sumTree(node.right) == true)
		{
			if(node.left == null)
				ls =0;
			else if(isLeaf(node.left)==true)
				ls = node.left.data;
			else
				ls = 2 * (node.left.data);
			
			if(node.right == null)
				rs= 0;
			else if(isLeaf(node.right)==true)
				rs = node.right.data;
			else
				rs = 2 * (node.right.data);
		}
		return node.data == ls+rs;
	}
	
	
}
