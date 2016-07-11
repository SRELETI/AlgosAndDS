
public class MaxLeafSum {

	
	public TreePrint head;
	private TreePrint result_leaf= new TreePrint(0);
	
	public MaxLeafSum()
	{
		head = null;
	}
	
	private class Wrapper_Max
	{
		int value =Integer.MIN_VALUE;
	}
	private class Wrapper_cur
	{
		int value=0;
	}
	public void maxLeaf()
	{
		
		
		Wrapper_Max max_sum = new Wrapper_Max();
		int cur_sum=0;
		
		maxLeafNode(head,max_sum,cur_sum);
		
		System.out.println(max_sum.value);
		System.out.println(result_leaf.data);
		print(head,result_leaf);
		
	}
	
	private void maxLeafNode(TreePrint node , Wrapper_Max max_sum, int cur_sum)
	{
		if(node == null)
			return ;
		cur_sum = cur_sum + node.data;
		if(node.left==null && node.right==null)
		{
			
			if(cur_sum > max_sum.value)
			{
				max_sum.value = cur_sum;
				result_leaf = node;
				return;
			}
		}
		maxLeafNode(node.left,max_sum,cur_sum);
		maxLeafNode(node.right,max_sum,cur_sum);
	}
	
	private boolean print(TreePrint node, TreePrint result_node)
	{
		if(node == null)
			return false;
		if(node == result_node)
		{
			System.out.print(result_node.data+" ");
			return true;
		}
		
		if(print(node.left,result_node)==true || print(node.right,result_node)==true)
		{
			System.out.print(node.data+" ");
			return true;
		}
		else
			return false;
	}
}
