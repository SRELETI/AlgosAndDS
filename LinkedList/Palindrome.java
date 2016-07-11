import java.util.Stack;


public class Palindrome {
	private LinkedList head;
	private Stack<Integer> box;
	private LinkedList secondHalf;
	private boolean result=false;
	public Palindrome()
	{
		head=null;
		box=new Stack<Integer>();
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	
	public void sortedInsert(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(head==null)
		{
			head=newNode;
			return;
		}
		if(value<head.data)
		{
			newNode.next=head;
			head=newNode;
			return;
		}
		LinkedList current=head;
		while(current.next!=null)
		{
			if(current.next.data>value)
			{
				newNode.next=current.next;
				current.next=newNode;
				return;
			}
			current=current.next;
		}
		current.next=newNode;
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
	public boolean isPalindrome()
	{
		LinkedList current=head;
		while(current!=null)
		{
			box.push(current.data);
			current=current.next;
		}
		current=head;
		while(!box.isEmpty())
		{
			if(box.pop()==current.data)
			{
				current=current.next;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public boolean isPalindrome2()
	{
		LinkedList slow=head;
		LinkedList fast=head;
		LinkedList prev_of_slow=null;
		LinkedList midnode=null;
		if(head==null || head.next==null)
			return result;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			prev_of_slow=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null)
		{
			midnode=slow;
			slow=slow.next;
		}
		secondHalf=slow;
		prev_of_slow.next=null;
		reverse(secondHalf);
		result=compareLists(head,secondHalf);
		reverse(secondHalf);
		if(midnode!=null)
		{
			prev_of_slow.next=midnode;
			midnode.next=secondHalf;
		}
		else
			prev_of_slow.next=secondHalf;
		return result;
	}
	public void reverse(LinkedList sample)
	{
		if(sample.next==null)
		{
			secondHalf=sample;
			return;
		}
		reverse(sample.next);
		LinkedList temp=sample.next;
		temp.next=sample;
		sample.next=null;
	}
	public boolean compareLists(LinkedList temp1, LinkedList temp2)
	{
		while(temp1!=null && temp2 !=null)
		{
			if(temp1.data==temp2.data)
			{
				temp1=temp1.next;
				temp2=temp2.next;
			}
			else
				return false;
		}
		return true;
	}
}
