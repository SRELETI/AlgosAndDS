
public class LevelOrderFunction {
	
	private TreePrint head;
	
	public LevelOrderFunction()
	{
		head = null;
	}
	
	public void levelOrder(TreePrint node)
	{
		int h =height(node);
		for(int i=1;i<=h;i++)
			level(node,i);
	}
	
	public int height(TreePrint node)
	{
		if(node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		return (left>right ? left+1 : right+1);
	}
	
	public void level(TreePrint node, int level)
	{
		if(node == null)
			return;
		if(level == 1)
			System.out.print(node.data+" ");
		level(node.left,level-1);
		level(node.right,level-1);
	}
	
	public static void main(String args[])
	{
		LevelOrderFunction lo = new LevelOrderFunction();
		lo.head = new TreePrint(1);
		lo.head.left = new TreePrint(2);
		lo.head.right = new TreePrint(3);
		lo.head.left.left = new TreePrint(4);
		lo.head.left.right = new TreePrint(5);
		
		lo.levelOrder(lo.head);
		System.out.println();
		lo.queueLevel(lo.head);
		
	}
	
	
	public void queueLevel(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr q = new QueueArr(10);
		while(node!=null)
		{
			System.out.print(node.data+" ");
			if(node.left!=null)
				q.enqueue(node.left);
			if(node.right!=null)
				q.enqueue(node.right);
			node = q.dequeue();
		}
	}
	
}
