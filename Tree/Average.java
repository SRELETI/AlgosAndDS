
public class Average {

	public TreePrint head;
	private TreePrint node = null;
	public Average()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int sum=0;
	}
	public void calc(TreePrint node)
	{
		Wrapper sum = new Wrapper();
		int result = calcAv(node,sum);
		
		System.out.println(result == 0 ? 0 : sum.sum/result );
	}
	
	private int calcAv(TreePrint node, Wrapper s)
	{
		if(node == null)
			return 0;
		Wrapper ls = new Wrapper();
		Wrapper rs = new Wrapper();
		
		int lcount = calcAv(node.left,ls);
		int rcount = calcAv(node.right,rs);
		
		s.sum = ls.sum + rs.sum + node.data;
		
		return lcount+rcount+1;
	}
	
	
	public void remove(TreePrint node, int k)
	{
		Wrapper h = new Wrapper();
		TreePrint node1 = cal(node,k,h);
		print(node1);
		
	}
	private void print(TreePrint node)
	{
		if(node!=null)
		{
			print(node.left);
			System.out.print(node.data+" ");
			print(node.right);
		}
	}
	
	private TreePrint cal(TreePrint node, int k, Wrapper sum)
	{
		if(node == null)
			return null;
		
		Wrapper lsum = new Wrapper(); 
		lsum.sum=sum.sum+node.data;
		Wrapper rsum = new Wrapper();
		rsum.sum=lsum.sum;
		
		node.left = cal(node.left,k,lsum);
		node.right = cal(node.right,k,rsum);
		
		sum.sum = Math.max(lsum.sum, rsum.sum);
		
		if(sum.sum<k)
		{
			return null;
		}
		return node;
	}
	
	public static void main(String args[])
	{
		Average a = new Average();
		
		a.head = new TreePrint(1);
		a.head.left = new TreePrint(2);
		a.head.right = new TreePrint(3);
		a.head.left.left = new TreePrint(4);
		a.head.left.right = new TreePrint(5);
		a.head.right.left = new TreePrint(6);
		a.head.right.right = new TreePrint(7);
		
		//a.calc(a.head);
		
	//	a.remove(a.head, 8);
		
	//	a.consLL(a.head);
		a.sum(a.head);
		
	}
	
	
	public void consLL(TreePrint tree)
	{
		
		con(tree);
		printNode(node);
	}
	
	private void printNode(TreePrint node)
	{
		TreePrint temp = node;
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
	}
	
	public void sum(TreePrint tree)
	{
		int value = result(tree,0);
		System.out.println(value);
	}
	
	
	private int result(TreePrint tree, int sum)
	{
		if(tree == null)
			return 0;
		sum = sum*10+tree.data;
		if(tree.left == null && tree.right == null)
			return sum;
		
		int left = result(tree.left,sum);
		int right = result(tree.right,sum);
		
		return left+right;
	}
	private TreePrint con(TreePrint tree)
	{
		if(tree == null)
			return null;
		if(tree.left==null && tree.right==null)
		{
			if(node == null)
			{
				tree.right = node;
				node = tree;
			}
			else
			{
				tree.right = node;
				node.left = tree;
				node = tree;
			}
			return null;
		}
	tree.left =con(tree.left);
	tree.right= con(tree.right);
	return tree;
	}
}
