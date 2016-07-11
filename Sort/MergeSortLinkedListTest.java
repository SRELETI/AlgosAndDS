import static org.junit.Assert.*;

import org.junit.Test;


public class MergeSortLinkedListTest {

	@Test
	public void testMergeSort() {
		MergeSortLinkedList mergeSort = new MergeSortLinkedList();
		Temp_Link head = new Temp_Link(2);
		head.next = new Temp_Link(3);
		head.next.next = new Temp_Link(20);
		head.next.next.next = new Temp_Link(5);
		head.next.next.next.next = new Temp_Link(10);
		head.next.next.next.next.next = new Temp_Link(15);
		
		head = mergeSort.mergeSort(head);
		
		Temp_Link temp = new Temp_Link(2);
		temp.next = new Temp_Link(3);
		temp.next.next = new Temp_Link(5);
		temp.next.next.next = new Temp_Link(10);
		temp.next.next.next.next = new Temp_Link(15);
		temp.next.next.next.next.next = new Temp_Link(20);
		
		boolean tr = isSame(head,temp);
		
		assertTrue(tr);
		
	}


	public boolean isSame(Temp_Link head,Temp_Link temp) {
		while(head!=null && temp!=null) {
			if(head.data!=temp.data) 
				return false;
			head = head.next;
			temp = temp.next;
		}
		if(head==null && temp==null)
			return true;
		return false;
	}
}
