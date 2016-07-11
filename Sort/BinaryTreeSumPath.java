
class Wrapper {
	int val = 0;
}
public class BinaryTreeSumPath {

	public void findPath(TreeInt root, int sum, Wrapper total_sum) {
		if(root==null)
			return;
		sum = sum*10+root.data;
		if(root.left==null && root.right==null) {
			total_sum.val +=sum;
			return;
		}
		findPath(root.left,sum,total_sum);
		findPath(root.right,sum,total_sum);
	}
	
	public static void main(String args[]) {
		BinaryTreeSumPath b = new BinaryTreeSumPath();
		TreeInt root = new TreeInt(1);
		root.left = new TreeInt(2);
		root.right = new TreeInt(3);
		root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(5);
		Wrapper result = new Wrapper();
		b.findPath(root, 0, result);
		System.out.println(result.val);
	}
}
