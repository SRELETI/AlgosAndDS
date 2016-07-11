
public class Middle {
	private PracticeDel head;
	public Middle()
	{
		head = null;
	}
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next= head;
		head = newNode;	
	}
	public void middle()
	{
		PracticeDel fast= head;
		PracticeDel slow = head;
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.data);
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
		Middle m = new Middle();
		m.insertion(4);
		m.insertion(5);
		m.insertion(6);
		m.insertion(7);
		m.display();
		m.middle();
		m.nthNode(1);
	}
	
	public void nthNode(int k)
	{
		PracticeDel temp = head;
		int count=0;
		while(count!=k)
		{
			temp = temp.next;
			if(temp==null)
			{
				System.out.println("No such node exists: ");
				return;
			}
			count++;
		}
	
		PracticeDel temp2 = head;
		while(temp!=null)
		{
			temp2= temp2.next;
			temp =temp.next;
		}
		System.out.println(temp2.data);
	}
}
