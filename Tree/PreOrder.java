import java.util.Stack;


public class PreOrder {

	public TreePrint head;
	
	public PreOrder()
	{
		head = null;
	}
	
	public void pre(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		s.push(node);
		
		while(!s.isEmpty())
		{
			node = s.pop();
			System.out.print(node.data+" ");
			
			if(node.right!=null)
				s.push(node.right);
			if(node.left != null)
				s.push(node.left);
		}
	}
	
	public void inorder(TreePrint node)
	{
		if(node == null)
			return;
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
				System.out.print(node.data+" ");
				node = node.right;
			}
		}
	}
	
	public void inorderMorris(TreePrint node)
	{
		if(node == null)
			return;
		while(node != null)
		{
			if(node.left==null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				
				while(temp.right!=null && temp.right!=node)
					temp = temp.right;
				if(temp.right == null)
				{
					temp.right = node;
					node = node.left;
				}
				else 
				{
					temp.right = null;
					System.out.print(node.data+" ");
					node = node.right;
				}
			}
		}
		
	}
	public void preMorris(TreePrint node)
	{
		if(node == null)
			return;
		while(node!=null)
		{
			if(node.left == null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				
				while(temp.right!=null && temp.right !=node)
					temp = temp.right;
				
				if(temp.right==null)
				{
					System.out.print(node.data+" ");
					temp.right = node;
					node = node.left;
				}
				else
				{
					temp.right = null;
					node= node.right;
				}
			}
		}
	}
	
	public void postOrder(TreePrint node)
	{
		if(node == null)
			return;
		
		Stack<TreePrint> s1 = new Stack<TreePrint>();
		Stack<TreePrint> s2 = new Stack<TreePrint>();
		s1.push(node);
		while(!s1.isEmpty())
		{
			node = s1.pop();
			s2.push(node);
			
			if(node.left!=null)
				s1.push(node.left);
			if(node.right!=null)
				s1.push(node.right);
		}
		
		while(!s2.isEmpty())
		{
			node = s2.pop();
			System.out.print(node.data+" ");
		}
 	}
	
	public void postOne(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		while(true)
		{
			if(node!=null)
			{
				if(node.right!=null)
					s.push(node.right);
				s.push(node);
				node = node.left;
			}
			else
			{
				if(s.isEmpty())
					return;
				node = s.pop();
				if(!s.isEmpty() && node.right == s.peek())
				{
					s.pop();
					s.push(node);
					node = node.right;
				}
				else
				{
					System.out.print(node.data+" ");
					node = null;
				}
			}
		}
		
	}
	
	public void levelOrder(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr a = new QueueArr(20);
		a.enqueue(node);
		while(!a.isEmpty())
		{
			node = a.dequeue();
			System.out.print(node.data+" ");
			if(node.left!=null)
				a.enqueue(node.left);
			if(node.right!=null)
				a.enqueue(node.right);
		}
	}
	
	public void reverseLevelOrder(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr q = new QueueArr(20);
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		q.enqueue(node);
		while(!q.isEmpty())
		{
			node= q.dequeue();
			s.push(node);
			if(node.right!=null)
				q.enqueue(node.right);
			if(node.left!=null)
				q.enqueue(node.left);
		}
		
		while(!s.isEmpty())
		{
			node = s.pop();
			System.out.print(node.data+" ");
		}
	}
	public static void main(String args[])
	{
		PreOrder p = new PreOrder();
		p.head = new TreePrint(1);
		p.head.left = new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.left = new TreePrint(4);
		p.head.left.right = new TreePrint(5);
		p.head.right.left = new TreePrint(6);
		p.head.right.right = new TreePrint(7);
		p.pre(p.head);
		System.out.println();
		p.preMorris(p.head);
		System.out.println();
		p.inorder(p.head);
		System.out.println();
		p.inorderMorris(p.head);
		
		System.out.println();
		p.postOrder(p.head);
		System.out.println();
		p.postOne(p.head);
		System.out.println();
		p.levelOrder(p.head);
		
		System.out.println();
		p.reverseLevelOrder(p.head);
	}
}
