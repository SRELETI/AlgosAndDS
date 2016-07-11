
public class Size {
	private TreePrint head;
	
	public Size()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			TreePrint parent;
			TreePrint cur = head;
			while(true)
			{
				parent = cur;
				if(value<cur.data)
				{
					cur = cur.left;
					if(cur==null)
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
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void sizeCal()
	{
		int result = sizeCalc(head);
		System.out.println("The size is "+result);
	}
	
	private int sizeCalc(TreePrint temp)
	{
		if(temp==null)
			return 0;
		int lsize = sizeCalc(temp.left);
		int rsize = sizeCalc(temp.right);
		return (lsize+rsize+1);
	}
}
