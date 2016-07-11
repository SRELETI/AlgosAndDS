
public class DoubleQueueLink {

	private ArrLink head;
	private ArrLink tail;
	private int elements;
	
	public DoubleQueueLink()
	{
		head = null;
		tail = null;
		elements=0;
	}
	
	public void enqueue_back(int val)
	{
		ArrLink newNode = new ArrLink(val);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}

	}
	
	public int dequeue_front()
	{
		if(isEmpty())
		{
			System.out.println("Empty ");
			return -1;
		}
		if(head == tail)
		{
			int temp = head.data;
			head= null;
			tail =null;
			return temp;
		}
		int result = head.data;
		head = head.next;
		if(head!=null)
			head.prev = null;
		return result;
	}
	
	public void enqueue_front(int val)
	{
		ArrLink newNode = new ArrLink(val);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public int dequeue_back()
	{
		if(isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		if(tail == head)
		{
			int temp = tail.data;
			tail= null;
			head = null;
			return temp;
		}
		int temp = tail.data;
		tail = tail.prev;
		if(tail!=null)
			tail.next = null;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return head == null || tail == null;
	}
	
	public int front()
	{
		if(isEmpty())
		{
			System.out.print("Empty ");
			return -1;
		}
		return head.data;
	}
	
	public int back()
	{
		if(isEmpty())
		{
			System.out.print("Empty ");
			return -1;
		}
		return tail.data;
	}
}
