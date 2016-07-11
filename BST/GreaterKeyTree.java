
public class GreaterKeyTree {

	private TreePrint head;
	
	public GreaterKeyTree()
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
	
	private class Wrapper
	{
		int value=0;
	}
	public void greaterTreePrint()
	{
		Wrapper s = new Wrapper();
		TreePrint node = greaterTree(head,s);
		print(node);
	}
	
	private void print(TreePrint node)
	{
		if(node!=null)
		{
			print(node.left);
			System.out.print(node.data+" ");
			print(node.right);
		}
	}
	private TreePrint greaterTree(TreePrint node, Wrapper data)
	{
		if(node==null)
			return null;
		node.right = greaterTree(node.right,data);
		data.value = data.value + node.data;
		node.data = data.value;
		node.left = greaterTree(node.left,data);
		return node;
	}
}
