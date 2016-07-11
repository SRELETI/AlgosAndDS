
public class CompleteTree {

	
	public TreePrint head;
	
	public CompleteTree()
	{
		head = null;
	}
	
	public boolean isComplete(TreePrint node)
	{
		if(node == null)
			return true;
		
		QueueArr q =new QueueArr(10);
		
		q.enqueue(node);
		boolean flag = false;
		while(!q.isEmpty())
		{
			TreePrint temp = q.dequeue();
			if(temp.left!=null)
			{
				if(flag == true)
					return false;
				q.enqueue(temp.left);
			}
			else
				flag =true;
			
			if(temp.right!=null)
			{
				if(flag == true)
					return false;
				q.enqueue(temp.right);
			}
			else
				flag = true;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		CompleteTree c = new CompleteTree();
		c.head = new TreePrint(1);
		c.head.left = new TreePrint(2);
		c.head.right = new TreePrint(3);
		c.head.left.left = new TreePrint(4);
		c.head.left.right = new TreePrint(5);
		c.head.right.left = new TreePrint(6);
		
		System.out.println(c.isComplete(c.head));
	}
}
