
public class IterativeHieght {

	public TreePrint head;
	
	public IterativeHieght()
	{
		head = null;
	}
	
	public void hei()
	{
		int result = height(head);
		System.out.println("The height of the tree "+result);
	}
	
	private int height(TreePrint node)
	{
		if(node == null)
			return 0;
		
		QueueArr w = new QueueArr(20);
		
		int height =0;
		
		w.enqueue(node);
		while(true)
		{
			int nodeCount = w.size();
			if(nodeCount == 0)
				return height;
			height++;
			
			while(nodeCount>0)
			{
				node = w.dequeue();
				
				if(node.left!=null)
					w.enqueue(node.left);
				if(node.right!=null)
					w.enqueue(node.right);
				nodeCount--;
			}
		}
	}
}
