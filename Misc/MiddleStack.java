
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class MiddleStack {
	private ListLink head;
	private int count;
	private ListLink middle;
	
	public MiddleStack() {
		head = null;
		count = 0;
		middle = null;
	}
	
	public void push(int val) {
		ListLink newNode = new ListLink(val);
		if(head == null) {
			head = newNode;
			middle = head;
			count++;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			count++;
			if(count%2 != 0) 
				middle = middle.prev;
		}
	}
	
	public int pop() {
		if(isEmpty()) return -1;
		if(head.next == null) {
			ListLink result = head;
			head = null;
			middle = null;
			count--;
			return result.data;
		}
		ListLink result = head;
		head = head.next;
		head.prev = null;
		count--;
		if( count%2 == 0) 
			middle = middle.next;
		return result.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getMiddle() {
		if(isEmpty()) return -1;
		return middle.data;
	}
	
	public int deleteMiddle() {
		if(isEmpty()) return -1;
		ListLink result = null;
		if(head.next == null) {
			result = head;
			head = null;
			count--;
		}
		else {
			result = middle;
			if(count%2 == 0) {
				middle.prev.next = middle.next;
				if(middle.next != null) 
					middle.next.prev = middle.prev;
				middle = result.prev;
				if(count==2)
					head = middle;
			}
			else {
				middle.prev.next = middle.next;
				middle.next.prev = middle.prev;
				middle = result.next;
			}
			count--;
		}
		return result.data;
	}
	
}

class ListLink {
	public int data;
	public ListLink prev;
	public ListLink next;
	public ListLink(int val) {
		data = val;
	}
	public void display() {
		System.out.print(data+" ");
	}
}
