
public class LevelOfNode {

	private TreeInt root;
	
	public LevelOfNode() {
		root = null;
	}
	
	public int level(TreeInt temp, int k,int key) {
		if(temp == null)
			return -1;
		if(temp.data == key)
		{
			return k;
		}
		int val = -1;
		val = level(temp.left,k+1,key);
		if(val!=-1)
			return val;
		val = level(temp.right,k+1,key);
		return val;
	}
	
	public static void main(String args[]) {
		LevelOfNode l = new LevelOfNode();
		l.root = new TreeInt(3);
		l.root.left = new TreeInt(2);
		l.root.right = new TreeInt(5);
		l.root.left.left = new TreeInt(1);
		l.root.left.right = new TreeInt(4);
		
		System.out.println(l.level(l.root, 1, 2));
	}
}
