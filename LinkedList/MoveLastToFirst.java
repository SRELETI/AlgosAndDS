
public class MoveLastToFirst {
	private LinkedList head;
	public MoveLastToFirst()
	{
		head=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	public void display()
	{
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	public void moveLast()
	{
		if(head==null)
			return;
		LinkedList current=head;
		LinkedList prev=null;
		while(current.next!=null)
		{
			prev=current;
			current=current.next;
		}
		if(prev==null)
			return;
		current.next=head;
		head=current;
		prev.next=null;
	}
}
