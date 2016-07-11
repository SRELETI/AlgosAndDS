
public class BinaryTreeComplete {

	public TreePrint head;
	
	public BinaryTreeComplete()
	{
		head = null;
	}
	
	public boolean check(TreePrint node)
	{
		if(node == null)
			return true;
		
		QueueArr q = new QueueArr(20);
		
		boolean check =false;
		
		q.enqueue(node);
		
		while(!q.isEmpty())
		{
			node = q.dequeue();
			
			if(node.left != null)
			{
				if(check == true)
					return false;
				q.enqueue(node.left);
			}
			else
				check = true;
			if(node.right!=null)
			{
				if(check == true)
					return false;
				q.enqueue(node.right);
			}
			else
				check = true;
		}
		return true;
	}
}
