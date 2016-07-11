
public class MergeSortLL {

	//references to the lists
	private PracticeDel head1;
	private PracticeDel head1End;
	private PracticeDel small1;
	private PracticeDel small1End;
	
	//Constructor
	public MergeSortLL()
	{
		head1=null;
		small1=null;
	
		
		head1End = null;
		small1End = null;
	
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head1==null)
		{
			head1 = newNode;
			head1End = newNode;
		}
		else
		{
			head1End.next = newNode;
			head1End = newNode;
		}
	}
	public void insertionFirst(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(small1==null)
		{
			small1 = newNode;
			small1End = newNode;
		}
		else
		{
			small1End.next = newNode;
			small1End = newNode;
		}
	}
	
	
	public PracticeDel mergeSort(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel mid = getMiddle(temp);
		PracticeDel second = mid.next;
		mid.next = null;
		temp = mergeSort(temp);
		second =mergeSort(second);
		return merge(temp,second);
	}
	public PracticeDel mergeSort_rec(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel mid = getMiddle(temp);
		PracticeDel second = mid.next;
		mid.next = null;
		temp = mergeSort_rec(temp);
		second =mergeSort_rec(second);
		return merge_asc(temp,second);
	}
	private PracticeDel getMiddle(PracticeDel temp)
	{
		PracticeDel slow = temp;
		PracticeDel fast = temp.next;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	private PracticeDel merge_asc(PracticeDel temp, PracticeDel temp2)
	{
		if(temp==null && temp2==null)
			return null;
		if(temp==null)
		{
			head1= temp2;
			return head1;
		}
		if(temp2==null)
		{
			head1= temp;
			return head1;
		}
		
		if(temp.data>temp2.data)
		{
			head1 = temp;
			temp = temp.next;
		}
		else
		{
			head1 = temp2;
			temp2= temp2.next;
		}
		PracticeDel temp3 = head1;
		while(temp!=null && temp2!=null)
		{
			if(temp.data>temp2.data)
			{
				temp3.next = temp;
				temp3 = temp3.next;
				temp = temp.next;
			}
			else
			{
				temp3.next = temp2;
				temp3 = temp3.next;
				temp2 = temp2.next;
			}
		}
		
		while(temp!=null)
		{
			temp3.next = temp;
			temp = temp.next;
			temp3 = temp3.next;
		}
		while(temp2!=null)
		{
			temp3.next = temp2;
			temp2 = temp2.next;
			temp3 = temp3.next;
		}
	//	display(head1);
		return head1;
	}
	
	private PracticeDel merge(PracticeDel temp, PracticeDel temp2)
	{
		if(temp==null && temp2==null)
			return null;
		if(temp==null)
		{
			head1= temp2;
			return head1;
		}
		if(temp2==null)
		{
			head1= temp;
			return head1;
		}
		
		if(temp.data<temp2.data)
		{
			head1 = temp;
			temp = temp.next;
		}
		else
		{
			head1 = temp2;
			temp2= temp2.next;
		}
		PracticeDel temp3 = head1;
		while(temp!=null && temp2!=null)
		{
			if(temp.data<temp2.data)
			{
				temp3.next = temp;
				temp3 = temp3.next;
				temp = temp.next;
			}
			else
			{
				temp3.next = temp2;
				temp3 = temp3.next;
				temp2 = temp2.next;
			}
		}
		
		while(temp!=null)
		{
			temp3.next = temp;
			temp = temp.next;
			temp3 = temp3.next;
		}
		while(temp2!=null)
		{
			temp3.next = temp2;
			temp2 = temp2.next;
			temp3 = temp3.next;
		}
		return head1;
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
		MergeSortLL m = new MergeSortLL();
		m.insertionFirst(3);
		m.insertionFirst(2);
		m.insertionFirst(20);
		m.insertionFirst(5);
		m.insertionFirst(10);
		m.insertionFirst(15);
		m.display(m.small1);
		PracticeDel temp = m.mergeSort(m.small1);
		
		m.display(temp);
	}
}
