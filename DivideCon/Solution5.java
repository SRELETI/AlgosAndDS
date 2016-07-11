class ListNode3
{
	int val;
	ListNode3 next;
	public ListNode3(int data)
	{
		val = data;
		next = null;
	}
	public void display()
	{
		System.out.print(val+" ");
	}
}
public class Solution5 {
    public void reorderList(ListNode3 head) {
        if(head == null || head.next==null)
            return;
        if(head.next.next==null)
            return;
        ListNode3 temp = head;
        ListNode3 temp2;
        ListNode3 last;
        while(temp!=null && temp.next!=null && temp.next.next!=null)
        {
            temp2 = temp.next;
            last = getLast(temp);
            temp.next = last;
            last.next = temp2;
            temp = temp2;
        }
    }
    
    private void display(ListNode3 head)
    {
    	ListNode3 temp = head;
    	while(temp!=null)
    	{
    		temp.display();
    		temp = temp.next;
    	}
    }
    
    private ListNode3 getLast(ListNode3 head)
    {
        ListNode3 prev=null;
        ListNode3 cur = head;
        while(cur.next!=null)
        {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        return cur;
    }
    
    public static void main(String args[])
    {
    	ListNode3 head = new ListNode3(1);
    	ListNode3 h2 = new ListNode3(2);
    	ListNode3 h3 = new ListNode3(3);
    	ListNode3 h4 = new ListNode3(4);
    	head.next = h2;
    	h2.next = h3;
    	Solution5 s = new Solution5();
    	s.reorderList(head);
    	s.display(head);
    }
}


