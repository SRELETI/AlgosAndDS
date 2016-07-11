
public class ConnectNode {

	public TreePrintExt head;
	
	public ConnectNode()
	{
		head = null;
	}
	
	public void connect(TreePrintExt node)
	{
		if(node == null)
			return;
		QueueTree s = new QueueTree(20);
		s.enqueue(node);
		int nodeCount;
		while(!s.isEmpty())
		{
			nodeCount = s.size();
			
			while(nodeCount!=0)
			{
				node = s.dequeue();
				if(nodeCount==1)
					node.rightExt = null;
				else
					node.rightExt = s.peek();
				if(node.left!=null)
					s.enqueue(node.left);
				if(node.right!=null)
					s.enqueue(node.right);
				nodeCount--;
			}
		}
	}
	
	public void connectFull(TreePrintExt node)
	{
		if(node == null)
			return;
		if(node.left!=null)
			node.left.rightExt = node.right;
		if(node.right!=null)
			node.right.rightExt = node.rightExt == null ? null : node.rightExt.left;
		
		connectFull(node.left);
		connectFull(node.right);
	}
	
	public static void main(String args[])
	{
		ConnectNode c = new ConnectNode();
		
		c.head = new TreePrintExt(10);
		c.head.left = new TreePrintExt(8);
		c.head.right = new TreePrintExt(2);
  	//	c.head.left.left = new TreePrintExt(3);
	//	c.connect(c.head);
		
		c.connectFull(c.head);
		System.out.println(c.head.rightExt == null ? null : c.head.rightExt.data);
		System.out.println(c.head.left.rightExt == null ? null : c.head.left.rightExt.data);
		System.out.println(c.head.right.rightExt == null ? null : c.head.right.rightExt.data);
	//	System.out.println(c.head.left.left.rightExt==null ? null : c.head.left.left.rightExt.data);
		
		
	}
}
