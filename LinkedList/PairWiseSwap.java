
public class PairWiseSwap {

	private PracticeDel head;
	
	public PairWiseSwap()
	{
		head = null;
	}
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head;
		head = newNode;
	}
	
	public void swap()
	{
		if(head==null || head.next==null)
			return;
		PracticeDel temp = head;
		while(temp!=null && temp.next!=null)
		{
			int temp2 =temp.data;
			temp.data =temp.next.data;
			temp.next.data = temp2;
			
			temp = temp.next.next;
		}
	}
	
	public void display(PracticeDel temp2)
	{
		PracticeDel temp = temp2;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	
	public PracticeDel swap_rec(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		int temp2 = temp.data;
		temp.data = temp.next.data;
		temp.next.data = temp2;
		swap_rec(temp.next.next);
		return temp;
	}
	
	public void swap_links()
	{
		if(head==null || head.next==null)
			return ;
		PracticeDel prev = head;
		PracticeDel cur = head.next;
		head = cur;
		while(true)
		{
			PracticeDel next = cur.next;
			cur.next=prev;
			if(next==null || next.next==null)
			{
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			cur = prev.next;
		}
	}
	
	public PracticeDel rec_swap_links(PracticeDel temp)
	{
		if(temp==null || temp.next==null)
			return temp;
		PracticeDel prev = temp;
		PracticeDel cur = temp.next;
		temp = cur;
		PracticeDel next = cur.next;
		cur.next = prev;
		if(next==null || next.next ==null)
		{
			prev.next = next;
			return temp;
		}
		prev.next = next.next;
		rec_swap_links(next);
		return temp;
	}
	public static void main(String args[])
	{
		PairWiseSwap p = new PairWiseSwap();
		p.insertion(5);
		p.insertion(4);
		p.insertion(3);
		p.insertion(2);
		p.insertion(1);
		p.display(p.head);
	//	p.swap();
	//	PracticeDel tel= p.swap_rec(p.head);
	//	p.swap_links();
		PracticeDel tel = p.rec_swap_links(p.head);
		p.display(tel);
		p.display(tel);
	}
}
