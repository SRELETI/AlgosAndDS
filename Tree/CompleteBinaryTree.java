
public class CompleteBinaryTree {

	private Tree_node root;
	
	public CompleteBinaryTree() {
		root = null;
	}
	
	public boolean isComplete(Tree_node root) {
		if(root == null)
			return true;
		Queue_tree q = new Queue_tree();
		q.enqueue(root);
		boolean flag = false;
		while(!q.isEmpty())
		{
			root = q.dequeue();
			if(root.prev!=null)
			{
				if(flag==true)
					return false;
				q.enqueue(root.prev);
			}
			else
				flag = true;
			
			if(root.next!=null)
			{
				if(flag==true)
					return false;
				q.enqueue(root.next);
			}
			else
				flag = true;
		}
		return true;
	}
	
	public static void main(String args[]) {
		CompleteBinaryTree c = new CompleteBinaryTree();
		c.root = new Tree_node(1);
		c.root.prev = new Tree_node(2);
		c.root.next = new Tree_node(3);
	//	c.root.prev.prev = new Tree_node(4);
	//	c.root.prev.next = new Tree_node(5);
		c.root.next.prev = new Tree_node(6);
		c.root.next.next = new Tree_node(4);
		System.out.println(c.isComplete(c.root));
	}
}
