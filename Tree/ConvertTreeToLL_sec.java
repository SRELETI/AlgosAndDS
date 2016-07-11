
public class ConvertTreeToLL_sec {

	private TreeInt root;
	private TreeInt prev;
	
	public ConvertTreeToLL_sec() {
		root = null;
		prev = null;
	}
	
	/* method for converting tree to list
	 * 
	 */
	public TreeInt convert(TreeInt temp) {
		convertPrev(temp);
		return convertNext(temp);
	}
	
	/* helper method for connecting the left links
	 * 
	 */
	
	public void convertPrev(TreeInt temp) {
		if(temp==null)
			return;
		convertPrev(temp.left);
		temp.left = prev;
		prev = temp;
		convertPrev(temp.right);
	}
	
	/* Helper method for connecting the right links 
	 * 
	 */
	public TreeInt convertNext(TreeInt temp) {
		while(temp!=null && temp.right!=null)
			temp = temp.right;
		prev = null;
		while(temp!=null && temp.left!=null)
		{
			prev = temp;
			temp= temp.left;
			temp.right = prev;
		}
		return temp;
	}
	
	/* method for displaying the list
	 * 
	 */
	public void display(TreeInt temp) {
		while(temp!=null) {
			temp.display();
			temp = temp.right;
		}
	}
	
	/* main method for the class
	 * 
	 */
	public static void main(String args[]) {
		ConvertTreeToLL_sec c = new ConvertTreeToLL_sec();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right = new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		TreeInt temp = c.convert(c.root);
		c.display(temp);
	}
}
