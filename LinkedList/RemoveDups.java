import java.util.HashMap;


public class RemoveDups {

	public PracticeDel head;
	
	public RemoveDups()
	{
		head =  null;
	}
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head;
		head = newNode;
	}
	public void removeDup() {
		if(head==null || head.next==null)
			return;
		PracticeDel temp = head;
		while(temp.next!=null)
		{
			if(temp.data==temp.next.data)
			{
				temp.next = temp.next.next;
			}
			else
				temp =temp.next;
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
	
	public void removeDupsUnsorted()
	{
		if(head == null || head.next==null)
			return;
		PracticeDel temp = head;
		PracticeDel prev = null;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		while(temp!=null)
		{
			if(h.containsKey(temp.data)==true)
			{
				prev.next = temp.next;
				temp = prev.next;
			}
			else
			{
				h.put(temp.data, 1);
				prev = temp;
				temp = temp.next;
			}
		}
			
	}
	public static void main(String args[])
	{
		RemoveDups r = new RemoveDups();
		r.insertion(12);
		r.insertion(11);
		r.insertion(12);
		r.insertion(21);
		r.insertion(41);
		r.insertion(43);
		r.insertion(21);
		r.display();
	//	r.removeDup();
		r.removeDupsUnsorted();
		r.display();
	}
}
