
public class SortedBSTArray {

	private TreePrint head;
	
	public SortedBSTArray()
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
	
	public void constree(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		TreePrint result = cons(arr,start,end);
		print(result);
	}
	
	private void print(TreePrint node)
	{
		if(node != null)
		{
			print(node.left);
			System.out.print(node.data+" ");
			print(node.right);
		}
	}
	
	public TreePrint cons(int[] arr, int start, int end)
	{
		if(start>end)
			return null;
		int mid = (start+end)/2;
		
		TreePrint root = new TreePrint(arr[mid]);
		
		root.left = cons(arr,start,mid-1);
		root.right = cons(arr,mid+1,end);
		return root;
	}
	
	public static void main(String args[])
	{
		SortedBSTArray s = new SortedBSTArray();
		int[] arr = {1,2,3,4};
		
		s.constree(arr);
	}
}
