
public class ReverseLL {

	private PracticeDel head;
	private PracticeDel reverse_temp;
	
	public ReverseLL()
	{
		head = null;
		reverse_temp = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head;
		head = newNode;
	}
	
	public PracticeDel reverse()
	{
		PracticeDel prev = null;
		PracticeDel cur = head;
		PracticeDel next;
		while(cur!=null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public void display(PracticeDel temp)
	{
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	
	public PracticeDel reverse_rec(PracticeDel temp)
	{
		if(temp == null)
			return null;
		if(temp.next ==null)
		{
			reverse_temp = temp;
			return temp;
		}
		PracticeDel temp2 = reverse_rec(temp.next);
		temp2.next = temp;
		temp.next =null;
		return temp;
	}
	public static void main(String args[])
	{
		ReverseLL l = new ReverseLL();
		l.insertion(20);
		l.insertion(4);
		l.insertion(15);
		l.insertion(85);
		
		l.display(l.head);
	//	PracticeDel temp = l.reverse();
	//	l.display(temp);
		l.reverse_rec(l.head);
		l.display(l.reverse_temp);
	}
 }
