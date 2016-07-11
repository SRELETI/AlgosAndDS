
public class CheckBST {

	public boolean isBST(TreeInt node) {
		return isBSTUtils(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean isBSTUtils(TreeInt node, int min, int max) {
		if(node==null) {
			return true;
		}
		if(node.data<min || node.data>max)
			return false;
		if(isBSTUtils(node.left,min,node.data-1) && isBSTUtils(node.right,node.data+1,max))
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		CheckBST c = new CheckBST();
		TreeInt temp = new TreeInt(6);
		temp.left = new TreeInt(3);
		temp.right = new TreeInt(8);
		temp.left.left = new TreeInt(2);
		temp.left.left.left = new TreeInt(10);
		temp.left.right = new TreeInt(5);
		temp.left.right.left = new TreeInt(4);
		temp.right.right = new TreeInt(9);
		
		System.out.println(c.isBST(temp));
	}
}
