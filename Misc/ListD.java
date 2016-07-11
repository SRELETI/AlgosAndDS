
public class ListD {
	private LinkD first;
	private LinkD last;
	public ListD()
	{
		last=null;
		first=null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insertFirst(int data)
	{
		LinkD newNode=new LinkD(data);
		if(isEmpty())
		{
			last=newNode;
		}
		else
		{
			first.prev=newNode;
			newNode.next=first;
		}
		first=newNode;
	}
	public void insertLast(int data)
	{
		LinkD newNode=new LinkD(data);
		if(isEmpty())
		{
			first=newNode;
		}
		else
		{
			last.next=newNode;
			newNode.prev=last;
		}
		last=newNode;
	}
	public void deleteFirst()
	{
		LinkD result=first;
		if(first.next==null)
			last=null;
		else
			first.next.prev=null;
		first=first.next;
		System.out.println("The deleted element is "+ result.data);
	}
	public void deleteLast()
	{
		LinkD result=last;
		if(last.prev==null)
			first=null;
		else
			last.prev.next=null;
		last=last.prev;
		System.out.println("The deleted element is "+result.data);
	}
	public void display()
	{
		LinkD current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}

