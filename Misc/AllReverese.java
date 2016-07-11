
public class AllReverese {
	
	public LinkLatest head;
	public LinkLatest reverseK(LinkLatest head,int k) {
		if(head==null)
			return head;
		int count = 0;
		LinkLatest temp = head;
		LinkLatest prev=null;
		LinkLatest next;
		while(temp!=null && count<k) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}
		
		if(head!=null)
			head.next= reverseK(temp,k);
		return prev;
	}
	
	public LinkLatest reverseKAlt(LinkLatest head, int k) {
		if(head == null) 
			return head;
		int count = 0;
		LinkLatest temp = head;
		LinkLatest prev = null;
		LinkLatest next;
		while(temp!=null && count<k) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}
		if(head!=null)
			head.next = temp;
		count = 0;
		while(count<k-1 && temp!=null) {
			count++;
			temp = temp.next;
		}
		if(temp!=null) 
			temp.next = reverseKAlt(temp.next,k);
		return prev;
	}
	public LinkLatest reverseKNoRev(LinkLatest head, int k) {
		if(head == null)
			return head;
		int count = 0;
		LinkLatest temp = head;
		while(count<k) {
			if(temp==null)
				return head;
			temp = temp.next;
			count++;
		}
		count = 0;
		temp = head;
		LinkLatest prev = null;
		LinkLatest next ;
		while(count<k) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}
		if(head!=null) 
			head.next = reverseKNoRev(temp,k);
		return prev;
	}
	public void display(LinkLatest temp ){
		while(temp!=null) {
			temp.display();
			temp = temp.next;
		}
	}
	public static void main(String args[]) {
		AllReverese a = new AllReverese();
		a.head = new LinkLatest(1);
		a.head.next = new LinkLatest(2);
		a.head.next.next = new LinkLatest(3);
		a.head.next.next.next = new LinkLatest(4);
		a.head.next.next.next.next = new LinkLatest(5);
		a.head.next.next.next.next.next = new LinkLatest(6);
		a.head.next.next.next.next.next.next = new LinkLatest(7);
		a.head.next.next.next.next.next.next.next = new LinkLatest(8);
	//	a.head.next.next.next.next.next.next.next.next = new LinkLatest(9);
	//	LinkLatest temp = a.reverseK(a.head, 3);
	//	LinkLatest temp = a.reverseKNoRev(a.head, 3);
		LinkLatest temp = a.reverseKAlt(a.head, 3);
		a.display(temp);
	}
}
