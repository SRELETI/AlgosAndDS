import java.util.Arrays;


public class CheckBST {

	private TreePrint head;
	private int index = 0;
	public CheckBST()
	{
		head = null;
	}
	
	public void check(TreePrint node)
	{
		checkTree(node);
	}
	
	private class Wrapper
	{
		int[] check = new int[20];
		int index = 0;
	}
	private boolean checkTree(TreePrint node)
	{
		if(node == null)
			return true;
		if(node.left!=null && node.left.data>node.data)
			return false;
		if(node.right!=null && node.right.data < node.data)
			return false;
		if(checkTree(node.left) ==false || checkTree(node.right)==false)
			return false;
		return true;
	}
	
	private boolean check2Tree(TreePrint node)
	{
		if(node == null)
			return true;
		if(node.left!=null && maxValue(node.left) >= node.data)
			return false;
		if(node.right!=null && minValue(node.right) <= node.data)
			return false;
		if(check2Tree(node.left)==false || check2Tree(node.right)==false)
			return false;
		return true;
	}
	
	private int maxValue(TreePrint node)
	{
		if(node == null)
			return 0;
		TreePrint temp = node;
		while(temp.right!=null)
			temp = temp.right;
		return node.data;
	}
	
	private int minValue(TreePrint node)
	{
		if(node == null)
			return 0;
		while(node.left!=null)
			node = node.left;
		return node.data;
	}
	
	private boolean check3Tree(TreePrint node, int MIN, int MAX)
	{
		if(node == null)
			return true;
		if(MIN>node.data || MAX<node.data)
			return false;
		return (check3Tree(node.left,MIN,node.data-1) && check3Tree(node.right,node.data+1,MAX));
	}
	
	private void inorder(TreePrint node, int[] sum)
	{
		if(node!=null)
		{
			inorder(node.left,sum);
			sum[index++]=node.data;
			inorder(node.right,sum);
		}
	}
	
	private void checkInorder(TreePrint node)
	{
		int[] a = new int[20];
		inorder(node,a);
		System.out.println(checkarrayBST(a,index));
	}
	
	private boolean checkarrayBST(int[] a,int in)
	{
		for(int i=1;i<in;i++)
		{
			if(a[i]<a[i-1])
				return false;
		}
		return true;
	}
	
	private boolean checkOptTree(TreePrint node, TreePrint temp)
	{
		if(node== null)
			return true;
		if(checkOptTree(node.left,temp)==false)
			return false;
		if(temp!=null && node.data<temp.data)
			return false;
		temp = node;
		return checkOptTree(node.right,temp);
	}
	
	public void checkOpt(TreePrint node)
	{
		boolean result = checkOptTree(node,null);
		System.out.println(result);
	}
	
	private boolean find(TreePrint node, int n)
	{
		if(node == null)
			return false;
		if(node.data == n)
			return true;
		return find(node.left,n) || find(node.right,n);
	}
	public void lowestAn(TreePrint node, int n1, int n2)
	{
		if(node == null || find(node,n1)==false || find(node,n2)==false)
		{
			System.out.println("n1 or n2 not present");
			return;
		}
		TreePrint result = lowest(node,n1,n2);
		System.out.println(result == null ? null : result.data);
	}
	
	private TreePrint lowest(TreePrint node, int n1, int n2)
	{
		if(node == null)
			return null;
		if(n1<node.data && n2<node.data)
			return lowest(node.left,n1,n2);
		if(n1>node.data && n2>node.data)
			return lowest(node.right,n1,n2);
		return node;
	}
	
	public static void main(String args[])
	{
		CheckBST s = new CheckBST();
		s.head = new TreePrint(4);
		s.head.left = new TreePrint(2);
		s.head.left.right = new TreePrint(3);
		s.head.left.left = new TreePrint(1);
		s.head.right = new TreePrint(5);
		
	//	s.checkInorder(s.head);
	//	s.checkOpt(s.head);
	//	s.checkMake(s.head);
		s.lowestAn(s.head, 2, 1);
	}
}

