
public class MergeBST {

	public TreePrint head1;
	public TreePrint head2;
	private TreePrint resultTree;
	public MergeBST()
	{
		head1 = null;
		head2 = null;
		resultTree = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head1 == null)
		{
			head1 = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head1;
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
	
	public void insert2(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head2 == null)
		{
			head2 = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head2;
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
	
	public void printInorder(TreePrint node)
	{
		if(node!=null)
		{
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	
	public void mergeTree(TreePrint node1, TreePrint node2)
	{
		int size1 = size(node1);
		int size2 = size(node2);
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		inorder(node1,arr1);
		inorder(node2,arr2);
		int[] result = new int[size1+size2];
		mergeArr(result,arr1,arr2);
		resultTree = constructTree(result,0,result.length-1);
		printInorder(resultTree);
	}
	
	private TreePrint constructTree(int[] arr, int start, int end)
	{
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreePrint root = new TreePrint(arr[mid]);
		root.left = constructTree(arr,start,mid-1);
		root.right = constructTree(arr,mid+1,end);
		return root;
	}
	
	private void mergeArr(int[] res, int[] arr1, int[] arr2)
	{
		int i=0,j=0,k=0;
		
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				res[k]=arr1[i];
				i++;
			}
			else if(arr2[j]<arr1[i])
			{
				res[k] = arr2[j];
				j++;
			}
			else
			{
				res[k]=arr1[i];
				i++;
				j++;
			}
			k++;
		}
		
		while(i<arr1.length)
		{
			res[k]=arr1[i];
			i++;
			k++;
		}
		while(j<arr2.length)
		{
			res[k]=arr2[j];
			j++;
			k++;
		}
	}
	private void inorder(TreePrint node, int[] arr)
	{
		if(node == null)
			return;
		int index=0;
		while(node!=null)
		{
			if(node.left==null)
			{
				arr[index++]=node.data;
				node = node.right;
			}
			else
			{
				TreePrint temp = node.left;
				while(temp.right!=null && temp.right!=node)
					temp = temp.right;
				if(temp.right==null)
				{
					temp.right = node;
					node = node.left;
				}
				else
				{
					temp.right= null;
					arr[index++]=node.data;
					node = node.right;
				}
			}
		}
	}
	private int size(TreePrint node)
	{
		if(node == null)
			return 0;
		
		return size(node.left)+size(node.right)+1;
	}
	public static void main(String args[])
	{
		MergeBST m = new MergeBST();
		
		m.insert(100);
		m.insert(50);
		m.insert(300);
		m.insert(20);
		m.insert(70);
		
		m.insert2(80);
		m.insert2(40);
		m.insert2(120);
		
	/*	m.printInorder(m.head1);
		System.out.println();
		m.printInorder(m.head2);
	*/	
		m.mergeTree(m.head1, m.head2);
	}

}
