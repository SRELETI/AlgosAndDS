
public class MergeLinkedList {
	private LinkedList head;
	private LinkedList second;
	private LinkedList result;
	private LinkedList last;
	public MergeLinkedList()
	{
		head=null;
		second=null;
		result=null;
		last=null;
	}
	
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	
	public void addFront2(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=second;
		second=newNode;
	}
	
	public void add(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(result==null)
		{
			result=newNode;
			last=newNode;
		}
		else
		{
			last.next=newNode;
			last=newNode;
		}
	}
	public void mergeLists()
	{
		LinkedList head_current=head;
		LinkedList second_current=second;
		while(head_current!=null && second_current!=null)
		{
			if(head_current.data==second_current.data)
			{
				add(head_current.data);
				head_current = head_current.next;
				second_current = second_current.next;
			}
			else if(head_current.data<second_current.data)
			{
				add(head_current.data);
				head_current=head_current.next;
			}
			else
			{
				add(second_current.data);
				second_current = second_current.next;
			}
		}
		while(head_current!=null)
		{
			add(head_current.data);
			head_current=head_current.next;
		}
		while(second_current!=null)
		{
			add(second_current.data);
			second_current = second_current.next;
		}
	}
	public void display()
	{
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void display2()
	{
		LinkedList current=second;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void display_res()
	{
		LinkedList current=result;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}

