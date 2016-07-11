
public class MorrisAlgo {
	private TreePrint head;
	
	public MorrisAlgo()
	{
		head=null;
	}
	
/*	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head==null)
		{
			head= newNode;
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
					cur=cur.right;
					if(cur==null)
					{
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}
	*/
	public void morris()
	{
		TreePrint cur = head;
		TreePrint parent;
		while(cur!=null)
		{
			if(cur.left==null)
			{
				System.out.print(cur.data+" ");
				cur=cur.right;
			}
			else
			{
				parent=cur.left;
				while(parent.left!=null && parent.right!=null)
					parent=parent.right;
				if(parent.right==null)
				{
					parent.right=cur;
					cur=cur.left;
				}
				else
				{
					parent.right=null;
					System.out.print(cur.data+" ");
					cur = cur.right;
				}
			}
		}
	}
	
	
	public void leadSum(int sum)
	{
		boolean result = findSum(head,sum);
		System.out.println(result+" ");
	}
	
	private boolean findSum(TreePrint temp , int sum)
	{
		if(temp==null)
		{
			return (sum==0);
		}
		int subsum = sum -temp.data;
		boolean find = false;
		
		if(subsum ==0 && temp.left == null && temp.right == null)
			return true;
		if(temp.left!=null)
		{
			find=find || findSum(temp.left,subsum);
		}
		if(temp.right!=null)
		{
			find = find || findSum(temp.right, subsum);
		}
		return find;
	}
	private class Wrapper
	{
		int preIndex=0;
	}
	
	public void inorder(TreePrint temp)
	{
		if(temp == null)
			return;
		inorder(temp.left);
		System.out.print(temp.data+" ");
		inorder(temp.right);
	}
	
/*	public void buildTreeAbs(char[] in, char[] pre, int start, int end)
	{
		Wrapper h = new Wrapper();
		TreePrint result = buildTree(in,pre,start,end,h);
		inorder(result);
	}
	*/
/*	private TreePrint buildTree(char[] in, char[] pre, int start, int end, Wrapper h)
	{
		if(start>end)
			return null;
		TreePrint newNode = new TreePrint(pre[h.preIndex++]);
		if(start==end)
			return newNode;
		int inIndex= search(in,start,end,newNode.data);
		if(inIndex==-1)
			return null;
		newNode.left = buildTree(in,pre,start,inIndex-1,h);
		newNode.right = buildTree(in,pre,inIndex+1, end,h);
		return newNode;
	}
	
	private int search(char[] in, int start, int end, char data)
	{
		for(int i=start;i<=end;i++)
		{
			if(in[i]==data)
				return i;
		}
		return -1;
	}*/
}

