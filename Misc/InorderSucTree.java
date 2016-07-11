
public class InorderSucTree {

	public TreePrint head;
	
	public InorderSucTree()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint (value);
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
				node = node.right;
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
	

	
	public TreePrint inorderSuc(TreePrint node, TreePrint result)
	{
		if(result.right!=null)
			return getSuc(result.right);
		
		TreePrint suc = null;
		while(node!=null)
		{
			if(result.data< node.data)
			{
				suc = node;
				node = node.left;
			}
			else if(result.data>node.data)
				node = node.right;
			else
				break;
				
		}
		return suc;
		
	}
}
