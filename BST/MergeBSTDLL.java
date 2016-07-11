import java.util.Stack;


public class MergeBSTDLL {

	private TreePrint head1;
	private TreePrint head2;
	
	private TreePrint start1;
	private TreePrint tail1;
	
	private TreePrint start2;
	private TreePrint tail2;
	
	private TreePrint start3;
	private TreePrint tail3;
	
	public MergeBSTDLL()
	{
		head1 = null;
		head2 = null;
		
		start1 = null;
		start2 = null;
		
		tail1 = null;
		tail2 = null;
	}
	
	private class Wrapper
	{
		TreePrint temp = start3;
	}
	private TreePrint constructBST(Wrapper s, int count)
	{
		if(count<=0)
			return null;
		TreePrint left = constructBST(s,count/2);
		
		TreePrint root = new TreePrint(s.temp.data);
		
		root.left = left;
		
		s.temp = s.temp.right;
		
		root.right = constructBST(s,count-(count/2)-1);
		return root;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head1 == null)
		{
			head1 = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head1;
		while(temp!=null)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				temp = temp.right;
				if(temp == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void insert2(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head2 == null)
		{
			head2 = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head2;
		while(temp!=null)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				temp = temp.right;
				if(temp == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void printInorder(TreePrint node)
	{
		if(node!=null)
		{
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	
	private void convertDLL(TreePrint node)
	{
		if(node ==null)
			return;
		convertDLL(node.left);
		node.left = tail1;
		if(tail1!=null)
			tail1.right = node;
		else
			start1 = node;
		tail1 = node;
		convertDLL(node.right);
	}
	
	private void convertDLL2(TreePrint node)
	{
		if(node ==null)
			return;
		convertDLL2(node.left);
		node.left = tail2;
		if(tail2!=null)
			tail2.right = node;
		else
			start2 = node;
		tail2 = node;
		convertDLL2(node.right);
	}
	
	public void mergreTree(TreePrint node1, TreePrint node2)
	{
		convertDLL(node1);
		convertDLL2(node2);
		
	//	display(start1);
	//	display(start2);
		mergeDLL(start1,start2);
	//	display(start3);
	//	System.out.println(start3.data+" "+tail3.data);
		int count = length(start3);
		System.out.println(count);
		Wrapper s = new Wrapper();
		TreePrint finalTree = constructBST(s,count);
	//	TreePrint finalTree = constructTree(start3,tail3);
		printInorder(finalTree);
		
	}
	
	private int length(TreePrint node)
	{
		TreePrint temp = node;
		int count = 0;
		while(temp!=null)
		{
			count++;
			temp = temp.right;
		}
		return count;
	}
	
	
	private void display(TreePrint node)
	{
		TreePrint temp = node;
		while(temp!=null )
		{
			temp.display();
			temp = temp.right;
		}
		System.out.println();
	}
	private TreePrint constructTree(TreePrint node,TreePrint tail)
	{
		if(node == null )
			return null;
		TreePrint middle = getMiddle(node,tail);
		
		TreePrint root = new TreePrint(middle.data);
		if(node == tail)
			return root;
		TreePrint left = middle.left;
		TreePrint right = middle.right;
		if(left!=null)
			left.right=null;
		if(right!=null)
			right.left = null;
	//	display(node);
	//	display(right);
	//	System.out.println(left.left.data);
		root.left = constructTree(node,left);
		root.right = constructTree(right,tail);
		return root;
	}
	
	private TreePrint getMiddle(TreePrint node, TreePrint tail)
	{
		TreePrint slow = node;
		TreePrint fast = node;
		while(fast!=null && fast.right!=null && slow!=null)
		{
			fast = fast.right.right;
			slow = slow.right;
		}
		return slow;
	}
	private void add(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(start3 == null)
		{
			start3 = newNode;
			tail3 = newNode;
		}
		else
		{
			tail3.right = newNode;
			newNode.left = tail3;
			tail3 = newNode;
		}
	}
	private void mergeDLL(TreePrint node1, TreePrint node2)
	{
		TreePrint temp1 = node1;
		TreePrint temp2 = node2;
		while(temp1!=null && temp2 != null)
		{
			if(temp1.data<temp2.data)
			{
				add(temp1.data);
				temp1 = temp1.right;
			}
			else if(temp2.data<temp1.data)
			{
				add(temp2.data);
				temp2 = temp2.right;
			}
			else
			{
				add(temp1.data);
				temp1 = temp1.right;
				temp2 = temp2.right;
			}
		}
		
		while(temp1!=null)
		{
			add(temp1.data);
			temp1 = temp1.right;
		}
		while(temp2!=null)
		{
			add(temp2.data);
			temp2 = temp2.right;
		}
	}
	
	public void mergreTreesIterative(TreePrint node1, TreePrint node2)
	{
		Stack<TreePrint> s1 = new Stack<TreePrint>();
		TreePrint temp1 = node1;
		
		Stack<TreePrint> s2 = new Stack<TreePrint>();
		TreePrint temp2 = node2;
		
		if(temp1==null)
		{
			inorder(temp2);
			return;
		}
		if(temp2 == null)
		{
			inorder(temp1);
			return;
		}
		
		while(temp1!=null || s1.isEmpty() == false || temp2!=null || s2.isEmpty()==false)
		{
			if(temp1!=null || temp2!=null)
			{
				if(temp1!=null)
				{
					s1.push(temp1);
					temp1 = temp1.left;
				}
				if(temp2!=null)
				{
					s2.push(temp2);
					temp2 = temp2.left;
				}
			}
			else
			{
				if(s1.isEmpty()==true)
				{
					while(s2.isEmpty()==false)
					{
						temp2 = s2.pop();
						temp2.left = null;
						inorder(temp2);
					}
					return;
				}
				if(s2.isEmpty()==true)
				{
					while(s1.isEmpty()==false)
					{
						temp1 = s1.pop();
						temp1.left = null;
						inorder(temp1);
					}
					return;
				}
				
				temp1 = s1.pop();
				temp2 = s2.pop();
				
				if(temp1.data<temp2.data)
				{
					System.out.print(temp1.data+" ");
					temp1 = temp1.right;
					s2.push(temp2);
					temp2 = null;
				}
				else
				{
					System.out.print(temp2.data+" ");
					temp2 = temp2.right;
					s1.push(temp1);
					temp1 = null;
				}
			}
		}
		
	}
	
	private void inorder(TreePrint node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	public static void main(String args[])
	{
		MergeBSTDLL m = new MergeBSTDLL();
		
		m.insert(8);
		m.insert(2);
		m.insert(10);
		m.insert(1);
	//	m.insert(70);
		
		m.insert2(5);
		m.insert2(3);
		m.insert2(0);
		
		m.printInorder(m.head1);
		System.out.println();
		m.printInorder(m.head2);
	
		
		m.mergreTree(m.head1, m.head2);
		System.out.println();
	//	m.mergreTreesIterative(m.head1, m.head2);
	}
}
