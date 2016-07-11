
public class FindMax {

	public TreePrint head;
	
	public FindMax()
	{
		head = null;
	}
	
	public void constr(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		head = build(arr,start,end);
		print(head);
	}
	
	private void print(TreePrint node)
	{
		if(node == null)
			return;
		print(node.left);
		System.out.print(node.data+" ");
		print(node.right);
	}
	private int findMax(int[] arr ,int start, int end)
	{
		int max= 0;
		for(int i=start;i<=end;i++)
		{
			if(arr[i]>arr[max])
				max = i;
			
		}
		return max;
	}
	public TreePrint build(int[] tree, int start, int end)
	{
		if(start>end)
			return null;
		int index = findMax(tree,start,end);
		TreePrint root = new TreePrint(tree[index]);
		if(start==end)
			return root;
		
		root.left = build(tree,start,index-1);
		root.right = build(tree,index+1,end);
		return root;
	}
	
	public static void main(String args[])
	{
		int[] arr = {5,10,40,30,28};
		FindMax f = new FindMax();
		f.constr(arr);
	}
}
