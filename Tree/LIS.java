
public class LIS {

	public TreePrint head;
	public TreePrintDP first;
	
	public LIS()
	{
		head = null;
		first = null;
	}
	
	public void cal()
	{
		int result = calLIS(head);
		System.out.println(result);
	}
	
	public void mem_cal()
	{
		int result =calLISS(first);
		System.out.println(result);
	}
	
	private int calLISS(TreePrintDP node)
	{
		if(node == null)
			return 0;
		if(node.LISS>=1)
			return node.LISS;
		if(node.left==null && node.right==null)
		{
			node.LISS=1;
			return node.LISS;
		}
		int liss_excl = calLISS(node.left)+calLISS(node.right);
		
		int liss_incl = 1;
		if(node.left!=null)
			liss_incl = liss_incl + calLISS(node.left.left)+calLISS(node.left.right);
		if(node.right!=null)
			liss_incl = liss_incl + calLISS(node.right.left)+calLISS(node.right.right);
		node.LISS = liss_excl>liss_incl ? liss_excl : liss_incl;
		return node.LISS;
	}
	private int calLIS(TreePrint node)
	{
		if(node == null)
			return 0;
		int size_excl = calLIS(node.left) + calLIS(node.right);
		
		int size_incl =1;
		
		if(node.left!=null)
			size_incl = size_incl + calLIS(node.left.left)+calLIS(node.left.right);
		if(node.right!=null)
			size_incl = size_incl + calLIS(node.right.left)+calLIS(node.right.right);
		
		return size_incl>size_excl ? size_incl : size_excl;
	}
	
	
}
