
public class ListIterator {
	private ItLink current;
	private ItLink previous;
	private ItList ourList;
	public ListIterator(ItList lis)
	{
		ourList=lis;
		reset();
	}
	public void reset()
	{
		current=ourList.getFirst();
		previous=null;
	}
	public boolean atEnd()
	{
		return current.next==null;
	}
	public void nextLink()
	{
		previous=current;
		current=current.next;
	}
	public ItLink getCurrent()
	{
		return current;
	}
	public void insertAfter(int data)
	{
		ItLink newNode=new ItLink(data);
		if(ourList.isEmpty())
		{
			ourList.setFirst(newNode);
			current=newNode;
		}
		else
		{
			newNode.next=current.next;
			current.next=newNode;
			nextLink();
		}
	}
	public void insertBefore(int data)
	{
		ItLink newNode=new ItLink(data);
		if(previous==null)
		{
			newNode.next=ourList.getFirst();
			ourList.setFirst(newNode);
			reset();
		}
		else
		{
			newNode.next=previous.next;
			previous.next=newNode;
			current=newNode;
		}
	}
	public void deleteCurrent(int data)
	{
		if(previous==null)
		{
			ourList.setFirst(current.next);
			reset();
		}
		else
		{
			previous.next=current.next;
			if(atEnd())
			{
				reset();
			}
			else
			{
				current=current.next;
			}
		}
	}
	
}
