
public class ReverseLK {

	private PracticeDel head;
	private PracticeDel headEnd;
	
	public ReverseLK()
	{
		head = null;
		headEnd = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode  = new PracticeDel(val);
		if(head == null)
		{
			head = newNode;
			headEnd = newNode;
		}
		else
		{
			headEnd.next = newNode;
			headEnd = newNode;
		}
	}
	
	public PracticeDel reverseK(PracticeDel temp, int k)
	{
		if(temp==null || temp.next==null)
			return temp;
		int count=0;
		PracticeDel prev= null;
		PracticeDel cur = temp;
		PracticeDel next = null;
		while(cur!=null && count<k)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur=next;
			count++;
		}
		if(next!=null)
			temp.next = reverseK(next,k);
		return prev;
	}
	
	public PracticeDel pairWise(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel cur = temp.next;
		PracticeDel prev = temp;
		temp = cur;
		while(true)
		{
			PracticeDel next = cur.next;
			cur.next = prev;
			if(next==null || next.next==null)
			{
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			cur = prev.next;
		}
		return temp;
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
	
	public static void main(String args[])
	{
		ReverseLK l = new ReverseLK();
		l.insertion(12);
		l.insertion(15);
		l.insertion(10);
		l.insertion(11);
		l.insertion(5);
		l.insertion(6);
		l.insertion(2);
		l.insertion(3);
		
		
		l.display(l.head);
	//	PracticeDel temp2 = l.reverseK(l.head, 3);
	//	PracticeDel temp2 = l.pairWise(l.head);	
	//	PracticeDel temp2 = l.reverseAlt(l.head, 3, true);
		PracticeDel temp2 = l.reverseDel(l.head);
		l.display(temp2);
	}
	
	public PracticeDel reverseAlt(PracticeDel temp, int k)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel cur = temp;
		PracticeDel prev = null;
		PracticeDel next = null;
		int count=0;
		while(cur!=null && count<k)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		if(temp!=null)
			temp.next = cur; 
		count = 0;
		while(cur!=null && count<k-1)
		{
			cur = cur.next;
			count++;
		}
		if(cur!=null)
			cur.next = reverseAlt(cur.next,k);
		return prev;
	}
	
	public PracticeDel reverseAlt(PracticeDel temp, int k, boolean result)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel cur = temp;
		PracticeDel prev = null;
		PracticeDel next = null;
		int count=0;
		while(cur!=null && count<k)
		{
			next = cur.next;
			if(result==true)
				cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		if(result == true)
		{
			temp.next = reverseAlt(cur,k,!result);
			return prev;
		}
		else
		{
			prev.next = reverseAlt(cur,k,!result);
			return temp;
		}
	}
	
	private PracticeDel reverse(PracticeDel temp)
	{
		if(temp==null || temp.next ==null)
			return temp;
		PracticeDel cur = temp;
		PracticeDel next = null;
		PracticeDel prev = null;
		while(cur!=null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur= next;
		}
		return prev;
	}
	
	public PracticeDel reverseDel(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel rev_temp = reverse(temp);
		PracticeDel temp2 = rev_temp;
		PracticeDel prev;
		int max = temp2.data;
		prev = temp2;
		temp2 = temp2.next;
		while(temp2!=null)
		{
			if(temp2.data<max)
			{
				temp2= temp2.next;
				prev.next = temp2;
				prev= prev.next;
			}
			else
			{
				max = temp2.data;
				prev =temp2;
				temp2 = temp2.next;
			}
		}
		return reverse(rev_temp);
	}
}
