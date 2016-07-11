
public class RemoveDupSor {
	private LinkedList head;
	public RemoveDupSor()
	{
		head=null;
	}
	public void addFirst(int value)
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
	}
	public void removeDup()
	{
		LinkedList current=head;
		while(current!=null && current.next!=null)
		{
			if(current.data==current.next.data)
			{
				current.next=current.next.next;
			}
			else
				current=current.next;
		}
	}
}
