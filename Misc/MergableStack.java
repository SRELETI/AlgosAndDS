import java.util.Stack;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class MergableStack {

	private CirLink last1;
	private CirLink last2;
	
	public MergableStack() {
		last1 = null;
		last2 = null;
	}
	
	public void push(String s, int val) {
		if(s.equals("1")) 
			pushStack(last1, val);
		else
			pushStack(last2,val);
	}
	
	private void pushStack(CirLink head, int val) {
		CirLink newNode = new CirLink(val);
		if(head == null) {
			head = newNode;
			head.next = head;
		}
		else {
			CirLink temp = head.next;
			head.next = newNode;
			newNode.next = temp;
		}
	}
	
	public int pop(String s) {
		if(s.equals("1")) 
			return popStack(last1);
		else
			return popStack(last2);
	}
	
	private int popStack(CirLink head) {
		if(head == last1) {
			if(isEmpty1())
				return -1;
		}
		else {
			if(isEmpty2())
				return -1;
		}
		int result = 0;
		if(head.next == head) {
			result = head.data;
			head = null;
		}
		else {
			result = head.next.data;
			head.next = head.next.next;
		}
		return result;
	}
	
	public boolean isEmpty1() {
		return last1==null;
	}
	public boolean isEmpty2() {
		return last2 == null;
	}
	
	public void mergeStack(String s, String s2) {
		if(isEmpty1()) {
			last1 = last2;
			return;
		}
		if(isEmpty2()) {
			return;
		}
		
		CirLink head1 = last1.next;
		last1.next = last2.next;
		last2.next = head1;
		
	}
}

class CirLink {
	public int data;
	public CirLink next;
	
	public CirLink(int val) {
		data = val;
		next = null;
	}
}