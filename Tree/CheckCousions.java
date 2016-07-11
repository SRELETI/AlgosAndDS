
public class CheckCousions {
	
	private TreePrint first;
	
	public CheckCousions()
	{
		first = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(first == null)
		{
			first = newNode;
			return;
		}
		else
		{
			TreePrint parent;
			TreePrint cur = first;
			while(true)
			{
				parent=cur;
				if(value<cur.data)
				{
					cur = cur.left;
					if(cur == null )
					{
						parent.left=newNode;
						return;
					}
				}
				else
				{	
					cur = cur.right;
					if(cur == null)
					{
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean checkCousion(int value, int value2)
	{
		if(first == null)
			return false;
		int level_value = getLevel(value);
		int level_value2 = getLevel(value2);
		
		if(level_value == level_value2)
		{
			TreePrint parent = getParent(value);
			TreePrint parent2 = getParent(value2);
			
			if(parent != parent2)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	private TreePrint getParent(int value)
	{
		return getparent(first,value);
	}
	
	private TreePrint getparent(TreePrint node , int value)
	{
		if(node == null)
			return null;
		if(node.left !=null && node.right!=null)
		{	
			if(node.left.data == value || node.right.data == value)
				return node;
		}
		TreePrint result = getparent(node.left,value);
		if(result !=null)
			return result;
		else
		{
			result= getparent(node.right,value);
			return result;
		}
	}
	private int getLevel(int value)
	{
		return getlevel(first,value,0);
	}
	
	private int getlevel(TreePrint node, int value, int level)
	{
		if(node == null)
			return 0;
		if(node.data == value)
		{
			return level;
		}
		return getlevel(node.left,value,level+1)+getlevel(node.right,value,level+1);
	}
	
}
