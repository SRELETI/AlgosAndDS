
public class PrintAncs {
	
	private TreePrint head;
	
	public PrintAncs()
	{
		head = null;
	}
	
	public boolean print(TreePrint node, int data)
	{
		if(node ==null)
			return false;
		if(node.data == data)
			return true;
		if(print(node.left,data)==true || print(node.right,data)==true)
		{
			System.out.print(node.data+" ");
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[])
	{
		PrintAncs p = new PrintAncs();
		p.head = new TreePrint(1);
		p.head.left= new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.left = new TreePrint(4);
		p.head.left.right = new TreePrint(5);
		p.head.left.left.left = new TreePrint(7);
		
		p.print(p.head,7);
		
	}
}
