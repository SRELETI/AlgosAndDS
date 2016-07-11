
public class ConvertTreeToList {

	private TreeInt root;
	
	public ConvertTreeToList() {
		root = null;
	}
	
	public TreeInt convert(TreeInt temp) {
		if(temp==null)
			return null;
		TreeInt llist = convert(temp.left);
		TreeInt rlist = convert(temp.right);
		
		TreeInt last = findEnd(llist);
		llist = append(llist,last,temp);
		llist = append(llist,temp,rlist);
		return llist;
	}
	
	private TreeInt append(TreeInt start, TreeInt end, TreeInt second) {
		if(start==null)
			return second;
		if(second==null)
			return start;
		end.right = second;
		second.left = end;
		return start;
	}
	private void display(TreeInt temp) {
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
	}
	private TreeInt findEnd(TreeInt temp) {
		if(temp==null)
			return null;
		while(temp.right!=null)
			temp = temp.right;
		return temp;
		}
		
	public static void main(String args[]) {
		ConvertTreeToList c = new ConvertTreeToList();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(12);
		c.root.right = new TreeInt(15);
		c.root.left.left = new TreeInt(25);
		c.root.left.right = new TreeInt(30);
		c.root.right.left = new TreeInt(36);
		
		TreeInt temp  = c.convert(c.root);
	//	System.out.println(temp!=null ? temp.data : "null");
		c.display(temp);
	}
}
