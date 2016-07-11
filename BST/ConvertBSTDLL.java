
public class ConvertBSTDLL {

	private TreePrint head;
	private TreePrint start;
	private TreePrint tail;
	
	public ConvertBSTDLL()
	{
		head = null;
		
		start = null;
		tail = null;
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
	
	public TreePrint delete(TreePrint node, int value)
	{
		if(node == null)
			return node;
		if(value<node.data)
			node.left = delete(node.left,value);
		else if(value>node.data)
			node.right = delete(node.right,value);
		else
		{
			if(node.left == null)
			{
				node = node.right;

			}
			else if(node.right == null)
				node = node.left;
			else
			{
				TreePrint temp = getSuc(node.right);
				node.data = temp.data;
				node.right = delete(node.right,temp.data);
			}
		}
		return node;
	}
	
	private TreePrint getSuc(TreePrint node)
	{
		while(node.left!=null)
			node = node.left;
		return node;
	}
	
	
	private void convertDll(TreePrint node)
	{
		if(node == null)
			return;
		if(node.left!=null)
			convertDll(node.left);
		node.left = tail;
		if(tail!=null)
			tail.right =node;
		else
			start = node;
		tail = node;
		convertDll(node.right);
	}
	
	public void convert()
	{
		convertDll(head);
		printDll(start);
	}
	
	
	private void printDll(TreePrint node)
	{
		TreePrint temp = node;
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
	}
	
}
