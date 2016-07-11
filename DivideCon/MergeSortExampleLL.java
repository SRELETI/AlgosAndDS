class LinkNode2
{
	int val;
	LinkNode2 next;
	public LinkNode2(int data)
	{
		val = data;
		next = null;
	}
	public void display()
	{
		System.out.print(val+" ");
	}
}
public class MergeSortExampleLL {

	public LinkNode2 mergeSort(LinkNode2 head)
	{
		if(head == null || head.next==null)
			return head;
		LinkNode2 middle = getMiddle(head);
		
		LinkNode2 second = middle.next;
		middle.next=null;
		LinkNode2 first = head;
		first = mergeSort(first);
		second = mergeSort(second);
		return merge(first,second);
	}
	
	public LinkNode2 merge(LinkNode2 first, LinkNode2 second)
	{
		LinkNode2 final_list;
		if(first.val<second.val)
		{
			final_list = first;
			first = first.next;
		}
		else
		{
			final_list = second;
			second = second.next;
		}
		LinkNode2 temp = final_list;
		while(first!=null && second!=null)
		{
			if(first.val<second.val)
			{
				final_list.next= first;
				first = first.next;
				
			}
			else
			{
				final_list.next = second;
				second =second.next;
			}
			final_list = final_list.next;
		}
		
		while(first!=null)
		{
			final_list.next = first;
			first = first.next;
			final_list = final_list.next;
		}
		while(second!=null)
		{
			final_list.next = second;
			second = second.next;
			final_list = final_list.next;
		}
		return temp;
	}
	public LinkNode2 getMiddle(LinkNode2 temp)
	{
		LinkNode2 slow = temp;
		LinkNode2 fast = temp.next;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public void display(LinkNode2 temp)
	{
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
	}
	public static void main(String args[])
	{
		LinkNode2 head= new LinkNode2(15);
		LinkNode2 second = new LinkNode2(10);
		LinkNode2 third = new LinkNode2(5);
		LinkNode2 fourth = new LinkNode2(20);
		LinkNode2 fifth = new LinkNode2(3);
		LinkNode2 sixth = new LinkNode2(2);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next= sixth;
		
		MergeSortExampleLL m = new MergeSortExampleLL();
	//	m.display(head);
		head = m.mergeSort(head);
		m.display(head);
	}
}
