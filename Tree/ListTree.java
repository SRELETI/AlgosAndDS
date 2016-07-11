
public class ListTree {

	public int data;
	public ListTree next;
	
	public ListTree(int val) {
		data = val;
		next = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
