class Wrapper_Average {
	int sum = 0;
}
public class AverageCal {

	public TreeInt root;
	
	public int average() {
		Wrapper_Average total = new Wrapper_Average();
		int nodesCount = calAvg(root,total);
		return total.sum/nodesCount;
	}
	
	public int calAvg(TreeInt root, Wrapper_Average total) {
		if(root == null) {
			return 0;
		}
		total.sum +=root.data;
		if(root.left==null && root.right==null)  {
			return 1;
		}
		int left = calAvg(root.left,total);
		int right = calAvg(root.right,total);
		
		return left+right+1;
	}
	
	public static void main(String args[]) {
		AverageCal a = new AverageCal();
		a.root = new TreeInt(10);
		a.root.left = new TreeInt(6);
		a.root.right = new TreeInt(8);
		a.root.left.left = new TreeInt(2);
		a.root.left.right = new TreeInt(2);
		a.root.left.left.left = new TreeInt(4);
		a.root.right.left = new TreeInt(4);
		a.root.right.right = new TreeInt(4);
		System.out.println(a.average());
	}
}
