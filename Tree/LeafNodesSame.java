
public class LeafNodesSame {

	public TreePrint head;
	
	public LeafNodesSame ()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int value=0;
	}
	public void leafNode()
	{
		Wrapper h = new Wrapper();
		boolean result = leafNodes(head,0,h);
		System.out.println(result);
	}
	
	private boolean leafNodes(TreePrint node, int level, Wrapper levelcheck)
	{
		if(node == null)
			return true;
		if(node.left == null && node.right == null)
		{
			if(levelcheck.value==0)
			{
				levelcheck.value = level;
				return true;
			}
			else
				return level==levelcheck.value;
		}
		return (leafNodes(node.left,level+1,levelcheck) ==true && leafNodes(node.right,level+1,levelcheck)==true);
	}
	
	
	public boolean leafCheck(TreePrint node)
	{
		if(node == null)
			return true;
		
		int level =0;
		int leafLevel = 0;
		QueueArr a = new QueueArr(20);
		
		a.enqueue(node);
		int nodeCount =0;
		while(true)
		{
			nodeCount =a.size();
			if(nodeCount==0)
				break;
			level++;
			
			while(nodeCount!=0)
			{
				node = a.dequeue();
				if(node.left!=null)
					a.enqueue(node.left);
				if(node.right!=null)
					a.enqueue(node.right);
				if(node.left==null && node.right == null)
				{
					if(leafLevel==0)
						leafLevel=level;
					else
					{
						if(leafLevel!=level)
							return false;
					}
				}
				nodeCount--;
			}
		}
		return true;
	}
}
