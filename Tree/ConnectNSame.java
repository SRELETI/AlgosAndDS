
public class ConnectNSame {

	public TreePrintExt head;
	
	public ConnectNSame()
	{
		head = null;
	}
	
	public void printSame(TreePrintExt node)
	{
		if(node == null)
			return;
		if(node.left!=null)
			node.left.rightExt = node.right;
		if(node.right!=null)
			node.right.rightExt = node.rightExt == null ? null : node.rightExt.left;
		
		printSame(node.left);
		printSame(node.right);
	}
	private void inorder(TreePrintExt node)
	{
		if(node!=null)
		{
			inorder(node.left);
			if(node.rightExt!=null)
				System.out.print(node.rightExt.data+" ");
			else
				System.out.print("null");
			inorder(node.right);
		}
	}
	
	public void connectSame(TreePrintExt node)
	{
		if(node == null)
			return;
		if(node.rightExt!=null)
			connectSame(node.rightExt);
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
			connectSame(node.left);
		}
		else if(node.right!=null)
		{
			node.right.rightExt = getNextRight(node);
			connectSame(node.right);
		}
		else
			connectSame(getNextRight(node));
	}
	
	
	private TreePrintExt getNextRight(TreePrintExt node)
	{
		TreePrintExt temp = node.rightExt;
		while(temp!=null)
		{
			if(temp.left!=null)
				return temp.left;
			else if(temp.right!=null)
				return temp.right;
			else
				temp = temp.rightExt;
		}
		return null;
	}
	public static void main(String args[])
	{
		ConnectNSame c = new ConnectNSame();
		
		c.head = new TreePrintExt(1);
		c.head.left = new TreePrintExt(2);
		c.head.right = new TreePrintExt(3);
		c.head.left.left = new TreePrintExt(4);
	//	c.head.left.right = new TreePrintExt(5);
		c.head.right.left = new TreePrintExt(6);
	//	c.connectSame(c.head);
		c.printSame(c.head);
		c.inorder(c.head);
	}
}
