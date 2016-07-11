
public class SumOddEven {

	private TreeInt root;
	
	public SumOddEven() {
		root = null;
	}
	
	public int sumOddEven(TreeInt temp) {
		if(temp == null)
			return 0;
		return temp.data - sumOddEven(temp.left) - sumOddEven(temp.right);
	}
	public static void main(String args[]) {
		SumOddEven s = new SumOddEven();
		s.root = new TreeInt(5);
		s.root.left = new TreeInt(2);	
		s.root.right = new TreeInt(6);
		s.root.left.left = new TreeInt(1);
		s.root.left.right = new TreeInt(4);
		s.root.left.right.left = new TreeInt(3);
		s.root.right.right = new TreeInt(8);
		s.root.right.right.left = new TreeInt(7);
		s.root.right.right.right = new TreeInt(9);
		
		System.out.println(s.sumOddEven(s.root));
	}
}
