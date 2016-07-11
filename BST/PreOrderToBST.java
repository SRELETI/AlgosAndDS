import java.util.Stack;


public class PreOrderToBST {

	private TreePrint head;
	
	public PreOrderToBST()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int count = 0;
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
				if(temp == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void convertToBST(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		Wrapper s = new Wrapper();
		head = convertT(arr,s,start,end);
		printInorder(head);
	}
	
	private void printInorder(TreePrint node)
	{
		if(node!=null)
		{
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	
	private TreePrint convertT(int[] arr, Wrapper s, int start, int end )
	{
		if(start>end || start <0)
			return null;
		TreePrint root = new TreePrint(arr[s.count]);
		s.count = s.count+1;
		if(start == end)
			return root;
		int index = search(arr,start,end,s.count,root.data);
		
		root.left = convertT(arr,s,start+1,index-1);
		root.right = convertT(arr,s,index,end);
		return root;
	}
	
	private int search(int[] arr, int start, int end, int index, int value)
	{
		for(int i=index;i<=end;i++)
		{
			if(arr[i]>value)
				return i;
		}
		return -1;
	
	}
	
	public void preOrder(int[] arr)
	{
		Wrapper preIndex = new Wrapper();
		int size = arr.length;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		TreePrint head = preorderConstruct(arr,preIndex,size,min,max,arr[0]);
		printInorder(head);
	}
	
	private TreePrint preorderConstruct(int[] arr, Wrapper pre, int size, int min, int max, int key)
	{
		if(pre.count>=size)
			return null;
		TreePrint root = null;
		if(key > min && key<max)
		{
			root = new TreePrint(arr[pre.count]);
			pre.count = pre.count+1;
			if(pre.count <size)
			{
				root.left = preorderConstruct(arr,pre,size,min,key,arr[pre.count]);
				root.right = preorderConstruct(arr,pre,size,key,max,arr[pre.count]);
			}
		}
		return root;
	}
	
	public void consPre(int[] arr)
	{
		head = preorderCon(arr);
		printInorder(head);
	}
	
	private TreePrint preorderCon(int[] arr)
	{
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		TreePrint root = new TreePrint(arr[0]);
		s.push(root);
		
		TreePrint temp;
		for(int i=1;i<arr.length;i++)
		{
			temp = null;
			while(!s.isEmpty() && arr[i]>s.peek().data)
				temp = s.pop();
			
			if(temp!=null)
			{
				temp.right = new TreePrint(arr[i]);
				s.push(temp.right);
			}
			else
			{
				s.peek().left = new TreePrint(arr[i]);
				s.push(s.peek().left);
			}
		}
		return root;
	}
}
