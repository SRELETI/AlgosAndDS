
public class MaxSumNode {

	
	public TreePrint head;
	private TreePrint maxNode;
	public MaxSumNode()
	{
		maxNode = null;
		head = null;
	}
	
	
	private class Wrapper 
	{
		int max = 0;
	}
	
	public void calcMax()
	{
		Wrapper h = new Wrapper();
		int sum = 0;
		maxSum(head,sum,h);
		System.out.println(h.max);
		System.out.println(maxNode == null ? null : maxNode.data);
		print(head,maxNode);
	}
	
	private boolean print(TreePrint node, TreePrint max)
	{
		if(node == null)
			return false;
		if(node.data == max.data)
		{
			System.out.print(node.data+" ");
			return true;
		}
		
		if(print(node.left,max)==true || print(node.right,max)==true)
		{
			System.out.print(node.data+" ");
			return true;
		}
		else
			return false;
		
		
	}
	private void maxSum(TreePrint node, int sum, Wrapper maxSum)
	{
		if(node == null)
			return;
		sum = sum+node.data;
		if(node.left == null && node.right == null)
		{
			if(sum>maxSum.max)
			{
				maxNode = node;
				maxSum.max = sum;
			}
			return;
		}
		maxSum(node.left,sum,maxSum);
		maxSum(node.right,sum,maxSum);
	}
	
	public static void main(String args[])
	{
		MaxSumNode m = new MaxSumNode();
		
		m.head = new TreePrint(10);
		m.head.left = new TreePrint(-2);
		m.head.right = new TreePrint(7);
		m.head.left.left = new TreePrint(8);
		m.head.left.right = new TreePrint(-4);
		
		m.calcMax();
	}
}
