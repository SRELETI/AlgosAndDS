
public class SpecialStackMidList {
	private SpecialStackMid head;
	private SpecialStackMid mid;
	private int count;
	public SpecialStackMidList()
	{
		head=null;
		mid=null;
		count=0;
	}
	
	public void push(int value)
	{
		SpecialStackMid newNode = new SpecialStackMid(value);
		if(head==null)
		{
			head=newNode;
			mid=newNode;
			count++;
			return;
		}
		else
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
			count++;
			if(count%2==1)
			{
				mid=mid.prev;
			}
		}
	}
	
	public int pop()
	{
		if(head.next==null)
		{
			int result=head.data;
			head=null;
			mid=null;
			count--;
			return result;
		}
		int result=head.data;
		head=head.next;
		head.prev=null;
		count--;
		if(count%2==0)
		{
			mid=mid.next;
		}
		return result;
	}
	
	public int middle()
	{
		if(head==null)
			return -1;
		return mid.data;
	}
	
	public void display()
	{
		SpecialStackMid current = head;
		while(current!=null)
		{
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	public int deleteMiddle()
	{	
		int result=mid.data;
		SpecialStackMid temp=mid;
		if(count==1)
		{
			head=null;
			mid=null;
			return result;
		}
		if(count==2)
		{
			mid=head;
			mid.next=null;
			return result;
		}
		if(count%2==0)
		{	
			mid=mid.prev;
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			count--;
		}
		else
		{
			mid=mid.next;
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			count--;
		}
		return result;
	}
}
