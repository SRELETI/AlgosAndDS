
public class LevelOrder {

	private TreeInt root;
	
	public LevelOrder() {
		root = null;
	}
	
	public void levelOrder(TreeInt temp) {
		if(temp == null)
			return;
		int height = getHeight(temp);
		for(int i=0;i<height;i++)
		{
			printTree(temp,0,i);
			System.out.println();
		}
	}
	
	
	private void printTree(TreeInt temp, int k, int size) {
		if(temp == null)
			return;
		if(k==size)
		{
			System.out.print(temp.data+" ");
			return;
		}
		printTree(temp.left,k+1,size);
		printTree(temp.right,k+1,size);
	}
	private int getHeight(TreeInt temp) {
		if(temp == null)
			return 0;
		return Math.max(getHeight(temp.left), getHeight(temp.right))+1;
	}
	
	public static void main(String args[]) {
		LevelOrder l = new LevelOrder();
		l.root = new TreeInt(1);
		l.root.left = new TreeInt(2);
		l.root.right = new TreeInt(3);
		l.root.left.left = new TreeInt(4);
		l.root.left.right = new TreeInt(5);
		
		l.levelOrder(l.root);
	}
	
}
