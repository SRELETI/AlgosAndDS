
public class SwapKthNode {
	public LinkLatest head;
	public void swapNodes(LinkLatest head, int k) {
		if(head==null)
			return;
		int count = 0;
		LinkLatest cur = head;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		if(count<k) {
			System.out.println("Invalid input ");
			return;
		}
		if((2*k-1)==count) {
			System.out.println("The kth node from first and last are the same ");
			return;
		}
		LinkLatest x_prev = null;
		LinkLatest x = head;
		for(int i=1;i<k;i++) {
			x_prev = x;
			x = x.next;
		}
		LinkLatest y_prev = null;
		LinkLatest y = head;
		for(int i=1;i<count-k+1;i++) {
			y_prev = y;
			y = y.next;
		}
		
		if(x_prev!=null) {
			x_prev.next = y;
		}
		if(y_prev!=null) {
			y_prev.next = x;
		}
		
		LinkLatest temp = x.next;
		x.next = y.next;
		y.next = temp;
		
		if(k==1)
			head = y;
		if(k==count)
			head = x;
		display(head);
		
	}
	
	private void display(LinkLatest temp) {
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		SwapKthNode s = new SwapKthNode();
		s.head = new LinkLatest(1);
		s.head.next = new LinkLatest(2);
		s.head.next.next = new LinkLatest(3);
		s.head.next.next.next = new LinkLatest(4);
		s.head.next.next.next.next = new LinkLatest(5);
		s.head.next.next.next.next.next = new LinkLatest(6);
		s.display(s.head);
		s.swapNodes(s.head, 6);
	}
}
