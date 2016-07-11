
public class MiddleFind {
	public LinkLatest head;
	public void middle() {
		LinkLatest fast = head;
		LinkLatest slow = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow==null ? "null" : slow.data);
	}
	
	public void middleNow(LinkLatest head) {
		LinkLatest fast = head;
		int count=0;
		while(head!=null) {
			
			if(count%2==1) 
				fast = fast.next;
			count++;	
			head = head.next;
		}
		System.out.println(fast==null ? "null" : fast.data);
		
	}
	
	public static void main(String args[]) {
		MiddleFind m = new MiddleFind();
		m.head = new LinkLatest(1);
	//	m.head.next = new LinkLatest(2);
	//	m.head.next.next = new LinkLatest(3);
	//	m.head.next.next.next = new LinkLatest(4);
	//	m.head.next.next.next.next = new LinkLatest(5);
		
		m.middle();
		m.middleNow(m.head);
	}
}
