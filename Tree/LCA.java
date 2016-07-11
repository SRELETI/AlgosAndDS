
public class LCA {

	private TreePrint head;
	
	public LCA()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			TreePrint parent;
			TreePrint current = head;
			while(true)
			{
				parent = current;
				if(value<current.data)
				{
					current = current.left;
					if(current == null)
					{
						parent.left = newNode;
						return;
					}
				}
				else
				{
					current = current.right;
					if(current == null)
					{
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void check(int value1, int value2)
	{
		TreePrint node = checkLCA(head,value1,value2);
		System.out.println(node == null ? null : node.data);
		node = iterativeLCA(head,value1,value2);
		System.out.println(node == null ? null : node.data);
	}
	
	private TreePrint checkLCA(TreePrint node, int value1,int value2)
	{
		if(node == null)
			return null;
		
		if(value1<node.data && node.data < value2  || node.data == value1 || node.data == value2)
			return node;
		else if(node.data<value1 && node.data < value2)
			return checkLCA(node.right,value1,value2);
		else
			return checkLCA(node.left,value1,value2);
	}
	
	private TreePrint iterativeLCA(TreePrint node, int value1, int value2)
	{
		if(node == null)
			return null;
		
	//	Stack<TreePrint> s = new Stack<TreePrint>();
		
		while(node!=null)
		{
			if(value1<node.data && node.data<value2 || node.data == value1 || node.data == value2)
				return node;
			else if(node.data <value1 && node.data < value2)
				node = node.right;
			else
				node = node.left;
		}
		return null;
	}
}
