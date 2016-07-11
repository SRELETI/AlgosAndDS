
public class LinkedListPriorityQueue {
	private LinkPriorityQueue head;
	private LinkPriorityQueue last;
	public LinkedListPriorityQueue()
	{
		head=null;
		last=null;
	}
	public void enqueue(int value)
	{
			LinkPriorityQueue newNode = new LinkPriorityQueue(value);
			if(isEmpty())
			{
				head=newNode;
			}
			else
			{
				LinkPriorityQueue prev=null;
				LinkPriorityQueue current = head;
				while(current!=null)
				{
					if(current.data>value)
					{
						prev=current;
						current=current.next;
					}
					else
						break;
				}
				if(prev==null)
				{
					newNode.next=head;
					head=newNode;
				}
				else
				{
					prev.next=newNode;
					newNode.next=current;
				}
			}
		}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return 0;
		}
		int result=head.data;
		head=head.next;
		return result;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public void display()
	{
		LinkPriorityQueue current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	
}
