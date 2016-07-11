
public class QuickSortLL {

	private PracticeDel head;
	private PracticeDel last;
	
	public QuickSortLL()
	{
		head = null;
		last = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public PracticeDel quickSort(PracticeDel node)
	{
		if(node == null || node.next ==null)
			return node;
		PracticeDel pivot = partition(node);
		PracticeDel newhead = pivot;
		if(pivot!=node)
		{
			PracticeDel temp= node;
			PracticeDel temp2;
			newhead = temp;
			while(temp.next!=pivot)
				temp = temp.next;
			temp.next = null;
			temp2 = quickSort(newhead);
			newhead = temp2;
			while(temp2!=null && temp2.next!=null)
				temp2 = temp2.next;
			temp2.next = pivot;
		}
		pivot.next = quickSort(pivot.next);
		return newhead;
	}
	
	private PracticeDel partition(PracticeDel node)
	{
		PracticeDel temp = node;
		while(temp.next!=null)
			temp = temp.next;
		PracticeDel last = temp;
		PracticeDel second_temp = node;
		temp = node;
		while(temp!=null && temp!=last)
		{
			if(temp.data<last.data)
			{
				swap(temp,second_temp);
				second_temp = second_temp.next;
			}
			temp = temp.next;
		}
		swap(second_temp,last);
		return second_temp;
	}
	
	private void swap(PracticeDel temp, PracticeDel temp2)
	{
		int temp_data = temp.data;
		temp.data = temp2.data;
		temp2.data = temp_data;
	}
	
	public void display(PracticeDel temp)
	{
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		QuickSortLL q = new QuickSortLL();
		q.insertion(5);
		q.insertion(3);
		q.insertion(3);
		q.insertion(2);
		q.insertion(1);
		
		q.display(q.head);
		PracticeDel temp = q.quickSort(q.head);
		q.display(temp);
	}
}
