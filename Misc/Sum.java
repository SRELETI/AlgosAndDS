
public class Sum {

	public TreePrint head;
	
	public Sum()
	{
		head = null;
	}
	
	public int sumTree(TreePrint node)
	{
		if(node == null)
			return 0;
		int old = node.data;
		
		node.data = sumTree(node.left)+sumTree(node.right);
		
		return node.data+old;
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
	public static void main(String args[])
	{
		Sum s = new Sum();
		s.head = new TreePrint(10);
		s.head.left = new TreePrint(-2);
		s.head.right = new TreePrint(6);
		s.head.left.left = new TreePrint(8);
		s.head.left.right = new TreePrint(-4);
		
		s.head.right.left = new TreePrint(7);
		s.head.right.right = new TreePrint(5);
		
		s.sumTree(s.head);
		s.print(s.head);
	}
}
