
public class SubTreeCheck {

	private TreePrint main;
	private TreePrint sub;
	
	public SubTreeCheck()
	{
		main = null;
		sub = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(main == null)
		{
			main = newNode;
		}
		else
		{
			TreePrint parent;
			TreePrint temp = main;
			while(true)
			{
				parent  = temp;
				if(value<temp.data)
				{
					temp = temp.left;
					if(temp==null)
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
	}
	
	public void insert_sub(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(sub == null)
		{
			sub = newNode;
		}
		else
		{
			TreePrint parent;
			TreePrint temp = sub;
			while(true)
			{
				parent  = temp;
				if(value<temp.data)
				{
					temp = temp.left;
					if(temp==null)
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
	}
	
	public void checkSubTree()
	{
		boolean result = checkTree(main, sub);
		System.out.println(result);
	}
	
	private boolean checkTree(TreePrint head, TreePrint subhead)
	{
		if(subhead == null)
			return true;
		if(head == null)
			return false;
		
		if(isIdentical(head,subhead)==true)
			return true;
		else
			return (checkTree(head.left,subhead)==true || checkTree(head.right,subhead)==true);
	}
	
	private boolean isIdentical(TreePrint head, TreePrint subhead)
	{
		if(head == null && subhead == null)
			return true;
		if(head ==null || subhead == null)
			return false;
		return (head.data == subhead.data && isIdentical(head.left,subhead.left)==true && isIdentical(head.right,subhead.right)==true);
	}
}
