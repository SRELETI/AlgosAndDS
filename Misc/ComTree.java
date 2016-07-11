
public class ComTree {

	public TreePrint head;
	QueueArr q = new QueueArr(20);
	public ComTree()
	{
		head = null;
	}
	
	public void levelOrder(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr q = new QueueArr(20);
		q.enqueue(node);
		while(!q.isEmpty())
		{
			node = q.dequeue();
			System.out.print(node.data+" ");
			if(node.left!=null)
				q.enqueue(node.left);
			if(node.right!=null)
				q.enqueue(node.right);
		}
	}
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		
		if(head == null)
		{
			head = newNode;
		}
		else
		{
		
			
			TreePrint temp = q.peek();
	//		System.out.println(temp);
				if(temp.left==null)
					temp.left = newNode;
				else if(temp.right==null)
					temp.right = newNode;
				if(temp.left!=null && temp.right!=null)
					q.dequeue();
		}
		q.enqueue(newNode);
	//	System.out.println(q.size());
	}
	
	public static void main(String args[])
	{
		ComTree c = new ComTree();
		c.insert(1);
		c.insert(2);
		c.insert(3);
		c.insert(4);
		c.insert(5);
		
		c.levelOrder(c.head);
	}
}
