
public class GetNEnd {
	private LinkedList head;
	public GetNEnd()
	{
		head=null;
	}
	public int getN(int n)
	{
		int length=0;
		LinkedList current=head;
		while(current!=null)
		{
			length++;
			current=current.next;
		}
		int result_length=length-n+1;
		if(result_length<=0)
		{
			System.out.println("Invalid Index ");
			return -1;
		}
		current=head;
		for(int i=1;i<result_length;i++)
		{
			current=current.next;
		}
		return current.data;
	}
	public int getN2(int n)
	{
		LinkedList first=head;
		LinkedList second=head;
		int count=1;
		for(int i=1;i<n;i++)
		{
			if(first==null)
			{
				System.out.println("invalid index");
				return -1;
			}
			first=first.next;
		}
		if(first==null)
		{
			System.out.println("error");
		}
		while(first!=null && first.next!=null )
		{
			first=first.next;
			second=second.next;
		}
		return second.data;
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
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
}
