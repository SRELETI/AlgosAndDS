class Wrapper {
	int count = 0;
}

public class CountLeafNodes {

	private TreeInt root;
	
	public CountLeafNodes() {
		root = null;
	}
	
	
	public int countLeafs(TreeInt temp)
	{
		if(temp == null)
			return 0;
		if(temp.left==null && temp.right==null)
		{
			return 1;
		}
		return countLeafs(temp.left)+
		countLeafs(temp.right);
	}
	
	public static void main(String args[]) {
		CountLeafNodes c = new CountLeafNodes();
		c.root = new TreeInt(1);
		c.root.left = new TreeInt(2);
		c.root.right = new TreeInt(3);
		c.root.left.left = new TreeInt(4);
		c.root.left.right = new TreeInt(5);
		Wrapper s = new Wrapper();
		System.out.println(c.countLeafs(c.root));
	}
}
