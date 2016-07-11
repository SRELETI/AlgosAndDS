
public class VerticalPrint {
	
	public TreePrint head;
	
	public VerticalPrint()
	{
		head = null;
	}
	
	public void verticalPrint()
	{
		vertical(head);
	}
	
	private class Wrapper
	{
		int length =0;
	}
	
	private void findMinMax(TreePrint node, Wrapper max, Wrapper min, int hd)
	{
		if(node == null)
			return;
		if(hd<min.length)
			min.length=hd;
		if(hd>max.length)
			max.length=hd;
		findMinMax(node.left,max,min,hd-1);
		findMinMax(node.right,max,min,hd+1);
	}
	
	
	private void vertical(TreePrint node)
	{
		if(node==null)
			return;
		Wrapper min = new Wrapper();
		Wrapper max = new Wrapper();
		
		findMinMax(node,max,min,0);
		
		for(int i=min.length;i<=max.length;i++)
		{
			printVertical(node,i,0);
			System.out.println();
		}
	}
	
	private void printVertical(TreePrint node, int i, int hd)
	{
		if(node == null)
			return;
		if(hd == i)
		{
			System.out.print(node.data+" ");
		}
		printVertical(node.left,i,hd-1);
		printVertical(node.right,i,hd+1);
	}
}
