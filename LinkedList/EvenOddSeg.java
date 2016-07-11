
public class EvenOddSeg {

	private PracticeDel head;
	private PracticeDel last;
	
	private PracticeDel temp;
	private PracticeDel temp_last;
	
	public EvenOddSeg()
	{
		head = null;
		last = null;
		temp = null;
		temp_last = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
		{
			head = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void insertion_new(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(temp==null)
		{
			temp = newNode;
		}
		else
			temp_last.next = newNode;
		temp_last = newNode;
	}
	
	public void evenOdd()
	{
		if(head ==null || head.next==null)
			return;
		PracticeDel new_head = head;
		while(head!=null && head.data%2!=0)
		{
			insertion_new(head.data);
			head = head.next;
		}
		if(head==null)
		{
			head= new_head;
			return;
		}
		
		PracticeDel cur = head;
		PracticeDel prev=null;
		while(cur!=null)
		{
			if(cur.data%2==1)
			{
				insertion_new(cur.data);
				cur= cur.next;
				prev.next = cur;
			}
			else
			{
				prev= cur;
				cur= cur.next;
			}
		}
		if(prev!=null)
			prev.next = temp;
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
		EvenOddSeg e = new EvenOddSeg();
	//	e.insertion(17);
	//	e.insertion(15);
	//	e.insertion(8);
	//	e.insertion(12);
	//	e.insertion(10);
	//	e.insertion(5);
	//	e.insertion(4);
		e.insertion(1);
		e.insertion(3);
	//	e.insertion(6);
		e.insertion(5);
		e.insertion(7);
		e.display(e.head);
		
		e.evenOdd();
		
		e.display(e.head);
	}
}
