
public class NextArbitLatest {
	
	public LinkLatestDouble head;
	public LinkLatestDouble arbitNow(LinkLatestDouble head) {
		if(head==null || head.next==null)
			return head;
		LinkLatestDouble cur = head;
		while(cur!=null) {
			LinkLatestDouble temp = cur.next;
			cur.next= new LinkLatestDouble(cur.data);
			cur.next.next = temp;
			cur = temp;
		}
		
		cur = head;
		while(cur!=null) {
			cur.next.prev = cur.prev.next;
			cur = cur.next.next;
		}
		
		LinkLatestDouble newHead = head.next;
		cur = head;
		LinkLatestDouble newCur = newHead;
		while(cur!=null && newCur!=null) {
			cur.next = newCur.next;
			if(newCur.next!=null) {
				newCur.next = newCur.next.next;
				newCur= newCur.next; 
			}
			else
				newCur.next = null;
			cur = cur.next;
		}
		return newHead;
	}
}
