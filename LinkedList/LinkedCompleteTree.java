
public class LinkedCompleteTree {

	private TreePrint head;
	private QueueArr q;
	public LinkedCompleteTree(int queueSize)
	{
		head = null;
		q = new QueueArr(queueSize);
	}
	
	
	public void insert( int value)
	{
		TreePrint newhead = new TreePrint(value);
		if(head == null)
		{
			head = newhead;
		}
		else
		{
			TreePrint queue_out = q.peek();
		//	System.out.println(q.peek().data);
			if(queue_out.left==null)
				queue_out.left = newhead;
			else if(queue_out.right==null)
				queue_out.right = newhead;
			if(queue_out.left != null && queue_out.right != null)
				q.dequeue();
		}
		q.enqueue(newhead);
	}
	
	public void level()
	{
		if(head == null)
			return;
		QueueArr temp = new QueueArr(10);
		TreePrint node = head;
		while(node!=null)
		{
			System.out.print(node.data+" ");
			if(node.left !=null)
				temp.enqueue(node.left);
			if(node.right != null)
				temp.enqueue(node.right);
			node =temp.dequeue();
		}
	}
}
