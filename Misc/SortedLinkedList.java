
public class SortedLinkedList {
	private SortedList first;
	public SortedLinkedList()
	{
		first=null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insert(int data)
	{
		SortedList newNode=new SortedList(data);
		SortedList previous=null;
		SortedList current=first;
		while(current!=null && data>current.data)
		{
			previous=current;
			current=current.next;
		}
		if(previous==null)
			first=newNode;
		else
			previous.next=newNode;
		newNode.next=current;
	}
	public void delete()
	{
		if(isEmpty())
		{
			System.out.println("No Elements to delete");
			return;
		}
		SortedList temp=first;
		first=first.next;
	}
	public void display()
	{
		SortedList current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}
