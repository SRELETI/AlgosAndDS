
public class LinkedListDelete {
	private LinkedList head;
	public LinkedListDelete()
	{
		head=null;
	}
	public void delete(int key)
	{
		LinkedList current=head;
		LinkedList prev=null;
		while(current!=null)
		{
			if(current.data==key)
				break;
			prev=current;
			current=current.next;
		}
		if(prev==null)
		{
			int result=head.data;
			head=head.next;
		}
		else if(current==null)
		{
			System.out.println("The key not found to delete");
		}
		else
		{
			prev.next=current.next;
		}
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
	public int getN(int n)
	{
		int count=1;
		LinkedList current=head;
		while(current!=null)
		{
			if(count==n)
				break;
			current=current.next;
			count++;
		}
		if(current!=null)
			return current.data;
		else
			return -1;
	}
	
	public void reverse()
	{
		LinkedList prev, current, next;
		prev=null;
		current=head;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		if(prev!=null)
			head=prev;
	}
	
	public void reverse_rec(LinkedList cur)
	{
		if(cur==null)
			return;
		if(cur.next==null)
		{
			head=cur;
			return;
		}
		reverse_rec(cur.next);
		LinkedList p=cur.next;
		p.next=cur;
		cur.next=null;
		
	}
}
