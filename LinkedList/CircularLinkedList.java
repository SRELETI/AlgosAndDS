
public class CircularLinkedList {

	private PracticeDel head;
//	private PracticeDel last;
	public CircularLinkedList()
	{
		head = null;
//		last = null;
	}
	
	public void insert(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
		{
			newNode.next = newNode;
			head= newNode;
		}
		else
		{
			PracticeDel temp = head;
			while(temp.next!=head)
				temp = temp.next;
			temp.next = newNode;
			newNode.next = head;
		}
	}
	
	public PracticeDel delete(int val)
	{
		if(head == null)
			return null;
		PracticeDel temp = head;
		PracticeDel end = getTail(head);
		PracticeDel prev = null;
		while(temp.next!=head)
		{
			if(temp.data==val)
			{
				if(prev == null)
				{
					head = head.next;
					end.next = head;
				}
				else
				{
					temp = temp.next;
					prev.next = temp;
				}
				break;
			}
			else
			{
				prev = temp;
				temp = temp.next;
			}
		}
		if(temp.data==val)
		{
			temp = temp.next;
			prev.next = temp;
		}
		return head;
	}
	
	private PracticeDel getTail(PracticeDel temp)
	{
		if(temp==null)
			return temp;
		PracticeDel temp1 = temp;
		while(temp1.next!=temp)
			temp1 = temp1.next;
		return temp1;
	}
	public void display(PracticeDel head)
	{
		PracticeDel temp = head;
		if(temp!=null)
		{
			do
			{
				temp.display();
				temp = temp.next;
			}while(temp!=head);
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		CircularLinkedList c = new CircularLinkedList();
		c.insert(1);
		c.insert(2);
		c.insert(11);
		c.insert(12);
		c.insert(56);
		c.insert(90);
		c.display(c.head);
		PracticeDel head = c.delete(90);
		c.display(head);
	}
	
}
