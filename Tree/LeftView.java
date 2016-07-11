class Wrapper_level_max {
	int level = Integer.MIN_VALUE;
}
public class LeftView {

	private TreeInt root;
	
	public LeftView() {
		root = null;
	}
	
	public void leftView(TreeInt temp,Wrapper_level_max max, int level) {
		if(temp == null)
			return;
		if(level>max.level)
		{
			max.level = level;
			temp.display();
		}
		leftView(temp.left,max,level+1);
		leftView(temp.right,max,level+1);
	}

	
	public void rightView(TreeInt temp,Wrapper_level_max max, int level) {
		if(temp == null)
			return;
		if(level>max.level)
		{
			max.level = level;
			temp.display();
		}
		rightView(temp.right,max,level+1);
		rightView(temp.left,max,level+1);
	}
	
	
	public static void main(String args[]) {
		LeftView l = new LeftView();
		l.root = new TreeInt(12);
		l.root.left = new TreeInt(10);
		l.root.right = new TreeInt(30);
		l.root.right.left = new TreeInt(25);
		l.root.right.right = new TreeInt(40);
		Wrapper_level_max max = new Wrapper_level_max();
		l.leftView(l.root, max, 0);
		max.level=Integer.MIN_VALUE;
		System.out.println();
		l.rightView(l.root, max, 0);
	}
}
