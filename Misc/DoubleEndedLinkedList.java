public class DoubleEndedLinkedList
{
	private DoubleEndedList first;
	private DoubleEndedList last;
	public DoubleEndedLinkedList()
	{
		first=null;
		last=null;
	}
	public void insertFirst(int data)
	{
		DoubleEndedList newNode1=new DoubleEndedList(data);
		if(isEmpty())
			last=newNode1;
		newNode1.next=first;
		first=newNode1;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insertLast(int data)
	{
		DoubleEndedList newNode=new DoubleEndedList(data);
		if(isEmpty())
			first=newNode;
		else
			last.next=newNode;
		last=newNode;
	}
	public void deleteFirst()
	{
		DoubleEndedList temp=first;
		if(first.next==null)
			last=null;
		first=first.next;
	}
	public void display()
	{
		DoubleEndedList current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
}
