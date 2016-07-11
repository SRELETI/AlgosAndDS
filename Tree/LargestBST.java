class Wrapper_values {
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	int size = 0;
	boolean isBST=false;
}
public class LargestBST {

	public int largest(TreeInt root,Wrapper_values complete) {
		if(root==null) {
			complete.isBST= true;
			return 0;
		}
		int min ;
		boolean left= false, right = false;
		int l,r;
		complete.max=Integer.MIN_VALUE;
		l = largest(root.left,complete);
		if(complete.isBST==true && complete.max<root.data) {
			left = true;
		}
		min = complete.min;
		complete.min= Integer.MAX_VALUE;
		r = largest(root.right,complete);
		if(complete.isBST==true && complete.min>root.data) {
			right = true;
		}
		if(min<complete.min) {
			complete.min = min;
		}
		if(root.data<complete.min)
			complete.min= root.data;
		if(root.data>complete.max)
			complete.max = root.data;
		if(left==true && right==true) {
			complete.isBST = true;
			if(l+r+1>complete.size) 
				complete.size = l+r+1;
			return l+r+1;
		}
		return 0;
	}
	
	public static void main(String args[]) {
		LargestBST l = new LargestBST();
		TreeInt root = new TreeInt(50);
		root.left = new TreeInt(10);
		root.right = new TreeInt(60);
		root.left.left = new TreeInt(5);
		root.left.right = new TreeInt(20);
		root.right.left = new TreeInt(55);
		root.right.right = new TreeInt(70);
		root.right.left.left = new TreeInt(45);
		root.right.right.left = new TreeInt(65);
		root.right.right.right = new TreeInt(80);
		
		Wrapper_values complete = new Wrapper_values();
		l.largest(root, complete);
		System.out.println(complete.size);
	}
}
