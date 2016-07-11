class ListNode5 {
      int val;
      ListNode5 next;
      ListNode5(int x) {
          val = x;
          next = null;
      }
  }
public class DetectCycleLinkedList {

	public ListNode5 detectCycle(ListNode5 head) {
        ListNode5 temp = head;
        ListNode5 fast;
        ListNode5 slow;
        while(temp!=null)
        {
            fast = temp;
            slow = temp;
            while(fast!=null && fast.next!=null)
            {
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow)
                    break;
            }
            if(fast==temp)
                return temp;
            if(fast==null || fast.next==null)
                return null;
            else
                temp = temp.next;
        }
        return null;
    }
	
	public static void main(String args[])
	{
		DetectCycleLinkedList d = new DetectCycleLinkedList();
		ListNode5 l = new ListNode5(5);
		ListNode5 sec = new ListNode5(4);
		ListNode5 thr = new ListNode5(3);
		ListNode5 fou = new ListNode5(2);
		ListNode5 fif = new ListNode5(1);
		ListNode5 six = new ListNode5(0);
		
		l.next = sec;
		sec.next = thr;
		thr.next = fou;
		fou.next = fif;
		fif.next = six;
		six.next = thr;
		
		ListNode5 result = d.detectCycle(l);
		System.out.println(result == null ? "null":result.val);
	}
}
