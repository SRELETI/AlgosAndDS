import java.util.ArrayList;
import java.util.List;


public class LinkedListAdd {
	public LinkedList head;
	public LinkedListAdd()
	{
		head=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	public void addLast(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(isEmpty())
		{
			head=newNode;
		}
		else
		{
			LinkedList current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=newNode;
		}
	}
	public void addAfter(int after, int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(isEmpty())
		{
			System.out.println("The list is empty");
			return;
		}
		else
		{
			LinkedList current=head;
			while(current!=null)
			{
				if(current.data==after)
					break;
				current=current.next;
			}
			if(current!=null)
			{
				newNode.next=current.next;
				current.next=newNode;
			}
			else
			{
				System.out.println("The element is not found");
			}
		}
	}
	public boolean isEmpty()
	{
		return head==null;
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
}
