
public class ReverseListLatest {

	public LinkLatest head;
	public LinkLatest rev_head;
	public void reverse() {
		if(head==null)
			return;
		LinkLatest prev = head;
		LinkLatest cur = head.next;
		LinkLatest next;
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev.next = null;
			prev = cur;
			cur = next;
		}
		display(prev);
	}
	
	public void rev(LinkLatest rev) {
		if(rev==null)
			return;
		if(rev.next==null) {
			rev_head = rev;
			return;
		}
		rev(rev.next);
		LinkLatest temp = rev.next;
		rev.next = null;
		temp.next = rev;
	}
	private void display(LinkLatest temp ){
		while(temp!=null) {
			temp.display();
			temp = temp.next;
		}
	}
	
	
	public static void main(String args[]) {
		ReverseListLatest r = new ReverseListLatest();
		r.head = new LinkLatest(1);
	//	r.head.next = new LinkLatest(2);
	//	r.head.next.next = new LinkLatest(3);
	//	r.reverse();
		r.rev(r.head);
		r.display(r.rev_head);
	}
	
}
