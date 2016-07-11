
public class ConvertBSTtoDLL {

	public TreePrint head;
	
	public TreePrint start;
	public TreePrint tail;
	public ConvertBSTtoDLL()
	{
		head = null;
		start =null;
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
		while(temp!=null)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp== null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				temp = temp.right;
				if(temp ==null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public boolean checkTriplet(TreePrint node)
	{
		if(node == null)
			return false;
		
		convertToDLL(node);
		
		while(start.right!=tail && start.data < 0)
		{
			if(isPresent(start.right,tail,-1*start.data)==true)
				return true;
			else
				start = start.right;
		}
		return false;
	}
	
	private boolean isPresent(TreePrint node, TreePrint end, int value)
	{
		while(node!=end)
		{
			int cur = node.data+end.data;
			if(cur == value)
				return true;
			else if(cur<value)
				node = node.right;
			else
				end = end.left;
		}
		return false;
	}
	
	private void convertToDLL(TreePrint node)
	{
		if(node == null)
			return;
		convertToDLL(node.left);
		node.left = tail;
		if(tail!=null)
			tail.right = node;
		else
			start = node;
		
		tail = node;
		convertToDLL(node.right);
	}
	
	public static void main(String args[])
	{
		ConvertBSTtoDLL c = new ConvertBSTtoDLL();
		c.insert(6);
		c.insert(-13);
		c.insert(-8);
		c.insert(14);
		c.insert(13);
		c.insert(7);
		c.insert(15);
		System.out.println(c.checkTriplet(c.head));
	}
}
