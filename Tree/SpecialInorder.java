
public class SpecialInorder {

	private TreeInt root;
	
	public SpecialInorder() {
		root = null;
	}
	
	public TreeInt build(int[] in, int start, int end) {
		if(start>end)
			return null;
		int max = findMax(in,start,end);
		TreeInt temp = new TreeInt(in[max]);
		if(start==end)
			return temp;
		temp.left = build(in,start,max-1);
		temp.right = build(in,max+1,end);
		return temp;
	}
	
	private int findMax(int[] in, int start, int end) {
		int max = start;
		for(int i=start+1;i<=end;i++)
		{
			if(in[i]>in[max])
				max = i;
		}
		return max;
	}
	
	public void inorder(TreeInt temp) {
		if(temp!=null){
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	
	public static void main(String args[]) {
		SpecialInorder s = new SpecialInorder();
		int[] in = {1, 5, 10, 40, 30, 15, 28, 20};
		TreeInt temp = s.build(in, 0, in.length-1);
		s.inorder(temp);
	}
}
