
public class ConvertTreeToLL {

	private TreeInt root;
	
	public ConvertTreeToLL() {
		root = null;
	}
	
	/* First method for converting a tree into LinkedList. 
	 * It runs in O(n2) time in worst case
	 */
	public TreeInt convert_first(TreeInt temp) {
		if(temp ==null)
			return null;
		TreeInt left = convert_first(temp.left);
		TreeInt right = convert_first(temp.right);
		TreeInt last;
		last = findLast(left);
		left = append(left,last,temp);
		left = append(left,temp,right);
		return left;
	}
	/* Helper methods for convert_first method
	 * 
	 */
	private TreeInt append(TreeInt start, TreeInt temp, TreeInt temp2) {
		if(temp==null)
			return temp2;
		if(temp2==null)
			return start;
		temp.right = temp2;
		temp2.left = temp;
		return start;
	}
	
	private TreeInt findLast(TreeInt temp){
		if(temp==null)
			return null;
		while(temp.right!=null)
			temp = temp.right;
		return temp;
	}
	
	/* method used for displaying the list 
	 * 
	 */
	private void display(TreeInt temp) {
		while(temp!=null) {
			temp.display();
			temp = temp.right;
		}
	}
	
	/* Main Method for the class
	 * 
	 */
	public static void main(String args[]) {
		ConvertTreeToLL c = new ConvertTreeToLL();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right = new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		TreeInt temp = c.convert_first(c.root);
		c.display(temp);
	}
}
