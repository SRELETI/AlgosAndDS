
public class CopyRandomPointer {

	private DoubleLL head;
	
	public CopyRandomPointer() {
		head = null;
	}
	
	public void insertion(int val) {
		DoubleLL newNode = new DoubleLL(val);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			DoubleLL temp = head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next = newNode;
		}
	}
	
	public DoubleLL CopyList()
	{
		if(head == null)
			return null;
		DoubleLL p = head;
		DoubleLL temp;
		while(p!=null)
		{
			temp = new DoubleLL(p.data);
			temp.next = p.next;
			p.next= temp;
			p = p.next.next;
		}
		
		p = head;
		while(p!=null)
		{
			if(p.prev!=null)
				p.next.prev = p.prev.next;
			p = p.next.next;
		}
		p =head;
		DoubleLL newHead = p.next;
		while(p!=null)
		{
			temp = p.next;
			p.next = temp.next;
			if(temp.next!=null)
				temp.next = temp.next.next;
			p = p.next;
		}
		return newHead;
	}
}
