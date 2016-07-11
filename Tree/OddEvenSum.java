
public class OddEvenSum {

	public TreePrint head;
	
	public OddEvenSum()
	{
		head = null;
	}
	
	private int sumDiff(TreePrint node)
	{
		if(node == null)
			return 0;
		
		return node.data - sumDiff(node.left)-sumDiff(node.right);
	}
	
	public void getDiff()
	{
		int sum = sumDiff(head);
		System.out.println(sum);
	}
	
	private class Wrapper
	{
		int maxLevel = 0;
	}
	public void leftView(TreePrint node)
	{
		System.out.print(node.data+" ");
		Wrapper max = new Wrapper();
		int level = 0;
		calcView(node,max,level);
	}
	
	private void calcView(TreePrint node, Wrapper maxLevel, int level)
	{
		if(node == null)
			return;
		if(maxLevel.maxLevel<level)
		{
			System.out.print(node.data+" ");
			maxLevel.maxLevel = level;
		}
		
		calcView(node.right,maxLevel,level+1);
		calcView(node.left,maxLevel,level+1);
	}
	
	public static void main(String args[])
	{
		OddEvenSum o = new OddEvenSum();
		
		o.head = new TreePrint(5);
		o.head.left = new TreePrint(2);
		o.head.right = new TreePrint(6);
		o.head.left.left = new TreePrint(1);
		o.head.left.right = new TreePrint(4);
		o.head.right.right = new TreePrint(8);
		o.head.right.right.left = new TreePrint(7);
		o.head.right.right.right = new TreePrint(9);
		o.head.left.right.left = new TreePrint(3);
		
		o.getDiff();
		
		o.leftView(o.head);
	}
}
