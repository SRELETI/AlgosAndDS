
public class SearchInsertRev {

	private TreePrint head;
	
	public SearchInsertRev()
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
	public TreePrint findNode(int key)
	{
		return find(head,key);
	}
	
	private TreePrint find(TreePrint node,int key)
	{
		if(node == null)
			return null;
		if(node.data == key)
			return node;
		if(key<node.data)
			return find(node.left,key);
		else
			return find(node.right,key);
	}
	
	public void inorder()
	{
		printInorder(head);
	}
	
	private void printInorder(TreePrint node)
	{
		if(node!=null)
		{
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
}
