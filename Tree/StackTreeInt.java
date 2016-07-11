class TreeInt_List {
	public TreeInt data;
	public TreeInt_List next;
	
	public TreeInt_List (TreeInt val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+ " ");
	}
}
public class StackTreeInt {

	private TreeInt_List head;
	
	public StackTreeInt() {
		head = null;
	}
	
	public void push(TreeInt val) {
		TreeInt_List newNode = new TreeInt_List(val);
		if(head == null) {
			head = newNode;
		}
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
	
	public boolean isEmpty() {
		return head == null;
	}
}
