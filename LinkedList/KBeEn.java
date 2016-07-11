
public class KBeEn {

	private PracticeDel head;
	
	public KBeEn() {
		head = null;
	}
	
	public void insertion(int val) {
		PracticeDel newNode = new PracticeDel(val);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			PracticeDel temp = head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next = newNode;
		}
	}
	
	public void swapData(int k) {
		if(head == null)
			return;
		int nodes = count(head);
		if(k>nodes)
			return;
		if(2*k-1==nodes)
			return;
		PracticeDel x_prev = null;
		PracticeDel x = head;
		int count=1;
		while(count<k)
		{
			x_prev = x;
			x = x.next;
			count++;
		}
		
		PracticeDel y_prev = null;
		PracticeDel y = head;
		count=1;
		while(count<=nodes-k)
		{
			y_prev = y;
			y = y.next;
			count++;
		}
		if(x_prev!=null)
			x_prev.next = y;
		if(y_prev!=null)
			y_prev.next = x;
		PracticeDel temp = x.next;
		x.next = y.next;
		y.next = temp;
		
		if(k==1)
			head = y;
		if(k==nodes)
			head = x;
	}
	
	private int count(PracticeDel temp) {
		if(temp == null)
			return 0;
		int count = 0;
		while(temp!=null)
		{
			count++;
			temp = temp.next;
		}
		return count;
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
		KBeEn k = new KBeEn();
		k.insertion(1);
		k.insertion(2);
		k.insertion(3);
		k.insertion(4);
		k.display();
		
		k.swapData(4);
		k.display();
	}

}
