import java.util.Stack;


public class Leaf {

	private TreePrint head;
	
	public Leaf()
	{
		head = null;
	}
	
	public int count(TreePrint node)
	{
		if(node ==  null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		return count(node.left)+count(node.right);
	}
	
	private int height(TreePrint node)
	{
		if(node == null)
			return 0;
		return Math.max(height(node.left), height(node.right))+1;
	}
	public void print_rec()
	{
		int h = height(head);
		boolean bool = true;
		for(int i=0;i<h;i++)
		{
			print_now(head,i,bool);
			if(bool == false)
				bool = true;
			else
				bool = false;
		}
	}
	
	private void print_now(TreePrint node, int level, boolean bool)
	{
		if(node == null)
			return;
		if(level == 0)
			System.out.print(node.data+" ");
		if(bool == false)
		{
			print_now(node.left,level-1,bool);
			print_now(node.right,level-1,bool);
		}
		else
		{
			print_now(node.right,level-1,bool);
			print_now(node.left,level-1,bool);
		}
	}
	
	public boolean childSum(TreePrint node)
	{
		if(node == null || node.left == null && node.right==null)
			return true;
		int left =0,right =0;
		if(node.left!=null)
			left = node.left.data;
		if(node.right!=null)
			right = node.right.data;
		return (node.data == left+right && childSum(node.left)==true && childSum(node.right)==true);
	}
	
	private int sum(TreePrint node)
	{
		if(node == null)
			return 0;
		else
			return node.data+sum(node.left)+sum(node.right);
	}
	public void spiralLevel(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		Stack<TreePrint> s1 = new Stack<TreePrint>();
		
		s.push(node);
		while(!s1.isEmpty() || !s.isEmpty())
		{
			while(!s.isEmpty())
			{
			node = s.pop();
			System.out.print(node.data+" ");
			
			if(node.right!=null)
				s1.push(node.right);
			if(node.left!=null)
				s1.push(node.left);
			
		}
		
		while(!s1.isEmpty())
		{
			node = s1.pop();
			System.out.print(node.data+" ");
			
			if(node.left!=null)
				s.push(node.left);
			if(node.right!=null)
				s.push(node.right);
		}
		}
	}
	
	public static void main(String args[])
	{
		Leaf l = new Leaf();
		
		l.head = new TreePrint(10);
		l.head.left = new TreePrint(8);
		l.head.left.left= new TreePrint(3);
		l.head.left.right = new TreePrint(5);
		
		l.head.right = new TreePrint(2);
		l.head.right.left = new TreePrint(2);
	//	l.head.right.right = new TreePrint(7);
		
	//	System.out.println(l.count(l.head));
	//	l.spiralLevel(l.head);
	//	System.out.println();
	//	l.print_rec();
		
	//	System.out.println();
		
		System.out.println(l.childSum(l.head));
	}
}
