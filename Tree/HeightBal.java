
public class HeightBal {

	public TreePrint head;
	
	public HeightBal()
	{
		head = null;
	}
	private class Wrapper
	{
		int value=0;
	}
	
	public void calc()
	{
		Wrapper h = new Wrapper();
		boolean result = heightBaln(head,h);
		System.out.println(result);
	}
	private boolean heightBaln(TreePrint node, Wrapper h)
	{
		if(node == null)
			return true;
		Wrapper lh = new Wrapper();
		Wrapper rh = new Wrapper();
		
		boolean llh = heightBaln(node.left,lh);
		boolean rrh = heightBaln(node.right,rh);
		
		h.value = Math.max(lh.value, rh.value)+1;
		
		return Math.abs(lh.value-rh.value)<=1 && llh && rrh;
	}
	
	public void heightbal()
	{
		boolean result = check(head);
		System.out.println(result);
	}
	
	private boolean check(TreePrint node)
	{
		if(node == null)
			return true;
		
		int lh = height(node.left);
		int rh = height(node.right);
		
		return (Math.abs(lh-rh)<=1 && check(node.left)== true && check(node.right)==true);
	}
	
	private int height(TreePrint node)
	{
		if(node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh)+1;
	}
	
	public void checkLeafNode(int sum)
	{
		boolean result = checkLeaf(head,sum);
		System.out.println(result);
	}
	public boolean checkLeaf(TreePrint node, int sum)
	{
		if(node == null)
		{
			return sum==0;
		}
		sum = sum-node.data;
		if(node.left == null && node.right==null)
		{
			if(sum == 0)
				return true;
			else
				return false;
		}
		
		return checkLeaf(node.left,sum) ==true || checkLeaf(node.right,sum) == true;
	}
	
	public static void main(String args[])
	{
		HeightBal h = new HeightBal();
		
		h.head = new TreePrint(1);
		h.head.left = new TreePrint(2);
		h.head.right = new TreePrint(3);
		h.head.left.left = new TreePrint(4);
		h.head.left.right = new TreePrint(5);
		h.head.left.left.left = new TreePrint(8);
		
	//	h.heightbal();
	//	h.calc();
		
		h.checkLeafNode(8);
	}
}
