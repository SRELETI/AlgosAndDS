
public class MaxWith {
	
	private TreePrint head;
	
	public MaxWith()
	{
		head = null;
	}
	
	public void max(TreePrint node)
	{
		int height = hi(node);
		int count=0;
		int max_count=0;
		for(int i=1;i<=height;i++)
		{
			count = calc(node,i);
			if(count>max_count)
				max_count = count;
		}
		System.out.println("The max count is "+max_count);
	}
	
	private int hi(TreePrint node)
	{
		if(node == null)
			return 0;
		int left = hi(node.left);
		int right = hi(node.right);
		
		return left>right ? left+1 : right+1;
	}
	
	private int calc(TreePrint node, int level)
	{
		if(node == null)
			return 0;
		if(level ==1)
			return 1;
		
		return calc(node.left,level-1)+calc(node.right,level-1);
	}
	
	public static void main(String args[])
	{
		MaxWith m = new MaxWith();
		m.head = new TreePrint (1);
		m.head.left = new TreePrint(2);
		m.head.right = new TreePrint(3);
		m.head.left.left = new TreePrint(4);
		m.head.left.right = new TreePrint(5);
		m.head.right.right = new TreePrint(8);
		m.head.right.right.left = new TreePrint(6);
		m.head.right.right.right = new TreePrint(7);
		
		m.max(m.head);
		m.maxWidthCheck(m.head);
	}
	
	
	public void maxWidthCheck(TreePrint node)
	{
		int height = hi(node);
	//	System.out.println(height);
		int[] arr = new int[height];
		int level=0;
		widthFound(node,arr,level);
		int result =max(arr,height);
		System.out.println(result);
	}
	
	public int max(int[] arr, int height)
	{
		int max =arr[0];
		for(int i=0;i<height;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
	
	private void widthFound(TreePrint node, int[] arr, int count)
	{
		if(node==null)
			return;
		arr[count]++;
		widthFound(node.left,arr,count+1);
		widthFound(node.right,arr,count+1);
	}
	
}
