import java.util.ArrayList;
import java.util.List;


public class PathSumII {

	private List<List<Integer>> l = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeInt root, int sum) {
		if(root == null)
			return l;
		List<Integer> ll = new ArrayList<Integer>();
		findPath(root,sum,ll);
		return l;
	}
	
	private void findPath(TreeInt root, int sum, List<Integer> ll) {
		if(root == null)
			return;
		ll.add(root.data);
		if(root.left==null && root.right==null && sum==root.data)
		{
			l.add(new ArrayList<Integer>(ll));
		}
		else
		{
			findPath(root.left,sum-root.data,ll);
			findPath(root.right,sum-root.data,ll);
		}
		ll.remove(ll.size()-1);
	}
	
	public static void main(String args[]) {
		PathSumII s = new PathSumII();
		TreeInt root = new TreeInt(5);
		root.left = new TreeInt(4);
		root.right = new TreeInt(8);
		root.left.left = new TreeInt(11);
		root.left.left.left = new TreeInt(7);
		root.left.left.right = new TreeInt(2);
		root.right.left = new TreeInt(13);
		root.right.right = new TreeInt(4);
		root.right.right.right = new TreeInt(1);
		root.right.right.left = new TreeInt(5);
		
		List<List<Integer>> l = s.pathSum(root, 22);
		System.out.println(l);
	}
}
