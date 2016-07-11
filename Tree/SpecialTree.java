
public class SpecialTree {

	public TreePrint head;
	
	public SpecialTree()
	{
		head =null;
	}
	
	public void constAndDis(int[] arr,int start,int end)
	{
		head = construct(arr,start,end);
		inorder(head);
	}
	
	private void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	public TreePrint construct(int[] arr,int start, int end)
	{
		if(start>end)
			return null;
		
		int max_node = find(arr,start,end);
		TreePrint node = new TreePrint(arr[max_node]);
		if(start == end)
			return node;
		
		node.left = construct(arr,start,max_node-1);
		node.right = construct(arr,max_node+1,end);
		return node;
	}
	
	private int find(int[] arr, int start, int end)
	{
		int max = start;
		for(int i=start;i<=end;i++)
		{
			if(arr[i]>arr[max])
				max =i;
		}
		return max;
	}
	
	
	public static void main(String args[])
	{
		SpecialTree s = new SpecialTree();
		int[] arr = {5,10,40,30,28};
		int start=0;
		int end = arr.length-1;
		s.constAndDis(arr, start, end);
	}
}
