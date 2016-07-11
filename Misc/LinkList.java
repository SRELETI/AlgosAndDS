
public class LinkList {
	public Link first;
	public LinkList()
	{
		first=null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insertFirst(int data,long data1)
	{
		Link newNode1=new Link(data,data1);
		newNode1.next=first;
		first=newNode1;
	}
	public Link deleteFirst()
	{
		if(isEmpty())
			return first;
		Link temp=first;
		first=first.next;
		return temp;
	}
	public void display()
	{
		Link current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	public void find(int key)
	{
		Link current=first;
		while(current!=null)
		{
			if(current.data==key)
			{
				System.out.println("Key found");
				return;
			}
			current=current.next;
		}
		System.out.println("key not found");
	}
	public void deleteKey(int data)
	{
		Link current=first;
		while(current.next!=null)
		{
			if(current.next.data==data)
			{
				current.next=current.next.next;
				return;
			}
			else
			{
				current=current.next;
			}
		}
		System.out.println("Key not found");
	}
	public void insertAfter(int key,int data, long dat)
	{
		Link current=first;
		Link newNode1=new Link(data,dat);
		while(current!=null)
		{
			if(current.data==key)
			{
				newNode1.next=current.next;
				current.next=newNode1;
				return;
			}
			current=current.next;
		}
	}
}
