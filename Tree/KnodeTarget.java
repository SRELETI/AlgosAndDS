
public class KnodeTarget {

	public TreePrint head ;
	public TreePrint target;
	public KnodeTarget()
	{
		head = null;
	}
	
	public void print(int k)
	{
		distancePrint(head,target,k);
	}
	
	private int distancePrint(TreePrint node, TreePrint tar, int k)
	{
		if(node == null)
			return -1;
		if(node == tar)
		{
			printNodes(node,k);
			return 0;
		}
		
		int dl = distancePrint(node.left,tar,k);
		
		if(dl != -1)
		{
			if(dl+1 == k)
			{
				System.out.print(node.data+" ");
			}
			else
			{
				printNodes(node.right,k-dl-2);
			}
			return dl+1;
		}
		
		int dr = distancePrint(node.right, tar, k);
		
		if(dr != -1)
		{
			if(dr+1 == k)
				System.out.print(node.data+" ");
			else
				printNodes(node.left,k-dr-2);
			return dr+1;
		}
		return -1;
	}
	
	private void printNodes(TreePrint node, int k)
	{
		if(node == null)
			return;
		if(k==0)
		{
			System.out.print(node.data+" ");
			return;
		}
		printNodes(node.left,k-1);
		printNodes(node.right,k-1);
	}
}
