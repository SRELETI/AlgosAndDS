
public class NthEndLatest {
	public LinkLatest head;
	public void nthEnd(int n) {
		LinkLatest temp = head;
		int count = n;
		while(count>0 && temp!=null) {
			temp = temp.next;
			count--;
		}
		if(temp==null && count!=0)
		{
			System.out.println("Invalid Input ");
			return;
		}
		LinkLatest temp2 = head;
		while(temp!=null) {
			temp = temp.next;
			temp2 = temp2.next;
		}
		System.out.println(temp2==null ? "null":temp2.data);
	}
	
	public static void main(String args[]) {
		NthEndLatest n = new NthEndLatest();
		n.head  = new LinkLatest(1);
		n.head.next = new LinkLatest(2);
		n.head.next.next = new LinkLatest(3);
		n.nthEnd(2);
	}
}
