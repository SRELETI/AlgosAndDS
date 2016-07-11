
public class MergeLinkL {

	private PracticeDel head;
	private PracticeDel headEnd;
	private PracticeDel small1;
	private PracticeDel small1End;
	private PracticeDel small2;
	private PracticeDel small2End;
	public MergeLinkL()
	{
		head = null;
		headEnd = null;
		small1 = null;
		small1End = null;
		small2 = null;
		small2End = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head==null)
		{
			head = newNode;
			headEnd = newNode;
		}
		else
		{
			headEnd.next = newNode;;
			headEnd = newNode;
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
			small1End.next = newNode;;
			small1End = newNode;
		}
	}
	
	public void insertionSecond(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(small2==null)
		{
			small2 = newNode;
			small2End = newNode;
		}
		else
		{
			small2End.next = newNode;
			small2End = newNode;
		}
	}
	
	public void merge()
	{
		PracticeDel temp1 = small1;
		PracticeDel temp2 = small2;
		while(temp1!=null && temp2!=null)
		{
			if(temp1.data<temp2.data)
			{
				insertion(temp1.data);
				temp1 = temp1.next;
			}
			else
			{
				insertion(temp2.data);
				temp2 = temp2.next;
			}
		}
		while(temp1!=null)
		{
			insertion(temp1.data);
			temp1 = temp1.next;
		}
		while(temp2!=null)
		{
			insertion(temp2.data);
			temp2 = temp2.next;
		}
	}
	
	public PracticeDel merge_rec(PracticeDel temp1, PracticeDel temp2)
	{
		if(temp1==null)
			return temp2;
		if(temp2==null)
			return temp1;
		PracticeDel result;
		if(temp1.data<temp2.data)
		{
			result = temp1;
			result.next = merge_rec(temp1.next,temp2);
		}
		else
		{
			result = temp2;
			result.next = merge_rec(temp1,temp2.next);
		}
		return result;
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
		MergeLinkL m = new MergeLinkL();
		m.insertionFirst(1);
		m.insertionFirst(2);
		m.insertionFirst(3);
		
		m.insertionSecond(1);
		m.insertionSecond(2);
		m.insertionSecond(3);
		m.insertionSecond(4);
		
		System.out.println(m.isIdentical());
		System.out.println(m.isIdentical(m.small1, m.small2));
	//	m.merge();
	//	PracticeDel result = m.merge_rec(m.small1, m.small2);
	//	m.display(result);
	}
	
	public boolean isIdentical(PracticeDel temp1, PracticeDel temp2)
	{
		if(temp1==null && temp2==null)
			return true;
		if(temp1==null)
			return false;
		if(temp2==null)
			return false;
		if(temp1.data!=temp2.data)
			return false;
		return isIdentical(temp1.next,temp2.next);
	}
	public boolean isIdentical()
	{
		PracticeDel temp1 = small1;
		PracticeDel temp2 = small2;
		while(true)
		{
			if(temp1==null && temp2==null)
				return true;
			if(temp1==null)
				return false;
			if(temp2==null)
				return false;
			if(temp1.data!=temp2.data)
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
	}
}
