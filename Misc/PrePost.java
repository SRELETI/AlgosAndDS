
public class PrePost {

	
	public TreePrint head;
	
	public PrePost()
	{
		head = null;
	}
	
	public void cons(int[] pre , int[] post)
	{
		Wrapper h = new Wrapper();
		int start = 0;
		int end = pre.length-1;
		
		head = build(pre,post,start,end,h);
		printIn(head);
	}
	
	private void printIn(TreePrint node)
	{
		if(node!=null)
		{
			printIn(node.left);
			System.out.print(node.data+" ");
			printIn(node.right);
		}
	}
	
	private class Wrapper
	{
		int value = 0;
	}
	private TreePrint build(int[] pre, int[] post, int start, int end, Wrapper h)
	{
		if(start>end)
			return null;
		TreePrint root = new TreePrint(pre[h.value]);
		h.value++;
		if(start == end)
			return root;
		int postIndex = search(post,start,end,pre[h.value]);
		
		root.left = build(pre,post,start,postIndex,h);
		root.right= build(pre,post,postIndex+1, end-1,h);
		return root;
	}
	
	private int search(int[] pre,int start,int end, int value)
	{
		for(int i=start;i<=end;i++)
		{
			if(pre[i]==value)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		PrePost p = new PrePost();
		
		int[] pre = {1,2,4,8,9,5,3,6,7};
		int[] post = {8,9,4,5,2,6,7,3,1};
		
		p.cons(pre, post);
	}
}
