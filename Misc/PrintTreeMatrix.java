import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class PrintTreeMatrix {

	public void print(int[][] mat, TreeInt root,List<Integer> l) {
		if(root==null)
			return;
		l.add(root.data);
		print(mat,root.left,l);
		print(mat,root.right,l);
		l.remove(l.size()-1);
		Iterator<Integer> i = l.iterator();
		while(i.hasNext()) {
			mat[i.next()][root.data] = 1;
		}
	}
	
	public static void main(String args[]) {
		PrintTreeMatrix p = new PrintTreeMatrix();
		TreeInt root = new TreeInt(0);
		root.left = new TreeInt(1);
		root.right = new TreeInt(2);
		root.left.left = new TreeInt(3);
		root.left.right = new TreeInt(4);
		root.right.left = new TreeInt(5);
		root.right.right = new TreeInt(6);
		int[][] mat = new int[7][7];
		List<Integer> l = new ArrayList<Integer>();
		p.print(mat, root, l);
		System.out.println(Arrays.deepToString(mat));
	}
}
