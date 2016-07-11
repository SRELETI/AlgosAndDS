
public class AncestorsNode {
	
	public TreePrint head;
	
	public AncestorsNode()
	{
		head = null;
	}
	
	public void getAnc(int value)
	{
		getAncestors(head,value);
	}
	
	private boolean getAncestors(TreePrint node, int value)
	{
		if(node == null)
			return false;
		if(node.data == value)
			return true;
		if(getAncestors(node.left,value)==true || getAncestors(node.right,value)==true)
		{
			System.out.print(node.data+" ");
			return true;
		}
		else 
			return false;
	}
}
