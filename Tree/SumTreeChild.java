
public class SumTreeChild {
	
	private TreePrint head;
	private TreePrint subTree;
	
	public SumTreeChild()
	{
		head = null;
		subTree = null;
	}
	
	public void insert(int value)
	{
		TreePrint temp = new TreePrint(value);
		if(head == null)
		{
			head = temp;
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
					if(cur == null)
					{
						parent.left = temp;
						return;
					}
				}
				else
				{
					cur =cur.right;
					if(cur == null)
					{
						parent.right = temp;
						return;
					}
				}
			}
		}
	}
	
	public void sumTree()
	{
		boolean result = sumTreeCheck(head);
		System.out.println(result);
	}
	
	private boolean sumTreeCheck(TreePrint temp)
	{
		if(temp == null || (temp.left==null && temp.right == null))
			return true;
		int left = sum(temp.left);
		int right = sum(temp.right);
		
		return (temp.data==left+right && sumTreeCheck(temp.left)==true && sumTreeCheck(temp.right)==true);
	}
	
	private int sum(TreePrint temp)
	{
		if(temp==null)
			return 0;
		return sum(temp.left)+temp.data+sum(temp.right);
	}
	
	private class Wrapper
	{
		int sum=0;
	}
	
	public void sumFind()
	{
		Wrapper h = new Wrapper();
		boolean result = sumChildFind(head,h);
		System.out.println(result);
	}
	
	private boolean sumChildFind(TreePrint temp, Wrapper h)
	{
		if(temp==null)
			return true;
		if(temp.left==null && temp.right == null)
		{
			h.sum=temp.data;
			return true;
		}
		Wrapper lh = new Wrapper();
		Wrapper rh = new Wrapper();
		
		boolean lresult = sumChildFind(temp.left,lh);
		boolean rresult = sumChildFind(temp.right, rh);
		
		h.sum = lh.sum+rh.sum+temp.data;
		
		return (temp.data==lh.sum+rh.sum && lresult== true && rresult == true);
		
	}
	
	public void isSubTree()
	{
		boolean result = findIsSubTree(head,subTree);
		System.out.println(result);
	}
	
	private boolean findIsSubTree(TreePrint main, TreePrint sub)
	{
		if(sub==null)
			return true;
		if(main==null)
			return false;
		if(identical(main,sub)==true)
			return true;
		return findIsSubTree(main.left,sub) || findIsSubTree(main.right,sub);
	}
	
	private boolean identical(TreePrint main, TreePrint sub)
	{
		if(main==null && sub==null)
			return true;
		if(main==null || sub==null)
			return false;
		return main.data==sub.data && identical(main.left,sub.left)==true && identical(main.right,sub.right)==true;
	}
	public static void main(String args[])
	{
		SumTreeChild s = new SumTreeChild();
		s.head = new TreePrint(26);
		s.head.left = new TreePrint(10);
		s.head.right = new TreePrint(3);
		s.head.left.left = new TreePrint(4);
		s.head.left.left.right = new TreePrint(30);
		s.head.left.right = new TreePrint(6);
		s.head.right.right = new TreePrint(3);
		s.subTree = new TreePrint(10);
		s.subTree.left = new TreePrint(4);
		s.subTree.right = new TreePrint(6);
		s.subTree.left.right = new TreePrint(30);
		s.isSubTree();
	}
}
