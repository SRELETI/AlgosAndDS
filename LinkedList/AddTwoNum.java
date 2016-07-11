
public class AddTwoNum {

	private PracticeDel head;
	private PracticeDel last;
	
	private PracticeDel head1;
	private PracticeDel last1;
	
	public AddTwoNum()
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
	class Wrapper
	{
		int carry=0;
	}
	private int getSize(PracticeDel temp)
	{
		int size=0;
		while(temp!=null)
		{
			temp = temp.next;
			size++;
		}
		return size;
	}
	
	private void swap(PracticeDel temp, PracticeDel temp2)
	{
		PracticeDel tt = temp;
		temp = temp2;
		temp2 = tt;
	}
	
	private PracticeDel addNumbers_rec(PracticeDel temp, PracticeDel temp2, Wrapper s)
	{
		PracticeDel result = new PracticeDel(0);
		if(temp==null && temp2==null)
			return null;
		result.next = addNumbers_rec(temp.next,temp2.next,s);
		int sum = temp.data+temp2.data+s.carry;
		s.carry = sum/10;
		sum = sum%10;
		result.data = sum;
		return result;
	}
	public PracticeDel addNum()
	{
		PracticeDel result;
		if(head==null)
		{
			result = head;
			return result;
		}
		else if(head1==null)
		{
			result = head1;
			return result;
		}
		else
		{
			int size1 = getSize(head);
			int size2 = getSize(head1);
			Wrapper s = new Wrapper();
			if(size1==size2)
				result = addNumbers_rec(head, head1,s);
			else
			{
				int diff = Math.abs(size1-size2);
				PracticeDel cur;
				if(size1<size2)
				{
					swap(head,head1);
				}
					cur = head;
					while(diff>0)
					{
						cur = cur.next;
						diff--;
					}
					
					result = addNumbers_rec(cur,head1,s);
					result = addRemain(head,cur,result,s);
			}
			if(s.carry!=0)
			{
				result = addFront(s,result);
			}
		}
		return result;
			
	}
	
	private PracticeDel addFront(Wrapper s, PracticeDel result)
	{
		PracticeDel newNode = new PracticeDel(s.carry);
		newNode.next = result;
		result = newNode;
		return result;
	}
	
	private PracticeDel addRemain(PracticeDel actual, PracticeDel newAc, PracticeDel result, Wrapper s)
	{
		if(actual==newAc)
			return result;
		else
		{
			int sum = 0;
			PracticeDel res = addRemain(actual.next,newAc,result,s);
			sum = actual.data+s.carry;
			s.carry = sum/10;
			sum = sum%10;
			PracticeDel newNode = new PracticeDel(sum);
			newNode.next = res;
			res = newNode;
			return res;
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
		AddTwoNum a = new AddTwoNum();
		a.insertion(9);
		a.insertion(9);
		a.insertion(9);
		
		a.insertion2(1);
		a.insertion2(8);
	//	a.insertion2(2);
		
	//	a.display(a.head);
	//	a.display(a.head1);
		PracticeDel temp = a.addNum();
		a.display(temp);
		
	}
			
}
