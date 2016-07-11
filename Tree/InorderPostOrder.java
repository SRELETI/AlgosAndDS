
public class InorderPostOrder {

	private TreePrint head;
	public InorderPostOrder()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int postIndex = 0;
	}
	public void construct(int[] in, int[] post)
	{
		int start = 0;
		int end = in.length-1;
		Wrapper h = new Wrapper();
		
		h.postIndex = end;
		
		head = constructTree(in,post,start,end,h);
		
		printIn(head);
		System.out.println();
		printPost(head);
	}
	
	private void printIn(TreePrint node)
	{
		if(node == null)
			return;
		printIn(node.left);
		System.out.print(node.data+" ");
		printIn(node.right);
	}
	
	private void printPost(TreePrint node)
	{
		if(node == null)
			return;
		printPost(node.left);
		printPost(node.right);
		System.out.print(node.data+" ");
	}
	private int search(int[] in, int start, int end, int data)
	{
		for(int i=start;i<=end;i++)
		{
			if(in[i]==data)
				return i;
		}
		return -1;
	}
	private TreePrint constructTree(int[] in, int[] post, int start, int end, Wrapper h)
	{
		if(start>end)
			return null;
		
		TreePrint newNode = new TreePrint(post[h.postIndex]);
		h.postIndex--;
		
		if(start==end)
			return newNode;
		
		int inIndex = search(in,start,end,newNode.data);
		
		newNode.right = constructTree(in,post,inIndex+1,end,h);
		newNode.left = constructTree(in,post,start,inIndex-1,h);
		
		return newNode;
	}
}
