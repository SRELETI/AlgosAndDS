
public class ConstructComTree {

	private TreePrint head;
	
	
	public ConstructComTree()
	{
		head = null;
	}
	
	public void buildTree(LinkedList node)
	{
		if(node == null)
		{
			return ;
		}
		
		TreePrint newNode = new TreePrint(node.data);
		head = newNode;
		QueueArr a = new QueueArr(20);
		a.enqueue(newNode);
		node = node.next;
		while(node != null)
		{
			TreePrint temp = a.dequeue();
			TreePrint left=null, right=null;
			left  = new TreePrint(node.data);
			node = node.next;
			if(node != null)
				right = new TreePrint(node.data);
			node = node.next;      
			a.enqueue(left);
			a.enqueue(right);
			temp.left = left;
			temp.right = right;
			
		}
		inorder(head);
	}
	
	public void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	public static void main(String args[])
	{
		LinkedListAdd a = new LinkedListAdd();
		a.addLast(1);
		a.addLast(2);
		a.addLast(3);
		a.addLast(4);
		a.addLast(5);
		
		ConstructComTree c = new ConstructComTree();
		c.buildTree(a.head);
	}
	
}
