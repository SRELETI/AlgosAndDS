class Wrapper_pre {
	int index = 0;
}
public class InorderPre {

	public TreeInt order(int[] pre, int[] in, Wrapper_pre preIndex,int start, int end) {
		if(start>end)
			return null;
		int temp = pre[preIndex.index];
		TreeInt root = new TreeInt(temp);
		preIndex.index = preIndex.index+1;
		if(start==end)
			return root;
		int index = findIn(in, temp, start, end);
		root.left = order(pre,in,preIndex,start,index-1);
		root.right = order(pre,in,preIndex,index+1,end);
		return root;
	}
	
	private int findIn(int[] in, int val, int start, int end) {
		for(int i=start;i<=end;i++) {
			if(in[i]==val)
				return i;
		}
		return -1;
	}
	
	public void inorder(TreeInt temp) {
		if(temp == null)
			return;
		inorder(temp.left);
		temp.display();
		inorder(temp.right);
	}
	public static void main(String args[]) {
		InorderPre i = new InorderPre();
		int[] in = {4,2,5,1,6,3};
		int[] pre = {1,2,4,5,3,6};
		Wrapper_pre preIndex = new Wrapper_pre();
		TreeInt temp = i.order(pre, in, preIndex, 0, in.length-1);
		i.inorder(temp);
	}
}
