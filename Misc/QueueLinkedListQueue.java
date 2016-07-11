
public class QueueLinkedListQueue {

	private QueueLinkedList qu;
	public QueueLinkedListQueue()
	{
		qu=new QueueLinkedList();
	}
	public void push(int data)
	{
		qu.insertLast(data);
	}
	public void pop()
	{
		qu.deleteFirst();
	}
	public boolean isEmpty()
	{
		return qu.isEmpty();
	}
	public void display()
	{
		qu.display();
	}
}

	