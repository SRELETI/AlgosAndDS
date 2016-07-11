
public class SortedIntersection {
	public LinkedList first;
	public LinkedList second;
	public LinkedList result;
	public SortedIntersection()
	{
		first=null;
		second=null;
		result=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=first;
		first=newNode;
	}
	
	public void addFront2(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=second;
		second=newNode;
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
	
	public void sortedInt()
	{
		LinkedList first_temp=first;
		LinkedList second_temp=second;
		while(first_temp!=null && second_temp!=null)
		{
			if(first_temp.data==second_temp.data)
			{
				addLast(first_temp.data);
				first_temp=first_temp.next;
				second_temp=second_temp.next;
			}
			else if(first_temp.data<second_temp.data)
			{
				first_temp=first_temp.next;
			}
			else
				second_temp=second_temp.next;
		}
	}
	
	public void sorted_rec(LinkedList first_list, LinkedList second_list, LinkedList result_list)
	{
		if(first_list==null || second_list==null)
			return;
		if(first_list.data==second_list.data)
		{
			addLast(first_list.data);
			sorted_rec(first_list.next, second_list.next, result);
		}
		else if(first_list.data<second_list.data)
		{
			sorted_rec(first_list.next,second_list,result);
		}
		else
			sorted_rec(first_list, second_list.next, result);
	}
	
	public void addLast(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(isEmpty())
		{
			result=newNode;
		}
		else
		{
			LinkedList current=result;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=newNode;
		}
	}
	
	public boolean isEmpty()
	{
		return result==null;
	}
	
	public void display_result()
	{
		LinkedList current=result;
		while(current!=null)
		{
			current.display();
			System.out.print("->");
			current=current.next;
		}
		System.out.println();
	}
}
