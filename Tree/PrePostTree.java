
public class PrePostTree {

	public TreePrint head;
	
	public PrePostTree()
	{
		head = null;
	}
	
	public TreePrint construct(int[] pre, int[] post, int start, int end)
	{
		Wrapper h = new Wrapper();
		TreePrint result = consTree(pre,post,start,end,h);
		inorder(result);
		return result;
	}
	
	private void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	private class Wrapper
	{
		int value =0;
	}
	
	private TreePrint consTree(int[] pre,int[] post, int start, int end, Wrapper h)
	{
		if(start>end)
			return null;
		TreePrint root = new TreePrint(pre[h.value]);
		h.value = h.value+1;
		if(start == end)
			return root;
		
		int postIndex = search(post,pre[h.value],start,end);
		
		root.left = consTree(pre,post,start,postIndex,h);
		root.right = consTree(pre,post,postIndex+1,end-1,h);
		
		return root;
	}
	
	
	private int search(int[] post, int value, int start, int end)
	{
		for(int i =start;i<=end;i++)
		{
			if(post[i]==value)
				return i;
		}
		return -1;
	}
}
