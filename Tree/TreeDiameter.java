
public class TreeDiameter {
	private TreePrint head;
	
	public TreeDiameter()
	{
		head=null;
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
			TreePrint cur=head;
			while(true)
			{
				parent = cur;
				if(value<cur.data)
				{
					cur=cur.left;
					if(cur==null)
					{
						parent.left = newNode;
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
	
	private class Wrapper
	{
		int height = 0;
	}
	public void diameter()
	{
		Wrapper h = new Wrapper();
		int result = diameterCal(head,h);
		System.out.println(result);
	}
	
	private int diameterCal(TreePrint temp, Wrapper h)
	{
		if(temp==null)
			return 0;
		Wrapper lh = new Wrapper();
		Wrapper rh = new Wrapper();
		
		int ld = diameterCal(temp.left, lh);
		int rd = diameterCal(temp.right, rh);
		
		h.height=Math.max(lh.height,rh.height)+1;
		return Math.max(lh.height+rh.height+1, Math.max(ld, rd));
	}
	
	
	public void diameter2()
	{
		int result = diameterCal2(head);
		System.out.println(result);
	}
	
	private int diameterCal2(TreePrint temp)
	{
		if(temp==null)
			return 0;
		int lh=0, rh=0;
		int ld=0, rd =0;
		lh=height(temp.left);
		rh=height(temp.right);
		
		ld=diameterCal2(temp.left);
		rd = diameterCal2(temp.right);
		
		return Math.max(lh+rh+1, Math.max(ld, rd));
	}
	
	private int height(TreePrint temp)
	{
		if(temp == null)
			return 0;
		return (1+Math.max(height(temp.left), height(temp.right)));
	}
	
	
	public void heightBalance()
	{
		boolean result = height2(head);
		System.out.println(result);
	}
	
	private boolean height2(TreePrint temp)
	{
		if(temp==null)
			return true;
		int lh=height(temp.left);
		int rh = height(temp.right);
		int diff = Math.abs(lh-rh);
		return (diff <=1 && height2(temp.left)==true && height2(temp.right) == true);
	}
	
	
	public void optHeightBalanc()
	{
		Wrapper h = new Wrapper();
		boolean result = height3(head,h);
		System.out.println(result);
	}
	
	private boolean height3(TreePrint temp, Wrapper h)
	{
		if(temp==null)
		{
			return true;
		}
		
		Wrapper lh = new Wrapper();
		Wrapper rh = new Wrapper();
		
		boolean ld = height3(temp.left, lh);
		boolean rd = height3(temp.right, rh);
		
		h.height= Math.max(lh.height,rh.height) +1;
		
		int diff = Math.abs(lh.height-rh.height);
		return (diff <=1 && ld == true && rd ==true );
	}
}
