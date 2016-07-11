
public class NMLL {

	private PracticeDel head;
	private PracticeDel last;
	
	public NMLL() {
		head = null;
		last = null;
	}
	
	public void insertion(int val) {
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void removeList(int m, int n)
	{
		if(head == null)
			return;
		PracticeDel cur =head;
		PracticeDel temp;
		int count;
		int count2;
		while(cur!=null)
		{
			count=m;
			count2=n;
			while(count>1 && cur!=null)
			{
				cur = cur.next;
				count--;
			}
			if(cur==null)
				return;
			temp = cur.next;
			while(count2>0 && temp!=null)
			{
				temp = temp.next;
				count2--;
			}
			if(temp==null)
			{
				cur.next = null;
				return;
			}
			cur.next = temp;
			cur = cur.next;
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
		NMLL n = new NMLL();
		n.insertion(1);
		n.insertion(2);
		n.insertion(3);
		n.insertion(4);
		n.insertion(5);
		n.insertion(6);
		n.insertion(7);
		n.insertion(8);
		n.insertion(9);
		n.insertion(10);
		
		n.display();
		n.removeList(1, 1);
		n.display();
	}
}

