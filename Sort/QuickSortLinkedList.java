
public class QuickSortLinkedList {

	public Temp_Link quickSort(Temp_Link head) {
		if(head==null || head.next==null)
			return head;
		Temp_Link pivot = getPivot(head);
		
		if(pivot!=head) {
			Temp_Link tail = getTail(head,pivot);
			tail.next = null;
			head = quickSort(head);
			Temp_Link newTail = getTail(head,null);
			newTail.next = pivot;
		}
		pivot.next = quickSort(pivot.next);
		return head;
	}
	
	public Temp_Link getTail(Temp_Link head, Temp_Link last) {
		Temp_Link prev= null;
		Temp_Link next = head;
		while(next!=last) {
			prev= next;
			next = next.next;
		}
		return prev;
	}
	
	public Temp_Link getPivot(Temp_Link head) {
		Temp_Link last = getTail(head,null);
		int key = last.data;
		Temp_Link start = head;
		Temp_Link finalStart = head;
		while(start!=last) {
			if(start.data<last.data) {
				int temp = start.data;
				start.data = finalStart.data;
				finalStart.data = temp;
				finalStart = finalStart.next;
			}
			start = start.next;
		}
		int temp = finalStart.data;
		finalStart.data = last.data;
		last.data = temp;
		return finalStart;
	}
	
	public void display(Temp_Link head) {
		while(head!=null) {
			head.display();
			head= head.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		QuickSortLinkedList q = new QuickSortLinkedList();
		
		Temp_Link head = new Temp_Link(2);
		head.next = new Temp_Link(3);
		head.next.next = new Temp_Link(20);
		head.next.next.next = new Temp_Link(5);
		head.next.next.next.next = new Temp_Link(10);
		head.next.next.next.next.next = new Temp_Link(15);
		
		q.display(head);
		head = q.quickSort(head);
		q.display(head);
	}
}
