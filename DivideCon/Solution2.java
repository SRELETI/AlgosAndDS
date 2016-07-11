class ListNode 
{
	int val;
	ListNode next;
	public ListNode(int data)
	{
		val = data;
		next=null;
	}
	public void display()
	{
		System.out.print(val+" ");
	}
}
public class Solution2 {
	public ListNode newHead;
	public ListNode newEnd;
	public ListNode head;
    public ListNode sortList() {
        if(head==null)
            return null;
        ListNode temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        ListNode last = temp;
        head = sortOrder(head,last);
        return head;
    }
    
    private ListNode sortOrder(ListNode head, ListNode last)
    {
        if(head == null || head==last)
            return head;
        ListNode temp;
        newHead = null; 
        newEnd =null;
   //     System.out.println(head.val+" "+last.val);
        ListNode pivot = pivot(head,last);
        System.out.println(pivot.val);
        if(newHead!=pivot)
        {
        //	System.out.println(temp.val);
        	temp = newHead;
        	while(temp.next!=pivot)
        	{
        	//	System.out.println(temp.val);
        		temp = temp.next;
        	}
        	temp.next=null;
        //	System.out.println(head.val+" "+temp.val);
        	newHead = sortOrder(newHead,temp);
        	ListNode temp_no = getTail(newHead);
        	temp_no.next=pivot;
        }
    //    System.out.println(pivot.next==null ?  "null" : pivot.next.val);
        pivot.next = sortOrder(pivot.next,newEnd);
        return newHead;
    }
    
    private ListNode getTail(ListNode head)
    {
    	ListNode temp = head;
    		while(temp!=null && temp.next!=null)
    		{
    			temp = temp.next;
    		}
    	return temp;
    }
    private ListNode pivot(ListNode head, ListNode last)
    {
    	ListNode pivot = last;
    	ListNode prev = null;
    	ListNode cur = head;
    	ListNode tail = last;
    	System.out.print(head == null ? "null":head.val);
    	System.out.println(last == null ? "null":last.val);
    	while(cur!=pivot)
    	{
    		if(cur.val<pivot.val)
    		{
    			if(newHead==null)
    				newHead = cur;
    			prev = cur;
    			cur = cur.next;
    		}
    		else
    		{
    			if(prev!=null)
    				prev.next= cur.next;
    			ListNode temp = cur.next;
    			cur.next=null;
    			tail.next = cur;
    			tail = cur;
    			cur=temp;
    		}
    	}
    	if(newHead==null)
    		newHead = pivot;
    	newEnd = tail;
    	return pivot;
    }
    
    private void swap(ListNode temp, ListNode temp2)
    {
        int val = temp.val;
        temp.val = temp2.val;
        temp2.val = val;
    }
    
    public void display(ListNode head)
    {
    	ListNode temp = head;
    	while(temp!=null)
    	{
    		temp.display();
    		temp = temp.next;
    	}
    }
    public static void main(String args[])
    {
    	Solution2 s = new Solution2();
    	s.head = new ListNode(30);
    	s.head.next = new ListNode(3);
    	s.head.next.next = new ListNode(4);
    	s.head.next.next.next = new ListNode(20);
    	s.head.next.next.next.next = new ListNode(5);
    	s.head = s.sortList();
    	s.display(s.head);
    }
}