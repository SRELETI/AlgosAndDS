
public class Delete {

	public TreePrint head;
	
	public Delete()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head= newNode;
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
	public TreePrint deleteNode(int key)
	{
		head = delete(head,key);
		return head;
	}
	private TreePrint delete(TreePrint node, int key)
	{
		if(node == null)
			return node;
		if(key<node.data)
			node.left = delete(node.left,key);
		else if(key>node.data)
			node.right= delete(node.right,key);
		else
		{
			if(node.left == null)
			{
				TreePrint temp = node;
				node = node.right;
				return node;
			}
			else if (node.right == null)
			{
				TreePrint temp = node;
				node = node.left;
				return node;
			}
			else
			{
				TreePrint temp = getSuc(node);
				node.data = temp.data;
				node.right = delete(node.right,temp.data);
			}
		}
		return node;
	}
	private TreePrint getSuc(TreePrint node)
	{
		if(node == null)
			return null;
		TreePrint temp = node.right;
		while(temp.left!=null)
			temp=node.left;
		return temp;
	}
	
	public void printInorder()
	{
		inorder(head);
	}
	
	private void inorder(TreePrint node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
}