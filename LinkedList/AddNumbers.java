import java.util.HashMap;


public class AddNumbers {

	private PracticeDel head;
	private PracticeDel last;
	
	private PracticeDel head2;
	private PracticeDel last2;
	
	private PracticeDel result;
	private PracticeDel res_last;
	
	public AddNumbers()
	{
		head=null;
		last = null;
		
		head2=null;
		last2=null;
		
		result = null;
		res_last = null;
	}
	
	private void insertion1(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
			head= newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	private void insertion2(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head2==null)
			head2 = newNode;
		else
			last2.next = newNode;
		last2 = newNode;
	}
	
	private void insertion3(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(result==null)
			result = newNode;
		else
			res_last.next = newNode;
		res_last = newNode;
	}
	public void addNumbers()
	{
		PracticeDel temp1 = head;
		PracticeDel temp2 = head2;
		int carry=0;
		int result=0;
		while(temp1!=null && temp2!=null)
		{
			result = carry + temp1.data+temp2.data;
			carry = result/10;
			insertion3(result%10);
			temp1=temp1.next;
			temp2=temp2.next;
		}
		while(temp1!=null)
		{
			result = carry +temp1.data;
			carry = result/10;
			insertion3(result%10);
			temp1= temp1.next;
		}
		while(temp2!=null)
		{
			result = carry+temp2.data;
			carry = result/10;
			insertion3(result%10);
			temp2 = temp2.next;
		}
		if(carry!=0)
			insertion3(carry);
	}
	
	public void union()
	{
		PracticeDel temp1= head;
		PracticeDel temp2 = head2;
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		while(temp1!=null)
		{
			if(h.containsKey(temp1.data)==false)
			{
				h.put(temp1.data, 1);
				insertion3(temp1.data);
			}
			temp1 = temp1.next;	
		}
		while(temp2!=null)
		{
			if(h.containsKey(temp2.data)==false)
			{
				h.put(temp2.data, 1);
				insertion3(temp2.data);
			}
			temp2 = temp2.next;
		}
	}
	
	public void intersection()
	{
		PracticeDel temp1=head;
		PracticeDel temp2 = head2;
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		while(temp1!=null)
		{
			if(h.containsKey(temp1.data)==false)
				h.put(temp1.data, 1);
			temp1 = temp1.next;
		}
		
		while(temp2!=null)
		{
			if(h.containsKey(temp2.data)==true)
				insertion3(temp2.data);
			temp2= temp2.next;
		}
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
		AddNumbers a= new AddNumbers();
		a.insertion1(10);
		a.insertion1(15);
	//	a.insertion1(9);
		a.insertion1(4);
		a.insertion1(20);
		
		a.insertion2(8);
		a.insertion2(4);
		a.insertion2(2);
		a.insertion2(10);
	//	a.insertion2(2);
		
	//	a.addNumbers();
		
	//	a.union();
		a.intersection();
		a.display(a.result);
		
	}
}

