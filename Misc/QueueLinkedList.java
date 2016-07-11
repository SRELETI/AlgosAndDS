
public class QueueLinkedList {
	private QueueLink first;
	private QueueLink last;
	public QueueLinkedList()
	{
		first=null;
		last=null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insertLast(int data)
	{
		QueueLink ql=new QueueLink(data);
		if(isEmpty())
			first=ql;
		else
		{
			last.next=ql;
		}
		last=ql;
	}
	public void deleteFirst()
	{
		QueueLink temp=first;
		if(first.next==null)
			last=null;
		first=first.next;
		System.out.println("The deleted value is : "+temp.data);
	}
	public void display()
	{
		QueueLink current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}
