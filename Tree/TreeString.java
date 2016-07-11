
public class TreeString {

	public String data;
	public TreeString left;
	public TreeString right;
	
	public TreeString(String val) {
		data = val;
		left = null;
		right = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
