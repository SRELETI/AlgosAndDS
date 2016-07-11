
public class LCABT {

	public TreePrint head;
	
	public LCABT()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
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
					if(cur == null)
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
	
	public void printLCA(int value1, int value2)
	{
		TreePrint node = traverse(head,value1,value2);
		System.out.println(node==null ? null : node.data);
	}
	private TreePrint traverse(TreePrint node, int value1, int value2)
	{
		if(node == null)
			return null;
		
		if(node.data == value1 || node.data == value2)
			return node;
		TreePrint left = traverse(node.left,value1,value2);
		TreePrint right = traverse(node.right,value1,value2);
		
		if(left != null && right != null)
			return node;
		return left!=null ? left : right;
	}
	private class Wrapper
	{
		boolean v1= false;
		boolean v2 = false;
	}
	public void printLCA_allcases(int value1, int value2)
	{
		Wrapper h = new Wrapper();
		TreePrint node = traverse_allCases(head,value1,value2,h);
	//	System.out.println(node==null ? null : node.data);
		if(h.v1 == true && h.v2 ==true || h.v1==true && find(node,value2)==true || h.v2==true && find(node,value1)==true)
		{
			System.out.println(node.data+" ");
		}
		else
			System.out.println("no node");
	}
	
	private boolean find(TreePrint node, int val)
	{
		if(node == null)
		{
			return false;
		}
		if(node.data == val || find(node.left,val)==true || find(node.right,val) == true)
			return true;
		return false;
	}
	private TreePrint traverse_allCases(TreePrint node, int value1, int value2,Wrapper h)
	{
		if(node == null)
			return null;
		
		if(node.data == value1 )
		{
			h.v1 = true;
			return node;
		}
		if( node.data == value2)
		{
			h.v2=true;
			return node;
		}
		TreePrint left = traverse_allCases(node.left,value1,value2,h);
		TreePrint right = traverse_allCases(node.right,value1,value2,h);
		
		if(left != null && right != null)
			return node;
		return left!=null ? left : right;
	}
}
