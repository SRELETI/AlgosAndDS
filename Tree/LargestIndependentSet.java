
public class LargestIndependentSet {

	public TreeInt root;
	
	public LargestIndependentSet() {
		root = null;
	}
	
	public int largestSet(TreeInt temp) {
		if(temp==null)
			return 0;
		int excl = largestSet(temp.left) + largestSet(temp.right);
		
		int incl = 1;
		if(temp.left!=null)
			incl = incl+ largestSet(temp.left.left)+largestSet(temp.left.right);
		if(temp.right!=null)
			incl = incl + largestSet(temp.right.left) + largestSet(temp.right.right);
		return Math.max(incl, excl);
	}
	
	public static void main(String args[]){
		LargestIndependentSet l = new LargestIndependentSet();
		
		l.root = new TreeInt(10);
		l.root.left = new TreeInt(20);
		l.root.right = new TreeInt(30);
		l.root.left.left = new TreeInt(40);
		l.root.left.right = new TreeInt(50);
		l.root.left.right.left = new TreeInt(70);
		l.root.left.right.right = new TreeInt(80);
		l.root.right.right = new TreeInt(60);
		
		System.out.println(l.largestSet(l.root));
	}
}
