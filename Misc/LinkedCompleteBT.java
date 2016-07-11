import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class LinkedCompleteBT {

	private TreeInt head;
	private Queue q;
	
	public LinkedCompleteBT() {
		head = null;
		q = new LinkedList();
	}
	
	
	public boolean add(int val) {
		TreeInt newNode = new TreeInt(val);
		if(q.isEmpty()) {
			head = newNode;
			q.add(newNode);
			return true;
		}
		else {
			TreeInt temp = (TreeInt)q.peek();
			if(temp.left==null) {
				temp.left = newNode;
			}
			else if(temp.right==null) {
				temp.right = newNode;
			}
			q.add(newNode);
			if(temp.left!=null && temp.right!=null) {
				q.remove();
			}
			return true;
		}
	}
	
	public void inorder() {
		if(head==null)
			return;
		Stack s = new Stack();
	//	s.add(head);
		TreeInt node = head;
		while(true) {
			while(node!=null) {
				s.add(node);
				node = node.left;
			}
			if(s.isEmpty())
				return;
			node = (TreeInt)s.pop();
			System.out.print(node.data+" ");
			node = node.right;
		}
		
	}
	
	public static void main(String args[]) {
		LinkedCompleteBT lc = new LinkedCompleteBT();
		lc.add(1);
		lc.add(2);
		lc.add(3);
		lc.add(4);
		lc.add(5);
		lc.inorder();
	}
}
