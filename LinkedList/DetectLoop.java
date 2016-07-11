
public class DetectLoop {

	private PracticeDel head;
	public DetectLoop() {
		head = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head;
		head=newNode;
	}
	
	public boolean detectLoop()
	{
		PracticeDel slow = head;
		PracticeDel fast = head;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null)
			return false;
		fast = head;
		while(fast!=slow)
		{
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println(fast.data);
		return true;
	}
	
	public static void main(String args[])
	{
		DetectLoop d = new DetectLoop();
		d.insertion(5);
		d.insertion(4);
		d.insertion(3);
		d.insertion(2);
		d.head.next.next.next = d.head;
		System.out.println(d.detectLoop());
	}
	public PracticeDel reverse(PracticeDel head)
	{
		PracticeDel prev = null;
		PracticeDel cur = head;
		PracticeDel next;
		while(cur!=null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
}
