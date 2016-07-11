
public class BSTBinary {

	public TreePrint head;
	private TreePrint prev;
	public BSTBinary()
	{
		head= null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp =head;
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
				if(temp ==null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public TreePrint delete(TreePrint node, int key)
	{
		if(node == null)
			return node;
		if(key<node.data)
		{
			node.left = delete(node.left,key);
		}
		else if(key>node.data)
		{
			node.right = delete(node.right,key);
		}
		else
		{
			if(node.left == null)
			{
				node = node.right;
			}
			else if(node.right == null)
			{
				node = node.left;
			}
			else
			{
				TreePrint temp = getSuc(node);
				node.data = temp.data;
				node.right = delete(node.right,temp.data);
			}
		}
		return node;
	}

	private TreePrint getSuc(TreePrint node)
	{
		if(node == null)
			return null;
		TreePrint temp = node.right;
		while(temp.left !=null)
			temp = temp.left;
		return temp;
	}
	
	public void isRecBST()
	{
		System.out.println(isBST(head));
	}
	
	private boolean isBST(TreePrint node)
	{
		if(node == null)
			return true;
		if(node.left!=null && getMax(node.left)>node.data)
			return false;
		if(node.right!=null && getMin(node.right)<node.data)
			return false;
		if(isBST(node.left)==false || isBST(node.right) ==false)
			return false;
		else
			return true;
	}
	
	private int getMax(TreePrint node)
	{
		while(node.right!=null)
			node = node.right;
		return node.data;
	}
	
	private int getMin(TreePrint node)
	{
		while(node.left!=null)
			node = node.left;
		return node.data;
	}
	
	public boolean isBST()
	{
		boolean result = isBinary(head,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println(result);
		return result;
	}
	
	private boolean isBinary(TreePrint node, int min, int max)
	{
		if(node == null)
			return true;
		if(node.data < min || node.data> max)
			return false;
		return isBinary(node.left,min,node.data-1) && isBinary(node.right,node.data+1,max); 
	}
	
	public void isBSTArr()
	{
		boolean result = isArr(head);
		System.out.println(result);
	}
	
	private int sizeT(TreePrint node)
	{
		if(node == null)
			return 0;
		return sizeT(node.left)+1+sizeT(node.right);
	}
	
	private class Wrapper
	{
		int count=0;
	}
	private boolean isArr(TreePrint node)
	{
		if(node == null)
			return true;
		int size = sizeT(node);
		int[] arr = new int [size];
		Wrapper index = new Wrapper();
		inorder(node,arr,index);
		
		return checkSorted(arr);
	}
	
	private void inorder(TreePrint node, int[] arr, Wrapper s)
	{
		if(node!=null)
		{
			inorder(node.left,arr,s);
			arr[s.count]=node.data;
			s.count++;
			inorder(node.right,arr,s);
		}
	}
	
	private boolean checkSorted(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i+1]<arr[i])
				return false;
		}
		return true;
	}
	
	public void isBSTTemp()
	{
		System.out.println(isBSTTree(head));
	}
	private boolean isBSTTree(TreePrint node)
	{
		if(node == null)
			return true;
		
		if(isBSTTree(node.left)==false)
			return false;
		if(prev!=null && prev.data>=node.data)
			return false;
		prev = node;
		return isBSTTree(node.right);
		
	}
}

