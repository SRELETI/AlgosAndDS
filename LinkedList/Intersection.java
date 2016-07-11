
public class Intersection {
	public LinkedList first;
	public LinkedList second;
	public Intersection()
	{
		first=null;
		second=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=first;
		first=newNode;
	}
	public void addSecond(int value)
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
	}
	public void addLast(int value)
	{
		LinkedList newNode = new LinkedList(value);
		/*if(isEmpty())
		{
			first=newNode;
		}
		else*/
		{
			LinkedList current=first;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=newNode;
		}
	}
	public void display_second()
	{
		LinkedList current=second;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	public int intersectionFind()
	{
		LinkedList current_outer=first;
		LinkedList current_inner;
		while(current_outer!=null)
		{
			current_inner=second;
			while(current_inner!=null)
			{
				if(current_outer==current_inner)
					return current_outer.data;
				current_inner=current_inner.next;
			}
			current_outer=current_outer.next;
		}
		return -1;
	}
	public int intersection2()
	{
		LinkedList current_first=first;
		LinkedList current_second=second;
		int counter1=0;
		int counter2=0;
		while(current_first!=null)
		{
			counter1++;
			current_first=current_first.next;
		}
		while(current_second!=null)
		{
			counter2++;
			current_second=current_second.next;
		}
		int result=Math.abs(counter1-counter2);
		current_first=first;
		current_second=second;
		if(counter1>counter2)
		{
			for(int i=0;i<result;i++)
				current_first=current_first.next;
		}
		else if(counter1<counter2)
		{
			for(int i=0;i<result;i++)
				current_second=current_second.next;
		}
		while(current_first !=null && current_second !=null)
		{
			if(current_first==current_second)
				return current_first.data;
			current_first=current_first.next;
			current_second=current_second.next;
		}
		return -1;
	}
	public void printReverse()
	{
		if(first==null)
			return;
		int result=first.data;
		first=first.next;
		printReverse();
		System.out.print(result+"-> ");
	}
}
