class Wrapper_preIndex {
	int index=0;
}
public class SpecialPrePost {

	private TreeInt construct(int[] pre, int[] post, int start, int end, Wrapper_preIndex in) {
		if(start>end)
			return null;
		TreeInt temp = new TreeInt(pre[in.index++]);
		if(start==end)
			return temp;
		int index = findIndex(post,pre[in.index],start,end);
		
		temp.left = construct(pre,post,start,index,in);
		temp.right = construct(pre,post,index+1,end-1,in);
		return temp;
	}
	
	private int findIndex(int[] post, int val, int start, int end) {
		for(int i=start;i<=end;i++)
		{
			if(post[i]==val)
				return i;
		}
		return -1;
	}
	
	private void inorder(TreeInt temp) {
		if(temp!=null) {
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	public static void main(String args[]) {
		SpecialPrePost s = new SpecialPrePost();
		int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
		int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		Wrapper_preIndex in = new Wrapper_preIndex();
		TreeInt temp = s.construct(pre, post, 0, pre.length-1, in);
		s.inorder(temp);
	}
}
