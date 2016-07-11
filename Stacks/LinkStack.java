
public class LinkStack {
	private StackLL head;
	public LinkStack()
	{
		head=null;
	}
	public void push(int value)
	{
		
		StackLL newNode = new StackLL(value);
		if(head==null)
		{
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	public StackLL pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return head;
		}
		StackLL result = head;
		head=head.next;
		System.out.println("The popped element is "+ result.value);
		return result;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public void display()
	{
		StackLL current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		if(current==null)
			System.out.print("null");
		System.out.println();
	}
}
