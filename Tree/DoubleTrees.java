
public class DoubleTrees {

	public TreePrint head;
	
	public DoubleTrees()
	{
		head = null;
	}
	
	public void doubles()
	{
		constr(head);
		printInorder(head);
	}
	
	
	private void printInorder(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr q = new QueueArr(20);
		q.enqueue(node);
		while(!q.isEmpty())
		{
			node = q.dequeue();
			System.out.print(node.data+" ");
			if(node.left !=null)
				q.enqueue(node.left);
			if(node.right!=null)
				q.enqueue(node.right);
		}
	}
	private void constr(TreePrint node)
	{
		if(node == null)
			return;
		constr(node.left);
		constr(node.right);
		
		TreePrint oldleft = node.left;
		node.left = new TreePrint(node.data);
		node.left.left = oldleft; 
	}
	
	private void constrPre(TreePrint node)
	{
		if(node == null)
			return;
		TreePrint oldleft = node.left;
		node.left = new TreePrint(node.data);
		node.left.left = oldleft;
		constrPre(node.left.left);
		constrPre(node.right);
	}
	
	private void constrIn(TreePrint node)
	{
		if(node == null)
			return;
		constr(node.left);
		TreePrint oldleft = node.left;
		node.left = new TreePrint(node.data);
		node.left.left = oldleft;
		constr(node.right);
	}
	
	public void printMaxWidth(TreePrint node)
	{
		if(node == null)
			return;
		int height = h(node);
		int[] count = new int[height];
		int level=0;
		getWidth(node,count,level);
		printMax(count);
	}
	private int h(TreePrint node)
	{
		if(node == null)
			return 0;
		return Math.max(h(node.left),h(node.right))+1;
	}
	private void printMax(int[] count)
	{
		int max = count[0];
		for(int i=0;i<count.length;i++)
		{
			if(max<count[i])
				max = count[i];
		}
		System.out.println(max);
	}
	
	private void getWidth(TreePrint node, int[] count, int level)
	{
		if(node!=null)
		{
			count[level]++;
			getWidth(node.left,count,level+1);
			getWidth(node.right,count,level+1);
		}
	}
	
	public static void main(String args[])
	{
		DoubleTrees d = new DoubleTrees();
		
		d.head = new TreePrint(1);
		d.head.left = new TreePrint(2);
		d.head.right = new TreePrint(3);
		
		d.head.left.left = new TreePrint(4);
		d.head.left.right = new TreePrint(5);
		d.head.right.left = new TreePrint(6);
		
	//	d.doubles();
		d.printMaxWidth(d.head);
	}
}

