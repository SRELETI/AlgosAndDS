
public class ArrayP {

	public TreePrint head;
	
	public ArrayP()
	{
		head =  null;
	}
	
	public int height(TreePrint node)
	{
		if(node == null)
			return 0;
		QueueArr q = new QueueArr(20);
		q.enqueue(node);
		int nodeCount=0;
		int height=0;
		while(true)
		{
			nodeCount = q.size();
			if(nodeCount==0)
				return height;
			height++;
			while(nodeCount!=0)
			{
				node = q.dequeue();
				if(node.left!=null)
					q.enqueue(node.left);
				if(node.right!=null)
					q.enqueue(node.right);
				nodeCount--;
			}
		
		}
	}
	
	public void findH()
	{
		int result = height(head);
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		ArrayP p = new ArrayP();
		p.head = new TreePrint(1);
		p.head.left = new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.left = new TreePrint(4);
		p.head.left.right = new TreePrint(5);
		
		p.findH();
	}
}
