
public class ConvertTreeList {

	public TreeInt root;
	public TreeInt prev = null;
	public ConvertTreeList() {
		root = null;
	}
	
	public TreeInt convert(TreeInt temp) {
		fixPrev(temp);
		return fixNext(temp);
	}
	
	private void fixPrev(TreeInt temp) {
		if(temp!=null)
		{
			fixPrev(temp.left);
			temp.left=prev;
			prev = temp;
			fixPrev(temp.right);
		}
	}
	
	private TreeInt fixNext(TreeInt temp) {
		while(temp!=null && temp.right!=null)
			temp = temp.right;
		while(temp!=null && temp.left!=null)
		{
			prev = temp;
			temp = temp.left;
			temp.right = prev;
		}
		return temp;
	}
	
	public void displayList(TreeInt temp) {
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		ConvertTreeList c = new ConvertTreeList();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right = new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		TreeInt temp = c.convert(c.root);
		c.displayList(temp);
	}
}
