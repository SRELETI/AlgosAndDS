
public class Amazon {

	public TreePrint head;
	
	public Amazon()
	{
		head = null;
	}
	
	public void construct(int[] pre, char [] LN)
	{
		Wrapper h  = new Wrapper();
		int size = pre.length;
		
		head  = cons(pre,LN,size,h);
		
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
	
	private TreePrint cons(int[] pre, char[] LN, int size, Wrapper h)
	{
		if(size == h.value)
			return null;
		TreePrint root = new TreePrint(pre[h.value]);
		h.value++;
		
		if(LN[h.value-1]=='N')
		{
			root.left = cons(pre,LN,size,h);
			root.right = cons(pre,LN,size,h);
		}
		return root;
	}
	
	
	public static void main(String args[])
	{
		Amazon a = new Amazon();
		
		int[] pre = {10,30,20,5,15};
		char[] LN = {'N','N','L','L','L'};
		
		a.construct(pre, LN);
	}
}
