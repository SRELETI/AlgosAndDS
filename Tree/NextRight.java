
public class NextRight {

	public TreePrint head;
	
	public NextRight()
	{
		head = null;
	}
	
	public void nextRight(int key)
	{
		TreePrint result = right(head,key);
		System.out.println(result==null? null:result.data);
	}
	
	private TreePrint right(TreePrint node, int key)
	{
		if(node == null)
			return null;
		int levels=0;
		QueueArr node_s = new QueueArr(20);
		QueueArray level = new QueueArray(20);
		
		node_s.enqueue(node);
		level.enqueue(levels);
		while(!node_s.isEmpty())
		{
			node = node_s.dequeue();
			levels = level.dequeue();
			
			if(node.data == key)
			{
				if(node_s.isEmpty() || level.peek()!=levels)
					return null;
				return node_s.dequeue();
			}
			
			if(node.left!=null)
			{
				node_s.enqueue(node.left);
				level.enqueue(levels+1);
			}
			if(node.right!=null)
			{
				node_s.enqueue(node.right);
				level.enqueue(levels+1);
			}
		}
		return null;
	}
}
