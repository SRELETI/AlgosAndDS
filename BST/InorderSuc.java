
public class InorderSuc {

	private TreePrint head;
	private TreePrint suc;
	private TreePrint pre;
	public InorderSuc()
	{
		suc = null;
		pre = null;
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head== null)
		{
			head = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head;
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
	
	public TreePrint find(TreePrint node, int value)
	{
		if(node == null || node.data == value)
			return node;
		if(value<node.data)
			return find(node.left,value);
		else
			return find(node.right,value);
	}
	
	public void inorderPre(TreePrint node, int value)
	{
		if(node == null)
			return;
		if(node.data == value)
		{
			if(node.left!=null)
			{
				TreePrint temp = node.left;
				while(temp.right!=null)
					temp = temp.right;
				pre = temp;
			}
			if(node.right != null)
			{
				TreePrint temp = node.right;
				while(temp.left!=null)
					temp = temp.left;
				suc = temp;
			}
			return;
		}
		if(value<node.data)
		{
			suc = node;
			inorderPre(node.left,value);
		}
		else
		{
			pre = node;
			inorderPre(node.right,value);
		}
	}
	
	public static void main(String args[])
	{
		InorderSuc i = new InorderSuc();
		i.head = new TreePrint (50);
		i.head.left = new TreePrint(30);
		i.head.right = new TreePrint(70);
		i.head.left.left = new TreePrint(20);
		i.head.left.right = new TreePrint(40);
		i.head.right.left = new TreePrint(60);
		i.head.right.right = new TreePrint(80);
		
		i.inorderPre(i.head, 40);
		
		System.out.println(i.pre.data+" "+i.suc.data);
	}
}
