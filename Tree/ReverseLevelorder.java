import java.util.Stack;


public class ReverseLevelorder {

	public TreePrint head;
	
	public ReverseLevelorder()
	{
		head = null;
	}
	
	public void getLevelReverse()
	{
		int height = height(head);
	//	System.out.print(height);
		for(int i=height;i>=1;i--)
			printLevel(head,i);
			
	}
	
	private int height(TreePrint node)
	{
		if(node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		
		return left > right ? left+1 : right+1;
	}
	
	private void printLevel(TreePrint node, int level)
	{
		if(node == null)
			return;
		if(level == 1)
		{
			System.out.print(node.data+" ");
			return;
		}
		
		printLevel(node.left,level-1);
		printLevel(node.right,level-1);
	}
	
	public void reversePrint()
	{
		reverse(head);
	}
	
	private void reverse(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		QueueArr p = new QueueArr(10);
		p.enqueue(node);
		while(!p.isEmpty())
		{
			TreePrint root = p.peek();
			p.dequeue();
			s.push(root);
			
			if(root.right!=null)
				p.enqueue(root.right);
			if(root.left!=null)
				p.enqueue(root.left);
		}
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop().data+" ");
		}
	}
}
