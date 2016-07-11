
public class ConnectNodes_new {

	public TreePrintExt head;
	
	public ConnectNodes_new()
	{
		head = null;
	}
	
	public void connect(TreePrintExt node)
	{
		if(node == null)
			return ;
		if(node.left!=null)
			node.left.rightExt = node.right;
		if(node.right!=null)
			node.right.rightExt = node.rightExt !=null ? node.rightExt.left:null;
		
		connect(node.left);
		connect(node.right);
	}
	
	
}
