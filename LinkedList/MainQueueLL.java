
class LinkQ {
	int data;
	String data_str;
	LinkQ next;
	
	public LinkQ(int val) {
		data = val;
		next = null;
	}
	public LinkQ(String val) {
		data_str = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
public class MainQueueLL {

	private LinkQ head;
	private LinkQ last;
	
	public MainQueueLL () {
		head = null;
		last = null;
	}
	
	public void enqueue(int val) {
		LinkQ newNode = new LinkQ(val);
		if(isEmpty())
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public int dequeue() {
		if(isEmpty())
			return -1;
		int temp = head.data;
		head = head.next;
		return temp;
	}
	public void enqueue_str(String val) {
		LinkQ newNode = new LinkQ(val);
		if(isEmpty())
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public String dequeue_str() {
		if(isEmpty())
			return "";
		String temp = head.data_str;
		head = head.next;
		return temp;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}
