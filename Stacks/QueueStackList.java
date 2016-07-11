
public class QueueStackList {
	public QueueStack head;
	public QueueStack tail;
	public QueueStack head2;
	public QueueStack tail2;
	public QueueStackList()
	{
		head=null;
		tail=null;
		head2=null;
		tail2=null;
	}
	public void enqueue(int value)
	{
		QueueStack newNode = new QueueStack(value);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
	}
	public void enqueue2(int value)
	{
		QueueStack newNode = new QueueStack(value);
		if(head2==null)
		{
			head2=newNode;
			tail2=newNode;
		}
		else
		{
			tail2.next=newNode;
			tail2=newNode;
		}
	}
	public int dequeue()
	{
		int result=head.data;
		if(head.next==null)
		{
			head=null;
			tail=null;
		}
		else
		{
			head=head.next;
			
		}
		return result;
	}
	public int dequeue2()
	{
		int result=head2.data;
		if(head2.next==null)
		{
			head2=null;
			tail2=null;
		}
		else
		{
			head2=head2.next;
			
		}
		return result;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public boolean isEmpty2()
	{
		return head2==null;
	}
}
