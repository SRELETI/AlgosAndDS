
public class SpecialTrees {

	public TreePrint head;
	
	public SpecialTrees()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int value = 0;
	}
	
	public void special(int[] pre, int[] post)
	{
		Wrapper postIndex = new Wrapper();
		int start = 0;
		int end = pre.length-1;
		
		head = construct(pre,post,start,end,postIndex);
		
		printIn(head);
	}
	
	private void printIn(TreePrint node)
	{
		if(node == null)
			return;
		printIn(node.left);
		System.out.print(node.data+" ");
		printIn(node.right);
	}
	private TreePrint construct(int[] pre, int[] post, int start, int end, Wrapper postIndex)
	{
		if(start>end)
			return null;
		
		TreePrint newNode = new TreePrint(pre[postIndex.value]);
		postIndex.value++;
		
		if(start==end)
			return newNode;
		
		int index = search(post,pre[postIndex.value],start,end);
		
		
		newNode.left = construct(pre,post,start,index,postIndex);
		newNode.right = construct(pre,post,index+1,end-1,postIndex);
		return newNode;
	}
	
	private int search(int[] post, int value, int start, int end)
	{
		for(int i=start;i<=end;i++)
		{
			if(post[i]==value)
				return i;
		}
		return -1;
	}
}
