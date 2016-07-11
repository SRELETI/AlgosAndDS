class ListNode2
{
	public int val;
	public ListNode2 next;
	
	public ListNode2(int val)
	{
		val =val;
		next =null;
	}
	public void display()
	{
		System.out.print(val+" ");
	}
}

public class MergeSortLink {

	public ListNode2 head;
	public ListNode2 tail;
	public void add(int val)
	{
		ListNode2 newNode = new ListNode2(val);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void mergeSortCal()
	{
		 ListNode2 temp =merge(head);
	//	 System.out.println("done");
		display(temp);
	}
	
	private void display(ListNode2 head)
	{
		ListNode2 temp = head;
	//	System.out.println(temp.val);
		 while(temp!=null)
		 {
			 temp.display();
			 temp = temp.next;
		 }
	}
	public ListNode2 merge(ListNode2 head)
	{
		if(head==null || head.next == null)
		{
			return head;
		}
			ListNode2 middle = getMiddle(head);
			ListNode2 first = head;
			ListNode2 second = middle.next;
			middle.next= null;
			ListNode2 temp1 = merge(first);
			ListNode2 temp2 = merge(second);
			head = mergeJoin(temp1,temp2);
			return head;
	}
	
	
	private ListNode2 getMiddle(ListNode2 head)
	{
		ListNode2 fast = head.next;
		ListNode2 slow = head;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
	//	System.out.println(slow.val);
		return slow;
	}
	
	private ListNode2 mergeJoin(ListNode2 temp1, ListNode2 temp2)
	{
		if(temp1==null)
			return temp2;
		if(temp2==null)
			return temp1;
		ListNode2 result =null;
		if(temp1.val<temp2.val)
		{
			result = temp1;
			result.next = mergeJoin(temp1.next,temp2);
		}
		else
		{
			result = temp2;
			result.next = mergeJoin(temp1,temp2.next);
		}
		return result;
	}
	
	public static void main(String args[])
	{
		MergeSortLink m = new MergeSortLink();
		m.head = new ListNode2(15);
		ListNode2 second = new ListNode2(10);
		ListNode2 thrid = new ListNode2(5);
		ListNode2 fourth = new ListNode2(20);
		ListNode2 fifth = new ListNode2(3);
		ListNode2 sixth = new ListNode2(2);
		m.head.next = second;
		second.next = thrid;
		thrid.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		m.mergeSortCal();
	}
}
