
public class ConvertChildSum {

	private TreePrint head;
	
	public ConvertChildSum()
	{
		head = null;
	}
	
	public void levelOrder(TreePrint node)
	{
		QueueArr q = new QueueArr(10);
		//q.enqueue(node);
		while(node!=null)
		{
			System.out.print(node.data+" ");
			if(node.left!=null)
				q.enqueue(node.left);
			if(node.right!=null)
				q.enqueue(node.right);
			node=q.dequeue();
		}
	}
	public void convert()
	{
		TreePrint node = convertTree(head);
		levelOrder(node);
	}
	
	private TreePrint convertTree(TreePrint node)
	{
		if(node == null)
			return null;
		if(node.left == null && node.right == null)
			return node;
		TreePrint left = convertTree(node.left);
		TreePrint right = convertTree(node.right);
		
		int left_data =0;
		int right_data =0;
		
		if(left!=null)
			left_data = left.data;
		if(right!=null)
			right_data = right.data;
		int diff = left_data + right_data - node.data;
		if(diff>0)
			node.data = node.data+diff;
		else
			node = increment(node,-diff);
		return node;
	}
	
	private TreePrint increment(TreePrint node, int value)
	{
		if(node.left!=null)
		{
			node.left.data = node.left.data+value;
			increment(node.left,value);
		}
		else if(node.right!=null)
		{
			node.right.data = node.right.data+value;
			increment(node.right,value);
		}
		return node;
	}
	
	public static void main(String args[])
	{
		ConvertChildSum cc = new ConvertChildSum();
		cc.head = new TreePrint(50);
		cc.head.left = new TreePrint(7);
		cc.head.right = new TreePrint(2);
		cc.head.left.left = new TreePrint(3);
		cc.head.left.right = new TreePrint(5);
		cc.head.right.left= new TreePrint(1);
		cc.head.right.right = new TreePrint(30);
		
		cc.levelOrder(cc.head);
		System.out.println();
		cc.convert();
	}
}
