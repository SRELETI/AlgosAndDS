class LinkLatestDouble {
	public int data;
	public LinkLatestDouble next;
	public LinkLatestDouble prev;
	
	public LinkLatestDouble(int val) {
		data = val;
		next = null;
		prev = null;
	}
}
public class ReverseDoubleList {
	public LinkLatestDouble head;
	public LinkLatestDouble reverse(LinkLatestDouble head) {
		if(head==null || head.next==null)
			return head;
		LinkLatestDouble temp  = head;
		LinkLatestDouble prev = null;
		while(temp!=null) {
			LinkLatestDouble temp2 = prev;
			temp.prev = temp.next;
			temp.next = temp2;
			prev = temp;
			temp = temp.prev;
		}
		return prev;
	}
	
	public void display(LinkLatestDouble temp) {
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		ReverseDoubleList r = new ReverseDoubleList();
		r.head = new LinkLatestDouble(1);
		r.head.next = new LinkLatestDouble(2);
		r.head.next.prev = r.head;
		r.head.next.next = new LinkLatestDouble(3);
		r.head.next.next.prev = r.head.next;
		r.display(r.head);
		LinkLatestDouble temp = r.reverse(r.head);
		r.display(temp);
	}
}
