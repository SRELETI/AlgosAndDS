
public class MergeTwoL {

	private PracticeDel head;
	private PracticeDel last;
	private PracticeDel head1;
	private PracticeDel last1;
	
	public MergeTwoL()
	{
		head = null;
		last = null;
		head1 = null;
		last1 = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void insertion2(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head1 == null)
			head1 = newNode;
		else
			last1.next = newNode;
		last1 = newNode;
	}
	
	public void mergeLists()
	{
		if(head==null || head1==null)
			return;
		PracticeDel temp = head;
		PracticeDel temp1 = head1;
		
		PracticeDel temp_next;
		PracticeDel temp1_next;
		while(temp!=null && temp1!=null)
		{
			temp_next = temp.next;
			temp1_next = temp1.next;
			
			temp1.next = temp.next;
			temp.next = temp1;
			
			temp = temp_next;
			temp1 = temp1_next;
		}
		head1 = temp1;
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
		MergeTwoL m = new MergeTwoL();
		m.insertion(1);
		m.insertion(2);
		m.insertion(3);
		
		m.insertion2(4);
		m.insertion2(5);
		m.insertion2(6);
		m.insertion2(7);
		m.insertion2(8);
		
		m.mergeLists();
		
		m.display(m.head);
		m.display(m.head1);
	}
}
