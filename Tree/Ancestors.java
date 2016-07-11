
public class Ancestors {

	public TreePrint head;
	
	public Ancestors()
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
		else
		{
			TreePrint parent;
			TreePrint cur = head;
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
	
	public void anscestors(int value)
	{
		System.out.println(head.data);
		ans(head,value);
	}
		
	private boolean ans(TreePrint temp, int value)
	{
		if(temp == null)
			return false;
		if(temp.data == value)
			return true;
		if(ans(temp.left,value)==true || ans(temp.right,value)==true)
		{
			System.out.print(temp.data+" ");
			return true;
		}
		else
			return false;
	}
	
	
	public boolean sumTree()
	{
		int result = sumTreeCheck(head);
		if(result==0 || result==head.data)
			return true;
		else
			return false;
	}
	
	private int sumTreeCheck(TreePrint temp)
	{
		if(temp==null)
			return 0;
		if(temp.left==null && temp.right==null)
			return temp.data;
	//	return (temp.data==temp.left.data+temp.right.data && sumTreeCheck(temp.left)==true && sumTreeCheck(temp.right)== true);
		int left = sumTreeCheck(temp.left);
		int right = sumTreeCheck(temp.right);
		return left+right;
	}
	
	public static void main(String args[])
	{
		TreePrint head = new TreePrint(26);
		head.left = new TreePrint(10);
		head.left.left = new TreePrint(4);
		head.left.right = new TreePrint(6);
	    head.right = new TreePrint(3);
		head.right.right = new TreePrint(5);
		Ancestors s = new Ancestors();
		System.out.println(s.sumTree());
	}
}
