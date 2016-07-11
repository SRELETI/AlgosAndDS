

public class KthElement {

	public TreePrint head;
	
	public KthElement()
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
				if(temp ==null)
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
			else if (node.right == null)
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
			node= node.left;
		return node;
	}
	
	private class Wrapper
	{
		int count =0;
	}
	
	public void getKth(int k)
	{
		Wrapper s = new Wrapper();
		getK(head,s,k);
	}
	
	private void getK(TreePrint node, Wrapper s, int k)
	{
		if(node!=null)
		{
			getK(node.left,s,k);
			s.count++;
			if(s.count == k)
				System.out.println(node.data+" ");
			getK(node.right,s,k);
		}
	}
}


