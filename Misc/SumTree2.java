
public class SumTree2 {

	public TreePrint head;
	
	public SumTree2()
	{
		head = null;
	}
	
	public void checkSum()
	{
		boolean result = isSum(head);
		System.out.println(result);
	}
	public boolean isSum(TreePrint node)
	{
		if(node == null || node.left == null && node.right==null)
			return true;
		int left;
		int right;
		
		if(isSum(node.left)==true && isSum(node.right)==true)
		{
			if(node.left==null)
				left =0;
			else if(node.left.left==null && node.left.right==null)
				left = node.left.data;
			else 
				left = 2*(node.left.data);
			
			if(node.right ==null)
				right =0;
			else if(node.right.left == null && node.right.right == null)
				right = node.right.data;
			else
				right = 2*node.right.data;
			
			return node.data == left+right ;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		SumTree2 s = new SumTree2();
		
		s.head = new TreePrint(5);
		s.head.left = new TreePrint(2);
		s.head.right = new TreePrint(1);
		s.head.left.left = new TreePrint(1);
		s.head.left.right = new TreePrint(1);
		
		s.checkSum();
	}
	
}
