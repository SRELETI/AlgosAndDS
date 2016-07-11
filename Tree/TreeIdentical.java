
public class TreeIdentical {
	private TreeInorder root1;
	private TreeInorder root2;
	
	public TreeIdentical()
	{
		root1 = null;
		root2 = null;
	}
	
	public void insert(int value)
	{
		TreeInorder newNode = new TreeInorder(value);
		if(root1 == null)
		{
			root1 = newNode;
		}
		else
		{
			TreeInorder parent = root1;
			TreeInorder current = root1;
			while(current!=null)
			{
				parent=current;
				if(value<current.key)
				{
					current=current.lchild;
					if(current==null)
					{
						parent.lchild=newNode;
						return;
					}
				}
				else
				{
					current=current.rchild;
					if(current==null)
					{
						parent.rchild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void insert2(int value)
	{
		TreeInorder newNode = new TreeInorder(value);
		if(root2 == null)
		{
			root2 = newNode;
		}
		else
		{
			TreeInorder parent = root2;
			TreeInorder current = root2;
			while(current!=null)
			{
				parent=current;
				if(value<current.key)
				{
					current=current.lchild;
					if(current==null)
					{
						parent.lchild=newNode;
						return;
					}
				}
				else
				{
					current=current.rchild;
					if(current==null)
					{
						parent.rchild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean isIdentical(TreeInorder temp1, TreeInorder temp2)
	{
		if(temp1==null && temp2==null)
			return true;
		else if(temp1!=null && temp2!=null)
		{
			boolean first = (temp1.key==temp2.key);
			boolean second = isIdentical(temp1.lchild, temp2.lchild);
			boolean third = isIdentical(temp1.rchild, temp2.rchild);
			return first && second && third ;
		}
		return false;
	}
	
	public boolean identicalTrees()
	{
		return isIdentical(root1, root2);
	}
	
}
