
public class LinkedListBubble {
	private LinkedList head;
	public LinkedListBubble()
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
	
	public void bubbleSort()
	{
		LinkedList inner=head;
		LinkedList outer=head;
		while(outer!=null)
		{
			inner=head;
			while(inner.next!=null)
			{
				if(inner.data>inner.next.data)
				{
					int temp=inner.data;
					inner.data=inner.next.data;
					inner.next.data=temp;
				}
				inner=inner.next;
			}
			outer=outer.next;
		}
	}
}
