class list_tree {
	public TreeInt data;
	public list_tree next;
	
	public list_tree(TreeInt val) {
		data = val;
		next = null;
	}
}
public class StackTree {

	private list_tree head;
	
	public StackTree() {
		head = null;
	}
	
	public void push(TreeInt val) {
		list_tree newNode = new list_tree(val);
		if(head==null)
			head = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
	}
	
	public TreeInt pop() {
		if(isEmpty())
			return null;
		TreeInt temp = head.data;
		head = head.next;
		return temp;
	}
	
	public TreeInt peek() {
		return head.data;
		
	}
	public boolean isEmpty() {
		return head == null;
	}
}
