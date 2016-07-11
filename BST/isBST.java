
public class isBST {

	
	public TreePrint head;
	
	public isBST()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode= new TreePrint(value);
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
	
	public TreePrint delete(TreePrint node, int value)
	{
		if(node == null)
			return node;
		if(value<node.data)
			node.left = delete(node.left,value);
		else if(value>node.data)
			node.right = delete(node.right,value);
		else
		{
			if(node.left == null)
			{
				node = node.right;
			}
			else if(node.right ==null)
			{
				node = node.left;
			}
			else
			{
				TreePrint temp = getSuc(node.right);
				node.data = temp.data;
				node.right = delete(node.right,temp.data);
			}
		}
		return node;
			
	}
	
	private TreePrint getSuc(TreePrint node)
	{
		while(node.left!=null)
			node = node.left;
		return node;
	}
	
	private class Wrapper
	{
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int size = 0;
		boolean isBST = false;
	}
	
	public void largest()
	{
		Wrapper s = new Wrapper();
		int result = largestBST(head,s);
		System.out.println(s.size);
	}
	
	
	private int largestBST(TreePrint node, Wrapper s)
	{
		if(node == null)
		{
			s.isBST = true;
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		boolean left = false;
		boolean right = false;
		
		int ls, rs;
		
		s.max = Integer.MIN_VALUE;
		ls  = largestBST(node.left,s);
		if(s.isBST==true && node.data>s.max)
			left = true;
		
		min = s.min;
		
		s.min = Integer.MAX_VALUE;
		
		rs = largestBST(node.right,s);
		
		if(s.isBST==true && node.data<s.min)
			right = true;
		
		if(min<s.min)
			s.min= min;
		if(node.data<s.min)
			s.min = node.data;
		if(node.data>s.max)
			s.max = node.data;
		
		if(left == true && right ==true)
		{
			if(ls+rs+1>s.size)
				s.size = ls+rs+1;
			return ls+rs+1;
		}
		else
		{
			s.isBST = true;
			return 0;
		}
	}
	
	private class Wrapper2
	{
		int sum=0;
		int k=0;
	}
	public boolean isSame(int[] arr, int[] arr2)
	{
		int size =arr.length;
		Wrapper2 s = new Wrapper2();
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return checkSame(arr,arr2,size,0,0,min,max);
	}
	
	private boolean checkSame(int[] arr, int[] arr2, int size, int i1, int i2, int min, int max)
	{
		int i,j;
		for(i=i1;i<size;i++)
		{
			if(arr[i]>min && arr[i]<max)
				break;
		}
		for(j=i2;j<size;j++)
		{
			if(arr2[j]>min && arr2[j]<max)
				break;
		}
		
		if(i==size && j==size)
			return true;
		
		if(i == size || j == size || arr[i]!=arr2[j])
			return false;
	
		return checkSame(arr,arr2,size,i1+1,i2+1,min,arr[i]) && checkSame(arr,arr2,size,i1+1,i2+1,arr[i],max);
	}
	
	public void addGreater()
	{
		Wrapper2 s = new Wrapper2();
		addLarge(head,s);
		inorder(head);
	}
	
	private void inorder(TreePrint node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	private void addLarge(TreePrint node,Wrapper2 s)
	{
		if(node != null)
		{
			addLarge(node.right,s);
			s.sum = s.sum+node.data;
			node.data = s.sum;
			addLarge(node.left,s);
		}
	}
	
	
}
