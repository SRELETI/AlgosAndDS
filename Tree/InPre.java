
public class InPre {

	public TreePrint head;
	
	public InPre()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int value =0;
	}
	public void tree(int[] pre, int[] in)
	{
		Wrapper h = new Wrapper();
		int length = in.length-1;
		head = cons(pre,in,0,length,h);
		postOrder(head);
	}
	
	private void postOrder(TreePrint node)
	{
		if(node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	private TreePrint cons(int[] pre, int[] in, int start, int end, Wrapper h)
	{
		if(start>end)
			return null;
		TreePrint newNode = new TreePrint(pre[h.value]);
		h.value = h.value+1;
	//	System.out.println(h.value);
		if(start==end)
			return newNode;
		
		int inIndex = search(in,newNode.data, start, end);
		
		newNode.left = cons(pre,in,start,inIndex-1,h);
		newNode.right = cons(pre, in, inIndex+1, end,h);
		return newNode;
	}
	
	private int search(int[] arr, int data, int start, int end)
	{
		for(int i=start;i<=end;i++)
		{
			if(arr[i]==data)
				return i;
		}
		return -1;
	}
	
	public void pi(int[] pre, int[] in)
	{
		Wrapper p = new Wrapper();
		cons1(pre,in,0,in.length-1,p);
	}
	
	private boolean cons1(int[] pre, int[] in, int start, int end, Wrapper h)
	{
		if(start>end)
			return true;
	//	TreePrint newNode = new TreePrint(pre[h.value]);
		int result = pre[h.value];
	//	System.out.println(result+" r ");
		h.value = h.value+1;
		if(start==end)
		{
			System.out.println(result);
			return true;
		}
	//	System.out.println(pre[result]+" p ");
		int inIndex = search(in,result, start, end);
		
		cons(pre,in,start,inIndex-1,h);
		cons(pre, in, inIndex+1, end,h);
		System.out.print(result+" ");
		return true;
	}
}
