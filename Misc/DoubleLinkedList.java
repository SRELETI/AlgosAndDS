
public class DoubleLinkedList {
	private DoubleList first;
	private DoubleList last;
	public DoubleLinkedList()
	{
		first=null;
		last=null;
	}
	public void traverseForward()
	{
		DoubleList current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	public void traverseBackward()
	{
		DoubleList current=last;
		while(current!=null)
		{
			current.display();
			current=current.prev;
		}
		System.out.println();
	}
	public void insertionFirst(int data)
	{
		DoubleList newNode=new DoubleList(data);
		if(isEmpty())
			last=newNode;
		else
		{
			first.prev=newNode;
		}
		newNode.next=first;
		first=newNode;
	}
	public void insertionLast(int data)
	{
		DoubleList newNode=new DoubleList(data);
		if(isEmpty())
			first=newNode;
		else
			newNode.prev=last;
		last.next=newNode;
		last=newNode;
	}
	public void insertAfter(int key,int data)
	{
		DoubleList newNode=new DoubleList(data);
		DoubleList current=first;
		while(current!=null)
		{
			if(current==last)
			{
				newNode.next=null;
				last=newNode;
				newNode.prev=current;
				current.next=newNode;
				return;
			}
			if(current.data==key)
			{
				newNode.next=current.next;
				current.next.prev=newNode;
				newNode.prev=current;
				current.next=newNode;
				return;
			}
			current=current.next;
		}
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void deleteFirst()
	{
		if(first.next==null)
			last=null;
		first=first.next;
		first.prev=null;
	}
	public void deleteLast()
	{
		if(last.prev==null)
			first=null;
		else
			last.prev.next=null;
		last=last.prev;
	}
	public void deleteKey(int data)
	{
		DoubleList current=first;
		while(current.data!=data)
		{
			if(current==null)
				return;
			current=current.next;
		}
		if(current==first)
			first=current.next;
		else
			current.prev.next=current.next;
		if(current==last)
			last=current.prev;
		else
			current.next.prev=current.prev;
	}
	
}


