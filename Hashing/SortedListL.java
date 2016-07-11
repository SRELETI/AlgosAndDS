
public class SortedListL {

	private LinkL head;
	
	public SortedListL()
	{
		head = null;
	}
	
	public void insert(LinkL d )
	{
		LinkL prev = null;
		LinkL cur = head;
		while(cur!=null && cur.key<=d.key)
		{
			prev = cur;
			cur = cur.next;
		}
		if(prev == null)
		{
			head = d;
			return;
		}
		else
			prev.next = d;
		d.next = cur;
		
	}
	
	public void delete(int key)
	{
		LinkL prev = null;
		LinkL cur = head;
		while(cur!=null && cur.key!=key)
		{
			prev =cur;
			cur = cur.next;
		}
		if(prev == null)
			head = head.next;
		else
			prev.next = cur.next;
		
	}
	
	public LinkL find(int key)
	{
		LinkL cur = head;
		while(cur!=null && cur.key != key)
			cur =cur.next;
		if(cur!=null)
			return cur;
		else 
			return null;
	}
	
	public void display()
	{
		LinkL cur = head;
		while(cur!=null)
		{
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}
}
