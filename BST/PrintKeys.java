
public class PrintKeys {

	public TreePrint head;
	
	public PrintKeys()
	{
		head  = null;
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
			else if(node.right == null)
				node = node.left;
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
	
	public void keysPrint(int k1, int k2)
	{
		printKeys(head,k1,k2);
	}
	
	private void printKeys(TreePrint node, int k1, int k2)
	{
		if(node == null)
			return;
		if(node.data>k1)
			printKeys(node.left,k1,k2);
		if(node.data>=k1 && node.data <=k2)
			System.out.print(node.data+ " ");
		if(node.data<k2)
			printKeys(node.right,k1,k2);
	}
	
	public void construct(int[] arr)
	{
		int start =0;
		int end = arr.length-1;
		head = build(arr,start,end);
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
	private TreePrint build(int[] arr, int start, int end)
	{
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreePrint root = new TreePrint(arr[mid]);
		if(start == end)
			return root;
		root.left = build(arr,start,mid-1);
		root.right = build(arr,mid+1,end);
		return root;
	}
}
