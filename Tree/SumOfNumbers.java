class Wrapper_sum_total {
	int val=0;
}
public class SumOfNumbers {

	private TreeInt root;
	
	public SumOfNumbers() {
		root = null;
	}
	
	public int sum(TreeInt temp, int sum) {
		if(temp == null)
			return 0;
		sum = sum*10+temp.data;
		if(temp.left==null && temp.right==null)
		{
			return sum;
		}
		return sum(temp.left,sum)+sum(temp.right,sum);
	}
	
	public static void main(String args[]) {
		SumOfNumbers s = new SumOfNumbers();
		s.root = new TreeInt(6);
		s.root.left = new TreeInt(3);
		s.root.right = new TreeInt(5);
		s.root.left.left = new TreeInt(2);
		s.root.left.right = new TreeInt(5);
		s.root.left.right.left = new TreeInt(7);
		s.root.left.right.right = new TreeInt(4);
		s.root.right.right = new TreeInt(4);
		Wrapper_sum_total t = new Wrapper_sum_total();
		System.out.println(s.sum(s.root, 0));
	//	System.out.println(t.val);
		
	}

}
