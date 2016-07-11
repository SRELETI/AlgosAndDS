
public class Sort012LL {

	private PracticeDel head;
	private PracticeDel last;
	
	public Sort012LL()
	{
		head= null;
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
	
	public void sortList()
	{
		if(head==null)
			return;
		int[] count = {0,0,0};
		PracticeDel temp = head;
		while(temp!=null)
		{
			count[temp.data]++;
			temp = temp.next;
		}
		
		temp = head;
		int i=0;
		while(temp!=null)
		{
			if(count[i]==0)
				i++;
			temp.data = i;
			count[i]--;
			temp = temp.next;
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
		Sort012LL s = new Sort012LL();
		s.insertion(2);
		s.insertion(1);
		s.insertion(2);
		s.insertion(1);
		s.insertion(1);
		s.insertion(2);
		s.insertion(0);
		s.insertion(1);
		s.insertion(0);
		
		s.display();
		
		s.sortList();
		
		s.display();
	}
}
