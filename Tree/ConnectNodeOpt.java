
public class ConnectNodeOpt {


	public TreePrintExt head;
	
	public ConnectNodeOpt()
	{
		head = null;
	}
	
	public void connect(TreePrintExt node)
	{
		if(node == null)
			return;
		if(node.left!= null)
			node.left.rightExt = node.right;
		if(node.right!=null)
			node.right.rightExt = node.rightExt==null ? null : node.rightExt.left;
		connect(node.left);
		connect(node.right);
	}
	
	public void connectRec(TreePrintExt node)
	{
		if(node == null)
			return;
		
		if(node.rightExt!=null)
			connectRec(node.rightExt);
		
		
	}
}
