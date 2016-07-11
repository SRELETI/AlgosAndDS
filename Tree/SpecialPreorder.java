class Wrapper_preBuild {
	int index = 0;
}
public class SpecialPreorder {

	private TreeInt root;
	
	public SpecialPreorder() {
		root = null;
	}
	
	public TreeInt build(int[] pre,char LN[], Wrapper_preBuild m) {
		if(m.index == pre.length)
			return null;
		int index = m.index;
		TreeInt temp = new TreeInt(pre[m.index++]);
		if(LN[index]=='L')
			return temp;
		else
		{
			temp.left = build(pre,LN,m);
			temp.right = build(pre,LN,m);
		}
		return temp;
	}
	public void inorder(TreeInt temp) {
		if(temp!=null) {
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	public static void main(String args[]) {
		SpecialPreorder s = new SpecialPreorder();
		int[] pre = {10,30,20,5,15};
		char[] LN = {'N','N','L','L','L'};
		Wrapper_preBuild m = new Wrapper_preBuild();
		TreeInt temp = s.build(pre, LN, m);
		s.inorder(temp);
	}
}
