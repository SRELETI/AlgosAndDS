
public class Successor {

	public TreePrintExt head;
	
	public Successor()
	{
		head = null;
	}
	
	public void findSuc()
	{
		TreePrintExt next = null;
		findSuccessor(head,next);
	}
	
	private void findSuccessor(TreePrintExt node, TreePrintExt next)
	{
		if(node == null)
			return;
		findSuccessor(node.right,next);
		node.rightExt = next;
		next = node;
		findSuccessor(node.left,next);
	}
}


