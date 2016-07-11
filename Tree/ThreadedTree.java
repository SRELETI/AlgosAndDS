
public class ThreadedTree {
	private ThreadedNode head;
	
	public ThreadedTree()
	{
		head =null;
	}
	
	public void inorder()
	{
		inorderPrint(head);
	}
	
	private void inorderPrint(ThreadedNode temp)
	{
		ThreadedNode left = leftMost(temp);
		ThreadedNode cur =left;
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			if(cur.check==true)
				cur =cur.right;
			else
				cur = leftMost(cur.right);
				
		}
	}
	
	private ThreadedNode leftMost(ThreadedNode temp)
	{
		if(temp == null)
			return null;
		if(temp.left==null)
			return temp;
		return leftMost(temp.left);
	}
	
	public static void main(String args[])
	{
		ThreadedTree c = new ThreadedTree();
		c.head = new ThreadedNode(5);
		c.head.left = new ThreadedNode(4);
		c.head.right = new ThreadedNode(6);
		c.head.left.right = c.head;
		c.head.left.check=true;
		c.inorderPrint(c.head);
	}
}
