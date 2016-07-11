
public class GreaterElement {

	private PracticeDel head;
	private PracticeDel last;
	public GreaterElement()
	{
		head = null;
		last = null;
	}
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			last.next= newNode;
		}
		last = newNode;
	}
	
	public void greaterList()
	{
		if(head ==null || head.next==null)
			return;
		reverse();
		int max = head.data;
		PracticeDel prev = head;
		PracticeDel cur = head.next;
		while(cur!=null)
		{
			if(cur.data<max)
			{
				cur = cur.next;
				prev.next = cur;
			}
			else
			{
				max = cur.data;
				prev = cur;
				cur = cur.next;
			}
		}
		reverse();
	}
	
	private void reverse()
	{
		if(head==null || head.next ==null)
			return;
		PracticeDel cur=head;
		PracticeDel prev=null;
		PracticeDel next=null;
		while(cur!=null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
	}
	
	public void display()
	{
		PracticeDel temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		GreaterElement g = new GreaterElement();
		g.insertion(60);
		g.insertion(50);
		g.insertion(40);
		g.insertion(30);
		g.insertion(20);
		g.insertion(10);
	//	g.insertion(2);
	//	g.insertion(3);
		g.display();
		g.greaterList();
		g.display();
	}
}
