
public class CorrectBST {

	public TreePrint head;
	public TreePrint first,middle,last,prev;
	
	public CorrectBST()
	{
		head = null;
		first = null;
		middle=last=prev=null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		TreePrint parent;
		TreePrint temp = head;
		while(true)
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
	
	public void correctBST(TreePrint node)
	{
		correctTree(node);
		printInorder(node);
		if(first != null && last!=null)
		{
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}
		else if(first!=null && middle!=null)
		{
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
		printInorder(node);
	}
	
	private void printInorder(TreePrint node)
	{
		if(node!=null)
		{
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	private void correctTree(TreePrint node)
	{
		if(node == null)
			return;
		correctTree(node.left);
		
		if(prev!=null && node.data<prev.data)
		{
			if(first==null)
			{
				first = prev;
				middle = node;
			}
			else
			{
				last = node;
			}
			
		}
		prev = node;
		
		correctTree(node.right);
	}
	
	public static void main(String args[])
	{
		CorrectBST c= new CorrectBST();
		
		c.head = new TreePrint(10);
		c.head.right = new TreePrint(8);
		c.head.left = new TreePrint(5);
		c.head.left.left = new TreePrint(2);
		c.head.left.right = new TreePrint(20);
		
		c.correctBST(c.head);
	}
}
