
public class GetCountNode {
	private LinkedList head;
	public GetCountNode()
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
	}
	public void getCount(int node)
	{
		int count=0;
		LinkedList current=head;
		while(current!=null)
		{
			if(current.data==node)
				count++;
			current=current.next;
		}
		System.out.println("The count is "+count);
	}
	public void deleteNode()
	{
		LinkedList temp=head.next;
		head.data=temp.data;
		head.next=temp.next;
	}
}
