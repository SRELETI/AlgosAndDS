import javax.mail.internet.HeaderTokenizer;


public class MiddleStackList {
	private MiddleStack head;
	private MiddleStack mid;
	private int count;
	public MiddleStackList()
	{
		head=null;
		mid=null;
		count=0;
	}
	public void push(int value)
	{
		MiddleStack newNode = new MiddleStack(value);
		if(head==null)
		{
			newNode.next=head;
			newNode.prev=null;
			mid=newNode;
			head=newNode;
			count++;
		}
		else
		{
			newNode.next=head;
			count++;
			head.prev=newNode;
			newNode.prev=null;
			head=newNode;
			if(count%2==1)
				mid=mid.prev;
			
		}
	}
	public int pop()
	{
		int result=head.data;
		if(head.next==null)
		{
			head=null;
			mid=null;
			count--;
		}
		else
		{
			if(count%2==1)
				mid=mid.next;
			count--;
			head=head.next;
			head.prev=null;
		}
		return result;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public int getMiddle()
	{
		return mid.data;
	}
}
