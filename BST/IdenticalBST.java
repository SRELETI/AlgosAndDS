
public class IdenticalBST {

	public TreePrint head;
	
	public IdenticalBST()
	{
		head = null;
	}
	
	public void checkBST(int[] arr1, int[] arr2)
	{
		int n =arr1.length;
		boolean result = checkNow(arr1,arr2,n,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		System.out.println(result);
	}
	
	private boolean checkNow(int[] arr1, int[] arr2, int n, int i1, int i2, int max, int min)
	{
		int j,k;
		
		for(j=i1;j<n;j++)
		{
			if(arr1[j]>min && arr1[j]<max)
				break;
		}
		
		for(k=i2;k<n;k++)
		{
			if(arr2[k]>min && arr2[k]<max)
				break;
		}
		
		if(j==n && k==n)
			return true;
		
		if(j==n || k==n || arr1[j]!=arr2[k])
			return false;
		
		return checkNow(arr1,arr2,n,j+1,k+1,max,arr1[j]) && checkNow(arr1,arr2,n,j+1,k+1,arr1[j],min);
	}
	
	public static void main(String args[])
	{
		IdenticalBST i = new IdenticalBST();
		int[] arr1 = {8,3,6,1,4,7,10,14,13};
		int[] arr2 = {8,10,14,3,4,6,1,7,13};
		
	//	i.checkBST(arr1, arr2);
		
		i.head = new TreePrint(6);
		i.head.left = new TreePrint(-13);
		i.head.right= new TreePrint(14);
		i.head.left.right = new TreePrint(-8);
		
		i.head.right.left = new TreePrint(13);
		i.head.right.right = new TreePrint(15);
		i.head.right.left.left = new TreePrint(7);
		i.deleteRange(i.head, -10, 13);
	//	i.cons(i.head);
	}
	
	private class Wrapper
	{
		int value=0;
	}
	
	public void cons(TreePrint tree)
	{
		Wrapper s = new Wrapper();
		build(tree,s);
		print(tree);
	}
	private void print(TreePrint tree)
	{
		if(tree!=null)
		{
			print(tree.left);
			System.out.print(tree.data+" ");
			print(tree.right);
		}
	}
	
	public void deleteRange(TreePrint node, int k1, int k2)
	{
		TreePrint range = range(node,k1,k2);
		print(range);
	}
	
	private TreePrint range(TreePrint node, int k1, int k2)
	{
		if(node == null)
			return null;
		node.left = range(node.left,k1,k2);
		node.right = range(node.right,k1,k2);
		
		if(node.data<k1)
		{
			TreePrint temp = node.right;
			return temp;
		}
		if(node.data>k2)
		{
			TreePrint temp = node.left;
			return temp;
		}
		return node;
	}
	private void build(TreePrint node, Wrapper s)
	{
		if(node==null)
			return;
		build(node.right,s);
		int old = node.data;
		node.data = node.data+s.value;
		s.value= s.value+old;
		build(node.left,s);
	}
}
