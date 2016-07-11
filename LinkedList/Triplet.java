
public class Triplet {

	private PracticeDel head;
	private PracticeDel last;
	
	private PracticeDel head2;
	private PracticeDel last2;
	
	private PracticeDel head3;
	private PracticeDel last3;
	
	public Triplet()
	{
		head = null;
		last = null;
		
		head2 = null;
		last2 = null;
		
		head3 = null;
		last3 = null;
		
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void insertion2(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head2==null)
			head2 = newNode;
		else
			last2.next = newNode;
		last2 = newNode;
	}
	
	public void insertion3(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head3==null)
			head3 = newNode;
		else
			last3.next = newNode;
		last3 = newNode;
	}
	public void triplet(int sum)
	{
		if(head==null || head2==null || head3==null)
			return;
		MergeSortLL l = new MergeSortLL();
		PracticeDel temp2 ;
		PracticeDel temp3 ;
		temp2 = l.mergeSort(head2);
		temp3 = l.mergeSort_rec(head3);
		display(temp2);
		display(temp3);
		PracticeDel temp1 = head;
		while(temp1!=null)
		{	
			PracticeDel inner_temp2 = temp2;
			PracticeDel inner_temp3 = temp3;
			while(inner_temp2!=null & inner_temp3!=null)
			{
				if(temp1.data+inner_temp2.data+inner_temp3.data==sum)
				{
					System.out.println("The sum is found: "+temp1.data+" "+inner_temp2.data+" "+inner_temp3.data);
					return;
				}
				else if(temp1.data+inner_temp2.data+inner_temp3.data<sum)
					inner_temp2 = inner_temp2.next;
				else
					inner_temp3 = inner_temp3.next;
			}
			temp1 = temp1.next;
		}
		
		
		System.out.println("No triplet found: ");
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
		Triplet t = new Triplet();
		t.insertion(12);
		t.insertion(6);
		t.insertion(29);
		
		t.insertion2(23);
		t.insertion2(5);
		t.insertion2(8);
		
		t.insertion3(90);
		t.insertion3(20);
		t.insertion3(59);
		
		t.triplet(101);
	}
}
