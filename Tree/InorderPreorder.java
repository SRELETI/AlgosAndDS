
public class InorderPreorder {

	private TreePrint head;
	private static int preIndex = 0;
	public InorderPreorder()
	{
		head = null;
	}
	
	public void inorder(TreePrint node)
	{
		TreePrint temp;
		while(node!=null)
		{
			if(node.left==null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				temp = node.left;
				while(temp.left!=null && temp.right!=node)
					temp = temp.right;
				if(temp.right==null)
				{
					temp.right = node;
					node = node.left;
				}
				else
				{
					temp.right = null;
					System.out.print(node.data+" ");
					node = node.right;
				}
			}
		}
	}
	
	public void construct(int[] inorder, int[] preorder)
	{
		int start=0;
		int end=inorder.length-1;
		
		TreePrint result = cons(inorder,preorder,start,end);
		inorder(result);
	}
	
	public TreePrint cons(int[] inorder, int[] preorder, int start, int end)
	{
		if(start>end)
			return null;
		
		TreePrint newNode = new TreePrint(preorder[preIndex++]);
		if(start==end)
			return newNode;
		int inIndex = search(inorder,start,end,newNode.data);
		
		newNode.left = cons(inorder,preorder,start,inIndex-1);
		newNode.right = cons(inorder,preorder,inIndex+1,end);
		return newNode;
	}
	
	public int search(int[] order, int start, int end, int data)
	{
		for(int i=start;i<=end;i++)
		{
			if(order[i]==data)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		InorderPreorder ip = new InorderPreorder();
		int[] inorder = {4,2,5,1,3};
		int[] preorder = {1,2,4,5,3};
		ip.construct(inorder, preorder);
	}
}
