
public class IdenticalLists {
	private LinkedList head;
	private LinkedList second;
	private LinkedList result;
	public IdenticalLists()
	{
		head=null;
		second=null;
		result=null;
	}
	
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	
	public void addFront2(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=second;
		second=newNode;
	}
	
	public boolean check()
	{
		LinkedList first_cur = head;
		LinkedList second_cur = second;
		while(first_cur !=null && second_cur !=null)
		{
			if(first_cur.data==second_cur.data)
			{
				first_cur=first_cur.next;
				second_cur=second_cur.next;
			}
			else
				return false;
		}
		if(first_cur!=null || second_cur !=null)
			return false;
		return true;
	}
	public void display()
	{
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void display2()
	{
		LinkedList current=second;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}
