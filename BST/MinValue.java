
public class MinValue {

	public TreePrint head;
	
	public MinValue()
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
		TreePrint parent ;
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
	
	public int minValue(TreePrint node)
	{
		if(node == null)
			return 0;
		while(node.left!=null)
		{
			node= node.left;
		}
		return node.data;
	}
}
