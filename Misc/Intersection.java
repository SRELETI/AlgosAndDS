
public class Intersection {

	private PracticeDel head1;
	private PracticeDel head2;
	private PracticeDel head3;
	public void intersection()
	{
		PracticeDel temp1 = head1;
		PracticeDel temp2 = head2;
		while(temp1!=null && temp2!=null)
		{
			if(temp1.data<temp2.data)
			{
				temp1 = temp1.next;
			}
			else if(temp2.data<temp1.data)
			{
				temp2 = temp2.next;
			}
			else
			{
				add(temp1.data);
				temp2= temp2.next;
				temp1 = temp1.next;
			}
		}

		display(head3);
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head1;
		head1= newNode;
	}
	public void insertion2(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head2;
		head2= newNode;
	}
	
	public void del()
	{
		PracticeDel temp = head1;
		while(temp!=null && temp.next!=null)
		{
			temp.next = temp.next.next;
			temp = temp.next;
		}
		display(head1);
	}
	
	public void del_rec(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return;
		temp.next = temp.next.next;
		del_rec(temp.next);
	}
	public void add(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head3;
		head3 = newNode;
	}
	
	private void display(PracticeDel temp)
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
		Intersection i = new Intersection();
		i.insertion(6);
		i.insertion(5);
		i.insertion(4);
		i.insertion(3);
		i.insertion(2);
		i.insertion(1);
	/*	
		i.insertion2(8);
		i.insertion2(6);
		i.insertion2(4);
		i.insertion2(2);
		*/
	//  i.display(i.head1);
	//	i.display(i.head2);
	//	i.intersection();
		i.del_rec(i.head1);
		i.display(i.head1);
	}
}
