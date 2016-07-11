
public class height {
	
	private TreePrint head;
	
	public height()
	{
		head = null;
	}
	
	public int heightCal(TreePrint node)
	{
		if(node == null)
			return 0;
		
		int left = heightCal(node.left);
		int right = heightCal(node.right);
		
		return (left>right ? left+1 : right+1);
	}
	
	public static void main(String args[])
	{
		height h = new height();
		h.head = new TreePrint(1);
		h.head.left= new TreePrint(2);
		h.head.right = new TreePrint(3);
		//h.head.left.left = new TreePrint(4);
		//h.head.left.right = new TreePrint(5);
		
		int result = h.heightCal(h.head);
		System.out.println(result);
	}
}
