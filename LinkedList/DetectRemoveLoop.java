
public class DetectRemoveLoop {

	private PracticeDel head;
	private PracticeDel last;
	public DetectRemoveLoop()
	{
		head = null;
		last = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
		{
			head = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void removeLoop()
	{
		if(head==null || head.next == null)
			return;
		PracticeDel fast = head;
		PracticeDel slow = head;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null || fast!=slow)
			return;
		slow = head;
		PracticeDel prev = null;
		while(slow!=fast)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		if(prev!=null)
			prev.next = null;
	}
	public void display()
	{
		PracticeDel temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
			if(temp==head)
				return;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		DetectRemoveLoop d = new DetectRemoveLoop();
		d.insertion(1);
		d.insertion(2);
		d.insertion(3);
		d.insertion(4);
		d.insertion(5);
		d.head.next.next.next.next = d.head;
		d.removeLoop();
		d.display();
		
	}
}
