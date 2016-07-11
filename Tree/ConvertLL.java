
public class ConvertLL {

	private TreeInt root;
	private TreeInt head;
	private TreeInt prev;
	public ConvertLL () {
		head = null;
		root = null;
		prev = null;
	}
	
	public TreeInt convertNow(TreeInt temp)
	{
		convertLeft(temp);
		return convertRight(temp);
	}
	
	private void convertLeft(TreeInt temp) {
		if(temp==null)
			return;
		convertLeft(temp.left);
		temp.left = prev;
		prev = temp;
		convertLeft(temp.right);
	}
	
	private TreeInt convertRight(TreeInt temp) {
		while(temp!=null && temp.right!=null)
			temp = temp.right;
		prev = null;
		while(temp!=null && temp.left!=null)
		{
			prev = temp;
			temp = temp.left;
			temp.right = prev;
		}
		return temp;
	}
	
	public void convert(TreeInt temp) {
		if(temp==null)
			return;
		convert(temp.left);
		if(prev==null)
			head = temp;
		else
		{
			temp.left = prev;
			prev.right = temp;
		}
		prev = temp;
		convert(temp.right);
	}
	
	private void display() {
		TreeInt temp = head;
		while(temp!=null) {
			temp.display();
			temp = temp.right;
		}
	}
	public static void main(String args[]) {
		ConvertLL c = new ConvertLL();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right = new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		c.head = c.convertNow(c.root);
	//	c.convert(c.root);
		c.display();
	}
}
