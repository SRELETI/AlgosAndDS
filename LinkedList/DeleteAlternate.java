
public class DeleteAlternate {
	public LinkedList head;
	public DeleteAlternate()
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
	
	public void delete()
	{
		LinkedList current=head;
		while(current!=null && current.next!=null)
		{
			current.next=current.next.next;
			current=current.next;
		}
	}
	
	public void delete_Rec(LinkedList current)
	{
		if(current==null || current.next==null)
			return;
		current.next=current.next.next;
		delete_Rec(current.next);
	}
}
