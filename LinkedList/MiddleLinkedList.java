
public class MiddleLinkedList {
	private LinkedList head;
	public MiddleLinkedList()
	{
		head=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	public int middle()
	{
		LinkedList slow=head;
		LinkedList fast=head;
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	public int middle_2()
	{
		LinkedList middle=head;
		LinkedList current=head;
		int count=1;
		while(current!=null && current.next!=null)
		{
			current=current.next;
			if((count & 1)==1)
				middle=middle.next;
			count++;
		}
		if(middle!=null)
		{
			System.out.println(middle.data);
			return middle.data;
		}
		else
			return -1;
	}
	public void display()
	{
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
}
