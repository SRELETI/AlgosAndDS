
public class LCABST {

	public TreePrint head;
	
	public LCABST()
	{
		head =null;
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
			if(node.left==null)
			{
				node = node.right;
			}
			else if(node.right == null)
				node = node.left;
			else
			{
				TreePrint temp = getSuc(node.right);
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
		}
		return node;
	}
	
	private TreePrint getSuc(TreePrint node)
	{
		TreePrint temp = node;
		while(temp.left!=null)
			temp = temp.left;
		return temp;
	}
	
	public void findLCA(int n1, int n2)
	{
		TreePrint result = lca(head,n1,n2);
		TreePrint result2 = lca_iterative(head,n1,n2);
		System.out.println(result ==result2 ? true : false);
		System.out.println(result.data + " "+ result2.data);
	}
	
	private TreePrint lca(TreePrint node, int n1, int n2)
	{
		if(node == null)
			return null;
		if(n1>node.data && n2>node.data)
			return lca(node.right,n1,n2);
		if(n1<node.data && n2<node.data)
			return lca(node.left,n1,n2);
		else
			return node;
	}
	
	private TreePrint lca_iterative(TreePrint node, int n1, int n2)
	{
		if(node == null)
			return null;
		while(node!=null)
		{
			if(n1<node.data && n2<node.data)
				node = node.left;
			else if( n2>node.data && n1>node.data)
				node = node.right;
			else
				break;
		}
		return node;
	}
	
	
	public void print_sorted(int[] arr, int start,int end)
	{
		if(start>end)
			return;
		print_sorted(arr,start*2+1,end);
		System.out.print(arr[start]+" ");
		print_sorted(arr,start*2+2,end);
	}
	
}
