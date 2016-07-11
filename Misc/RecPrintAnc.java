
public class RecPrintAnc {

	public TreePrint head;
	
	public RecPrintAnc()
	{
		head = null;
	}
	
	public void print(int value)
	{
		printAnc(head,value);
	}
	
	private boolean printAnc(TreePrint node, int value)
	{
		if(node == null)
			return false;
		if(node.data == value)
			return true;
		if(printAnc(node.left,value) == true || printAnc(node.right,value)==true)
		{
			System.out.print(node.data+" ");
			return true;
		}
		return false;
	}
	
}
