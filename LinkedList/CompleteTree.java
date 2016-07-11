
class Tree_node {
	int data;
	Tree_node next;
	Tree_node prev;
	
	public Tree_node(int val) {
		data = val;
		next =null;
		prev = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
class node_list {
	Tree_node data;
	node_list next;
	
	public node_list(Tree_node val) {
		data = val;
		next = null;
	}
}
class Queue_tree {
	private node_list head;
	private node_list last;
	private int count;
	public Queue_tree() {
		head = null;
		last = null;
		count = 0;
	}
	
	public void enqueue(Tree_node val) {
		node_list newNode = new node_list(val);
		if(isEmpty())
		{
			head = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
		count++;
	}
	
	public Tree_node dequeue() {
		if(isEmpty())
			return null;
		node_list temp = head;
		head = head.next;
		count--;
		return temp.data;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	public void display() {
		node_list temp = head;
		while(temp!=null)
		{
			temp.data.display();
			temp = temp.next;
		}
	}
	
	public int size() {
		return count;
	}
}
public class CompleteTree {

	public boolean isComplete(Tree_node root) {
		if(root ==null)
			return true;
		Queue_tree q = new Queue_tree();
		q.enqueue(root);
		boolean flag = false;
		Tree_node temp;
		while(!q.isEmpty())
		{
			temp = q.dequeue();
		//	System.out.println(temp.data);
			if(temp.prev!=null)
			{
				if(flag==true)
					return false;
				q.enqueue(temp.prev);
			}
			else
				flag = true;
			
			if(temp.next!=null)
			{
				if(flag==true)
					return false;
				q.enqueue(temp.next);
			}
			else
				flag = true;
		//	q.display();
		}
		return true;
	}
	
	public static void main(String args[]) {
		CompleteTree c = new CompleteTree();
		Tree_node root = new Tree_node(1);
	//	root.prev = new Tree_node(2);
		root.next = new Tree_node(3);
	//	root.prev.prev =new Tree_node(4);
	//	root.prev.next = new Tree_node(5);
	//	root.next.prev = new Tree_node(6);
	//	root.next.next = new Tree_node(7);
		System.out.println(c.isComplete(root));
	}
}
