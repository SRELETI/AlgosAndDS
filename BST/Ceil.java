
public class Ceil {

	private TreePrint head;
	
	public Ceil()
	{
		head = null;
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
		TreePrint temp =head;
		while(true)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp == null)
				{
					parent.left= newNode;
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
	
	public int findCeil(int key)
	{
		return ciel(head,key);
	}
	private int ciel(TreePrint node, int key)
	{
		if(node == null)
			return -1;
		if(node.data == key)
			return node.data;
		if(key>node.data)
			return ciel(node.right,key);
		else
		{
			int val = ciel(node.left,key);
			return val >= key ? val : node.data;
		}
	}
	
	public int findFloor(int key)
	{
		return floor(head,key);
	}
	
	private int floor(TreePrint node, int key)
	{
		if(node == null)
			return -1;
		if(node.data == key)
			return node.data;
		if(node.data>key)
			return floor(node.left,key);
		else
		{
			int result = floor(node.right,key);
			return result <=key && result !=-1 ? result : node.data;
		}
	}
}

