
public class DoubleLinkedListAllInOne {
	
	// Header of Doubly Linked List
	private DLLLinkInt head;
	
	// Constructor
	public DoubleLinkedListAllInOne() {
		head = null;
	}
	
	// Add node at the front of the list
	public void addFront(int data) {
		DLLLinkInt newNode = new DLLLinkInt(data);
		if(head==null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	// Add node after a given node 
	public void addAfter(int data, int after) {
		DLLLinkInt newNode = new DLLLinkInt(data);
		
		if(head == null) {
			return;
		}
		
		DLLLinkInt cur = head;
		while(cur!=null) {
			if(cur.data==after) {
				newNode.next = cur.next;
				if(cur.next!=null)
					cur.next.prev = newNode;
				cur.next = newNode;
				newNode.prev = cur;
				return;
			}
			cur = cur.next;
		}
	}
	
	//Add node at the end of the list
	public void addEnd(int data) {
		DLLLinkInt newNode = new DLLLinkInt(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		DLLLinkInt end = head;
		
		while(end.next!=null) end = end.next;
		
		end.next = newNode;
		newNode.prev = end;
	}
	
	// Add Node before a node in the list
	public void addBefore(int data, int key) {
		DLLLinkInt newNode = new DLLLinkInt(data);
		
		if(head == null) return;
		
		DLLLinkInt cur = head;
		
		while(cur!=null) {
			if(cur.data==key) {
				newNode.next = cur;
				if(cur.prev!=null) 
					cur.prev.next = newNode;
				else 
					head = newNode;
				newNode.prev = cur.prev;
				cur.prev = newNode;
			}
			cur = cur.next;
		}
		
	}
	
}

class DLLLinkInt {
	public int data;
	public DLLLinkInt prev;
	public DLLLinkInt next;
	
	public DLLLinkInt(int val) {
		data = val;
		prev = null;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
