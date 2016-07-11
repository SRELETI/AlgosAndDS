
public class ConvertTreetoLL_thr {

	private TreeInt root;
	private TreeInt head;
	private TreeInt prev;
	
	public ConvertTreetoLL_thr() {
		root = null;
		head = null;
		prev = null;

	}
	
	public void convert(TreeInt temp) {
		if(temp == null)
			return;
		convert(temp.left);
		
		if(prev==null)
			head= temp;
		else
		{
			temp.left = prev;
			prev.right = temp;
		}
		prev = temp;
		
		convert(temp.right);
	}
	
	public void display() {
		TreeInt temp = head;
		while(temp!=null) {
			temp.display();
			temp = temp.right;
		}
	}
	
	public static void main(String args[]) {
		ConvertTreetoLL_thr c = new ConvertTreetoLL_thr();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right =  new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		c.convert(c.root);
		c.display();
	}
	
}
