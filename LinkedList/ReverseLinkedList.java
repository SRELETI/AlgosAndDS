import java.util.ArrayList;
import java.util.List;


public class ReverseLinkedList {
	public LinkedList head;
	private LinkedList cur;
	public ReverseLinkedList()
	{
		head=null;
		cur=head;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	public void display()
	{
		
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	public void delete()
	{
		if(head==null)
			return;
		int result=deleteFront();
	//	head=head.next;
		delete();
		System.out.print(result+" -> ");
	}
	public int deleteFront()
	{
		if(head==null)
		{
			System.out.println("The list is empty");
			return -1;
		}
		int result=head.data;
		head=head.next;
		return result;
	}
	
	public void reverse()
	{
		LinkedList current,prev,next;
		current=head;
		prev=null;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		if(prev!=null)
			head=prev;
	}
	public void reverse_rec(LinkedList cur)
	{
		if(cur==null)
		{
			return;
		}
		if(cur.next==null)
		{
			head=cur;
			return;
		}
		reverse_rec(cur.next);
		LinkedList temp = cur.next;
		temp.next=cur;
		cur.next=null;
	}
}
