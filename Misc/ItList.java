
public class ItList {
	private ItLink first;
	public ItList()
	{
		first=null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insert(int data)
	{
		ItLink newNode=new ItLink(data);
		newNode.next=first;
		first=first.next;
	}
	public void delete()
	{
		if(isEmpty())
		{
			System.out.println("The list is empty");
			return;
		}
		first=first.next;
	}
	public ItLink getFirst()
	{
		return first;
	}
	public void setFirst(ItLink lin)
	{
		first=lin;
	}
	public ListIterator getIterator()
	{
		return new ListIterator(this);
	}
	public void display()
	{
		ItLink current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}
