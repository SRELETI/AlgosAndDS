
public class LinkLatest {

	public int data;
	public LinkLatest next;
	
	public LinkLatest(int val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
