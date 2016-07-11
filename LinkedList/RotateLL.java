
public class RotateLL {

	private PracticeDel head;
	private PracticeDel last;
	
	public RotateLL()
	{
		head = null;
		last = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
		{
			head = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void rotate(int k)
	{
		if(head == null)
			return;
		PracticeDel temp = head;
		int count = 0;
		while(temp!=null && count<k)
		{
			 temp = temp.next;
			 count++;
		}
		if(temp==null)
		{
			System.out.println("K is larger than the length of list: ");
			return;
		}
		PracticeDel new_head = temp.next;
		temp.next = null;
		PracticeDel last;
		temp = new_head;
		while(new_head!=null && temp.next!=null)
		{
			temp = temp.next;
		}
		if(temp!=null)
		{
			temp.next = head;
			head = new_head;
			return;
		}
	}
	public void display()
	{
		PracticeDel temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		RotateLL r = new RotateLL();
		r.insertion(10);
		r.insertion(20);
		r.insertion(30);
		r.insertion(40);
		r.insertion(50);
		r.insertion(60);
		r.display();
		r.rotate(4);
		r.display();
	}
}
