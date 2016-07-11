
public class ReverseLinkedListExample {
	public LinkNode2 newHead;
	public LinkNode2 reverse(LinkNode2 head)
	{
		if(head == null || head.next==null)
		{
			newHead = head;
			return head;
		}
		LinkNode2 cur = head;
		LinkNode2 temp = reverse(head.next);
		cur.next=null;
		temp.next = cur;
		return cur;
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
		LinkNode2 l = new LinkNode2(5);
		LinkNode2 sec = new LinkNode2(4);
		LinkNode2 thr = new LinkNode2(3);
		LinkNode2 fou = new LinkNode2(2);
		LinkNode2 fif = new LinkNode2(1);
		
		l.next = sec;
		sec.next = thr;
		thr.next = fou;
		fou.next = fif;
		
		ReverseLinkedListExample r = new ReverseLinkedListExample();
		r.display(l);
		r.reverse(l);
		r.display(r.newHead);
	}
}
