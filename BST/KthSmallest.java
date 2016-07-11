import java.util.Stack;


public class KthSmallest {

	public TreePrint head;
	
	public KthSmallest()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int value=0;
	}
	public void kth(TreePrint node, int k)
	{
		Wrapper s = new Wrapper();
		kthelement(node,k,s);
		iterativeKth(node,k);
		threadedKth(node,k);
	}
	
	private void kthelement(TreePrint node, int k, Wrapper s)
	{
		if(node!=null)
		{
			kthelement(node.left,k,s);
			s.value++;
			if(s.value==k)
			{
				System.out.println(node.data+" ");
				return;
			}
			kthelement(node.right,k,s);
		}
	}
	
	private void iterativeKth(TreePrint node, int k)
	{
		if(node == null)
			return;
		int count=0;
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		while(true)
		{
			if(node!=null)
			{
				s.push(node);
				node = node.left;
			}
			else
			{
				if(s.isEmpty())
					return;
				node = s.pop();
				count++;
				if(count==k)
				{
					System.out.println(node.data);
					return;
				}
				node = node.right;
			}
		}
	}
	
	private void threadedKth(TreePrint node, int k)
	{
		if(node == null)
			return;
		int count =0;
		
		while(node!=null)
		{
			if(node.left==null)
			{
				count++;
				if(count == k)
				{
					System.out.println(node.data+" ");
					return;
				}
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				while(temp.right!=null && temp.right!=node)
					temp = temp.right;
				if(temp.right==null)
				{
					temp.right = node;
					node = node.left;
				}
				else
				{
					temp.right = null;
					count++;
					if(count==k)
					{
						System.out.println(node.data+" ");
						return;
					}
					node = node.right;
				}
			}
		}
	}
	
	public void printBSTRange(TreePrint node, int k1, int k2)
	{
		if(node == null)
			return;
		if(k1<node.data)
			printBSTRange(node.left,k1,k2);
		if(k1<=node.data && k2>= node.data)
		{
			System.out.print(node.data+" ");
		}
		if(k2> node.data)
			printBSTRange(node.right,k1,k2);
	}
	
	public static void main(String args[])
	{
		KthSmallest k = new KthSmallest();
		
		k.head = new TreePrint(20);
		k.head.right = new TreePrint(22);
		k.head.left = new TreePrint(8);
		k.head.left.left = new TreePrint(4);
		k.head.left.right = new TreePrint(12);
		k.head.left.right.left = new TreePrint(10);
		k.head.left.right.right = new TreePrint(14);
		
		
		k.printBSTRange(k.head, 4, 20);
	//	k.kth(k.head, 7);
		
		
	}
}
