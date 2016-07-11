class Wrapper_sum {
	int count=0;
}
public class SumTree {


	private TreeInt root;
	
	public SumTree() {
		root = null;
	}
	
	public boolean isSumTree(TreeInt temp, Wrapper_sum s) {
		if(temp == null)
			return true;
		if(temp.left==null && temp.right==null)
		{
			s.count = temp.data;
			return true;
		}
		Wrapper_sum left_sum = new Wrapper_sum();
		Wrapper_sum right_sum = new Wrapper_sum();
		
		boolean left = isSumTree(temp.left,left_sum);
		boolean right = isSumTree(temp.right,right_sum);
		
		s.count = left_sum.count+right_sum.count+temp.data;
		if(temp.data!=left_sum.count+right_sum.count)
			return false;
		else
			return (left)&&(right);
	}
	
	public static void main(String args[]) {
		SumTree s = new SumTree();
		s.root = new TreeInt(26);
		s.root.left = new TreeInt(10);
		s.root.right = new TreeInt(3);
		s.root.left.left = new TreeInt(4);
		s.root.left.right = new TreeInt(7);
		s.root.right.right = new TreeInt(3);
		Wrapper_sum ss = new Wrapper_sum();
		System.out.println(s.isSumTree(s.root, ss));
	}
}
