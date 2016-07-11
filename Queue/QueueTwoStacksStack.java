
public class QueueTwoStacksStack {
	private QueueTwoStacks head;
	public QueueTwoStacksStack()
	{
		head=null;
	}
	public void push(int value)
	{
		QueueTwoStacks newNode = new QueueTwoStacks(value);
		newNode.next=head;
		head=newNode;
	}
	public int pop()
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
		QueueTwoStacks current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	public boolean isOneLength()
	{
		return head!=null && head.next==null;
	}
}
