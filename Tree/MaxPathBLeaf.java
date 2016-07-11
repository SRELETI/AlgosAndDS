
public class MaxPathBLeaf {

	public TreePrint head;
	
	public MaxPathBLeaf()
	{
		head = null;
	}
	private class Wrapper
	{
		int value=Integer.MIN_VALUE;
	}
	
	public void maxSum()
	{
		Wrapper h = new Wrapper();
		
		sum(head,h);
		
		System.out.print(h.value);
	}
	
	private int sum(TreePrint node, Wrapper h)
	{
		if(node== null)
			return 0;
		
		int lsum = sum(node.left,h);
		int rsum = sum(node.right,h);
		
		int cur_sum = Math.max(lsum+rsum+node.data, Math.max(lsum, rsum));
		
		if(cur_sum>h.value)
			h.value = cur_sum;
		
		return (Math.max(lsum, rsum))+node.data;
	}
}
