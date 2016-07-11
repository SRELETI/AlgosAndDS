
public class AlternateSplit {

	private PracticeDel head;
	private PracticeDel headEnd;
	private PracticeDel small1;
	private PracticeDel small1End;
	private PracticeDel small2;
	private PracticeDel small2End;
	public AlternateSplit()
	{
		head = null;
		headEnd = null;
		small1 = null;
		small2 = null;
		small1End = null;
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
	public void split()
	{
		if(head == null)
		{
			return;
		}
		if(head.next==null)
		{
			insertionFirst(head.data);
			return;
		}
		PracticeDel temp = head;
		while(temp!=null)
		{
			insertionFirst(temp.data);
			if(temp.next!=null)
			{
				temp = temp.next;
				insertionSecond(temp.data);
				
			}
			temp = temp.next;
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
		AlternateSplit as = new AlternateSplit();
		as.insertion(0);
		as.insertion(1);
		as.insertion(0);
		as.insertion(1);
		as.insertion(0);
		as.insertion(1);
		as.display(as.head);
		as.split();
		as.display(as.small1);
		as.display(as.small2);
	}
}
