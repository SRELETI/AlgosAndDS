class node_temp {
	public int data;
	public node_temp next;
	
	public node_temp(int val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}


public class ConvertLLTree {
	private Tree_node root;
	
	public ConvertLLTree() {
		root = null;
	}
	
	public Tree_node convert(node_temp temp) {
		if(temp==null)
			return null;
		Tree_node tree = new Tree_node(temp.data);
		Queue_tree q = new Queue_tree();
		q.enqueue(tree);
		temp = temp.next;
		Tree_node temp2;
		while(temp!=null)
		{
			temp2 = q.dequeue();
			if(temp!=null)
			{
				temp2.prev = new Tree_node(temp.data);
				temp = temp.next;
				q.enqueue(temp2.prev);
			}
			if(temp!=null)
			{
				temp2.next = new Tree_node(temp.data);
				temp = temp.next;
				q.enqueue(temp2.next);
			}
		}
		return tree;
	}
	
	public void inorder(Tree_node temp ){
		if(temp!=null) {
			inorder(temp.prev);
			temp.display();
			inorder(temp.next);
		}
	}
	public static void main(String args[]) {
		ConvertLLTree c = new ConvertLLTree();
		node_temp head = new node_temp(10);
		head.next = new node_temp(12);
		head.next.next = new node_temp(15);
		head.next.next.next = new node_temp(25);
		head.next.next.next.next = new node_temp(30);
		head.next.next.next.next.next = new node_temp(36);
		
		Tree_node temp = c.convert(head);
		c.inorder(temp);
	}
}
