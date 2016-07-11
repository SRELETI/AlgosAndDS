
public class RootToLeafPrint {
	
	private TreePrint head;
	
	public RootToLeafPrint()
	{
		head = null;
	}
	
	private int height(TreePrint node)
	{
		if(node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		return (left>right ? left+1 : right+1);
	}
	public void print(TreePrint node)
	{
		int h = height(node);
		int[] arr = new int[h];
		int count=0;
		printLeaf(node,arr,count);
	}
	
	public void printLeaf(TreePrint node , int[] arr , int count)
	{
		if(node == null )
			return;
		arr[count++] = node.data;
		if(node.left==null && node.right == null)
			printArray(arr,count);
		printLeaf(node.left,arr,count);
		printLeaf(node.right,arr,count);
	}
	
	private void printArray(int[] arr, int count)
	{
		for(int i=0;i<count;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		RootToLeafPrint r = new RootToLeafPrint();
		r.head = new TreePrint(1);
		r.head.left = new TreePrint(2);
		r.head.right = new TreePrint(3);
		r.head.left.left = new TreePrint(4);
		r.head.left.right = new TreePrint(5);
		
		r.print(r.head);
	}
}
