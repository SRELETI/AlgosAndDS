
public class InorderLevel {

	
	public TreePrint head;
	
	public InorderLevel()
	{
		head = null;
	}
	
	public void constructTree(int[] in, int[] level)
	{
		int start = 0;
		int end = in.length-1;
		
		head = construct(in,level,start,end);
		
		printTree(head);
		
	}
	
	private void printTree(TreePrint node)
	{
		if(node == null)
			return;
		printTree(node.left);
		System.out.print(node.data+" ");
		printTree(node.right);
	}
	
	private int search(int[] in, int start,int end,int value)
	{
		for(int i=start;i<=end;i++)
		{
			if(in[i]==value)
				return i;
		}
		return -1;
	}
	
	private int[] constructnew(int[] in, int[] level, int start,int end)
	{
		int[] result = new int[end+1];
		int k=0;
		for(int i=start;i<=end;i++)
		{
			for(int j=0;j<level.length;j++)
			{
				if(in[i]==level[j])
				{
					result[k]=in[i];
					k++;
					break;
				}
			}
		}
		return result;
	}
	private TreePrint construct(int[] in, int[] level, int start,int end)
	{
		if(start>end)
			return null;
		TreePrint newNode = new TreePrint(level[0]);
		if(start == end)
			return newNode;
		
		int inIndex = search(in,start,end,newNode.data);
		
		int [] larray = constructnew(in,level,start,inIndex-1);
		int [] rarray = constructnew(in,level,inIndex+1,end);
		
		newNode.left = construct(in,larray,start,inIndex-1);
		newNode.right = construct(in,rarray,inIndex+1,end);
		return newNode;
	}
}
