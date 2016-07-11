
public class BST {

	public TreePrint head;
	
	public BST()
	{
		head = null;
	}
	
	public void largeBST(TreePrint node)
	{
		int size = checkBST(node);
		System.out.println(size);
	}
	
	private int checkBST(TreePrint node)
	{
		if(isBST(node))
			return size(node);
		
		return Math.max(checkBST(node.left), checkBST(node.right));
	}
	
	private int size(TreePrint node)
	{
		if(node == null)
			return 0;
		return size(node.left)+1+size(node.right);
	}
	
	private boolean isBST(TreePrint node)
	{
		boolean result = isBSTCheck(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
		return result;
	}
	
	private boolean isBSTCheck(TreePrint node, int min, int max)
	{
		if(node == null)
			return true;
		if(node.data<min || node.data> max)
			return false;
		
		return isBSTCheck(node.left,min,node.data-1) && isBSTCheck(node.right,node.data+1,max);
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
		TreePrint temp = head;
		while(temp!=null)
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
	
	public TreePrint find(TreePrint node, int key)
	{
		if(node ==null)
			return null;
		while(node!=null)
		{
			if(key<node.data)
			{
				node = node.left;
			}
			else if(key > node.data)
			{
				node = node.right;
			}
			else
				break;
		}
		return node;
	}
	private class Wrapper
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int size = 0;
		boolean isBST=false;
	}
	
	public void largestBST(TreePrint node)
	{
		Wrapper total = new Wrapper();
		findSize(node,total);
	//	System.out.println(result);
		System.out.println(total.size);
	//	System.out.print(total.isBST);
	}
	
	private int findSize(TreePrint node, Wrapper total)
	{
		if(node == null)
		{
			total.isBST = true;
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		boolean left_flag = false;
		boolean right_flag = false;
		
		int ls, rs;
		
		ls = findSize(node.left,total);
		if(total.isBST==true && node.data>total.max)
			left_flag = true;
		
		min = total.min;
		
		total.min= Integer.MAX_VALUE;
		
		rs = findSize(node.right,total);
		
		if(total.isBST == true && node.data < total.min)
			right_flag = true;
		
		if(min<total.min)
			total.min=min;
		if(node.data>total.max)
			total.max = node.data;
		if(node.data<total.min)
			total.min = node.data;
		
		if(left_flag && right_flag)
		{
			if(ls+rs+1 > total.size)
				total.size = ls+rs+1;
			return ls+rs+1;
		}
		else
		{
			total.isBST = false;
			return 0;
		}
	
	}
	public TreePrint delete(TreePrint node, int key)
	{
		if(node == null)
			return null;
		if(key<node.data)
			node.left = delete(node.left,key);
		else if(key>node.data)
			node.right = delete(node.right,key);
		else
		{
			if(node.left==null)
			{
				TreePrint temp = node.right;
				return temp;
			}
			else if(node.right == null)
			{
				TreePrint temp = node.left;
				return temp;
			}
			else
			{
				TreePrint temp = getSuccessor(node.right);
				
				node.data = temp.data;
				
				node.right = delete(node.right,temp.data);
			}
		}
		return node;
	}
	
	private TreePrint getSuccessor(TreePrint node)
	{
		if(node == null)
			return null;
		while(node.left!=null)
			node = node.left;
		return node;
	}
	
	public void inorder(TreePrint node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	public static void main(String args[])
	{
		BST b = new BST();
		
	/*	b.insert(50);
		b.insert(30);
		b.insert(70);
		b.insert(20);
		b.insert(40);
		b.insert(60);
		b.insert(80);
		
		b.inorder(b.head);
		
		System.out.println();
		TreePrint result = b.find(b.head, 80);
		System.out.println(result == null ? null : result.data);
		
		result = b.delete(b.head, 20);
		System.out.println(result == null ? null : result.data);
		
		b.inorder(b.head);
		
		result = b.delete(b.head, 50);
		System.out.println();
		b.inorder(b.head);
		
		result = b.delete(b.head, 30);
		System.out.println();
		b.inorder(b.head);
		*/
		
	/*	b.head = new TreePrint(50);
		b.head.left = new TreePrint(30);
		b.head.right = new TreePrint(60);
		b.head.left.left = new TreePrint(5);
		b.head.left.right = new TreePrint(20);
		b.head.right.left = new TreePrint(45);
		b.head.right.right = new TreePrint(70);
	//	b.head.right.left.left = new TreePrint(45);
		b.head.right.right.left = new TreePrint(65);
		b.head.right.right.right = new TreePrint(80);
		*/
	//	b.inorder(b.head);
		b.head = new TreePrint(5);
		b.head.left = new TreePrint(2);
		b.head.right = new TreePrint(4);
		b.head.left.left = new TreePrint(1);
		b.head.left.right = new TreePrint(3);
		
		b.largestBST(b.head);
		b.largeBST(b.head);
		
		int[] arr = {20,22,25,26};
		
		System.out.println(b.checkSingle(arr));
		System.out.println(b.checkSingle2(arr));
		System.out.println(b.checkSingle3(arr));
	}
	
	public boolean checkSingle3(int[] arr)
	{
		int max,min;
		
		if(arr[arr.length-1]>arr[arr.length-2])
		{
			max =arr[arr.length-1];
			min = arr[arr.length-2];
		}
		else
		{
			max = arr[arr.length-2];
			min = arr[arr.length-1];
		}
		
		for(int i= arr.length-3;i>=0;i--)
		{
			if(arr[i]<min)
				min = arr[i];
			else if(arr[i]>max)
				max = arr[i];
			else 
				return false;
		}
		return true;
	}
	public boolean checkSingle2(int[] arr)
	{
		int diff,last_diff;
		for(int i=0;i<arr.length-2;i++)
		{
			diff = arr[i]-arr[i+1];
			last_diff = arr[i]-arr[arr.length-1];
			if(diff*last_diff<0)
				return false;
		}
		return true;
	}
	public boolean checkSingle(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			boolean result = false;
			int count =0;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					if(count!=0 && result == false)
						return false;
					result= true;
				}
				if(arr[i]<arr[j])
				{
					if(result ==true)
						return false;
				}
				count++;
			}
		}
		return true;
		
	}
}
