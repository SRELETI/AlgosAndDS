
public class Minimum {

	private TreePrint head;
	private TreePrint suc;
	private TreePrint pre;
	public Minimum()
	{
		head = null;
		suc= null;
		pre = null;
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
	
	public TreePrint find(TreePrint node,int key)
	{
		if(node == null)
			return null;
		if(key>node.data)
			return find(node.right,key);
		if(key<node.data)
			return find(node.left,key);
		else 
			return node;
					
	}
	
	public TreePrint delete(TreePrint node, int key)
	{
		if(node == null)
			return node;
		if(key<node.data)
			node.left =delete(node.left,key);
		else if(key>node.data)
			node.right = delete(node.right,key);
		else
		{
			if(node.left == null)
			{
				node = node.right;
				
			}
			else if(node.right == null)
			{
				node = node.left;
				
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
			return node;
		TreePrint temp = node.right;
		while(temp.left!=null)
			temp = temp.left;
		return temp;
	}
	
	public void findMin()
	{
		System.out.println(find(head));
	}
	
	private int find(TreePrint node)
	{
		if(node == null)
			return -1;
		while(node.left!=null)
			node = node.left;
		return node.data;
	}
	
	public void getPreS(int key)
	{
		getSucPre(head,key);
		
		System.out.println(pre == null ? null : pre.data);
		System.out.println(suc == null ? null : suc.data);
	}
	
	private void getSucPre(TreePrint node, int key)
	{
		if(node == null)
			return;
		if(node.data == key)
		{
			TreePrint temp = node.right;
			while(temp!=null && temp.left!=null)
				temp = temp.left;
			if(temp !=null)
				suc = temp;
			
			temp = node.left;
			while(temp!=null && temp.right!=null)
				temp = temp.right;
			if(temp!=null)	
				pre = temp;
		}
		else if(key<node.data)
		{
			suc = node;
			getSucPre(node.left,key);
		}
		else
		{
			pre = node;
			getSucPre(node.right,key);
		}
	}
}
