class Temp_Link {
	public int data;
	public Temp_Link next;
	
	public Temp_Link(int val) {
		data = val;
		next=null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class MergeSortLinkedList {

	public Temp_Link mergeSort(Temp_Link head) {
		if(head==null || head.next==null)
			return head;
		Temp_Link middle = getMiddle(head);
		Temp_Link second_head = middle.next;
		middle.next = null;
		head = mergeSort(head);
		second_head = mergeSort(second_head);
		return merge(head,second_head);
	}
	
	
	public Temp_Link getMiddle(Temp_Link head) {
		Temp_Link fast = head.next;
		Temp_Link slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public Temp_Link merge(Temp_Link first, Temp_Link second) {
		if(first==null) 
			return second;
		if(second==null)
			return first;
		Temp_Link result = null;
		if(first.data<second.data) {
			result = new Temp_Link(first.data);
			result.next = merge(first.next,second);
		}
		else {
			result = new Temp_Link(second.data);
			result.next = merge(first,second.next);
		}
		return result; 
	}
	
	public void display(Temp_Link head) {
		while(head!=null) {
			head.display();
			head= head.next;
		}
		System.out.println();
	}
	public static void main(String args[]) {
		MergeSortLinkedList mergeSort = new MergeSortLinkedList();
		Temp_Link head = new Temp_Link(2);
		head.next = new Temp_Link(3);
		head.next.next = new Temp_Link(20);
		head.next.next.next = new Temp_Link(5);
		head.next.next.next.next = new Temp_Link(10);
		head.next.next.next.next.next = new Temp_Link(15);
		
		mergeSort.display(head);
		head = mergeSort.mergeSort(head);
		
		mergeSort.display(head);
	}
}
