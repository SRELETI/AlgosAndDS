
public class LeafLevelIt {

	public TreePrint head;
	
	public LeafLevelIt()
	{
		head = null;
	}
	
	public void leaf(TreePrint node)
	{
		if(node == null)
			return;
		int max_level =0;
		int level = 1;
		int nodeCount =0;
		QueueArr w = new QueueArr(20);
		w.enqueue(node);
		while(true)
		{
			nodeCount = w.size();
			
			if(nodeCount == 0)
				break;
			
			while(nodeCount!=0)
			{
				node = w.dequeue();
				if(node.left!=null)
					w.enqueue(node.left);
				if(node.right!=null)
					w.enqueue(node.right);
				if(node.left == null && node.right == null && level%2==1)
				{
					if(max_level<level)
						max_level= level;
				}
				nodeCount--;
			}
			level++;
		}
		System.out.println(max_level);
	}
}
