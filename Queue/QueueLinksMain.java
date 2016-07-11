
public class QueueLinksMain {
	private QueueLinks head;
	private QueueLinks last;
	public QueueLinksMain()
	{
		head=null;
		last=null;
	}
	public void enqueue(int value)
	{
		QueueLinks newNode = new QueueLinks(value);
		if(head==null)
		{
			head=newNode;
			last=newNode;
		}
		else
		{
			last.next=newNode;
			last=newNode;
		}
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty ");
			return -1;
		}
		int result=head.data;
		if(head.next==null)
		{
			head=null;
			last=null;
		}
		else
		{
			head=head.next;
		}
		return result;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public int getFirst()
	{
		return head.data;
	}
	public int getLast()
	{
		return last.data;
	}
	public void display()
	{
		QueueLinks current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}
