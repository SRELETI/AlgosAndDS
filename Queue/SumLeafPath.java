
public class SumLeafPath {

	public TreePrint head;
	
	public SumLeafPath()
	{
		head = null;
	}
	
	public void sum()
	{
		int result = sumCal(head,0);
		System.out.println(result);
	}
	
	private int sumCal(TreePrint node, int val)
	{
		if(node == null)
			return 0;
		val = val*10 + node.data;
		if(node.left == null && node.right == null)
			return val;
		return sumCal(node.left,val)+sumCal(node.right,val);
	}
	
}
