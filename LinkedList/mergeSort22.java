
public class mergeSort22 {
	private LinkedList head;
	private LinkedList last;
	private LinkedList first;
	private LinkedList second;
	
	public mergeSort22()
	{
		head=null;
		last =null;
		first=null;
		second=null;
	}
	
	public void insert(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(first==null)
		{
			first = newNode;
		}
		else
		{
			newNode.next=first;
			first=newNode;
		}
	}
	
	public int remove()
	{
		int result= first.data;
		first=first.next;
		return result;
	}
	
	public void display()
	{
		LinkedList current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void insert2(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(second==null)
		{
			second=newNode;
		}
		else
		{
			newNode.next=second;
			second=newNode;
		}
	}
	
	public int remove2()
	{
		int result = second.data;
		second=second.next;
		return result;
	}
	
	public void display2()
	{
		LinkedList current = second;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void insert3( int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(head==null)
		{
			head=newNode;
			last=newNode;
		}
		else
		{
			last.next=newNode;
			last=newNode;
		}
	}
	
	public int remove3()
	{
		int result = head.data;
		head=head.next;
		return result;
	}
	
	public void display3()
	{
		LinkedList current = head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void merge()
	{
		LinkedList temp1= first;
		LinkedList temp2 = second;
		while(temp1!=null && temp2 !=null)
		{
			if(temp1.data==temp2.data)
			{
				insert3(temp1.data);
				temp1= temp1.next;
				temp2= temp2.next;
			}
			else if(temp1.data<temp2.data)
			{
				insert3(temp1.data);
				temp1=temp1.next;
			}
			else
			{
				insert3(temp2.data);
				temp2=temp2.next;
			}
		}
		while(temp1!=null)
		{
			insert3(temp1.data);
			temp1=temp1.next;
		}
		while(temp2!=null)
		{
			insert3(temp2.data);
			temp2=temp2.next;
		}
		display3();
	}
}
