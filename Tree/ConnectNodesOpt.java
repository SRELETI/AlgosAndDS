
public class ConnectNodesOpt {
	
	public TreePrintExt head;
	
	public ConnectNodesOpt()
	{
		head = null;
	}
	
	public void connect()
	{
		connectNodes(head);
	}
	
	private void connectNodes(TreePrintExt node)
	{
		if(node == null)
			return;
		
		if(node.rightExt!=null)
			connectNodes(node.rightExt);
		if(node.left!=null)
		{
			if(node.right!=null)
			{
				node.left.rightExt = node.right;
				node.right.rightExt = getNextRight(node);
			}
			else
			{
				node.left.rightExt = getNextRight(node);
			}
			connectNodes(node.left);
		}
		else if(node.right!=null)
		{
			node.right.rightExt = getNextRight(node);
			connectNodes(node.right);
		}
		else
			connectNodes(getNextRight(node));
	}
	
	private TreePrintExt getNextRight(TreePrintExt node)
	{
		TreePrintExt temp = node.rightExt;
		while(temp!=null)
		{
			if(temp.left!=null)
				return temp.left;
			if(temp.right!=null)
				return temp.right;
			temp =temp.rightExt;
		}
		return null;
	}
	
	
	public void iterativeConnect()
	{
		connects(head);
	}
	
	private void connects(TreePrintExt node)
	{
		if(node == null)
			return;
		while(node!=null)
		{
		TreePrintExt q =node;
		while(q!=null)
		{
			if(q.left!=null)
			{
				if(q.right != null)
				{
					q.left.rightExt = q.right;
					q.right.rightExt = getNextRight(q);
				}
				else
					q.left.rightExt = getNextRight(q);
			}
			else if(q.right!=null)
			{
				q.right.rightExt = getNextRight(q);
			}
			else
				q = q.rightExt;
		}
		if(node.left!=null)
			node = node.left;
		if(node.right!=null)
			node=node.right;
		else
			node = getNextRight(node);
		}
	}
}
