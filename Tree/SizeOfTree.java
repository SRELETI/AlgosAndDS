
public class SizeOfTree {

	private TreeInt root;
	
	public SizeOfTree() {
		root = null;
	}
	
	public int size(TreeInt temp) {
		if(temp == null)
			return 0;
		if(temp.left == null && temp.right == null)
			return 1;
		return size(temp.left)+1+size(temp.right);
	}
	
	public static void main(String args[]) {
		SizeOfTree s = new SizeOfTree();
		s.root = new TreeInt(1);
		s.root.left = new TreeInt(2);
		s.root.right = new TreeInt(3);
		s.root.left.left = new TreeInt(4);
		s.root.right.left = new TreeInt(5);
		
		System.out.println(s.size(s.root));
	}
}
