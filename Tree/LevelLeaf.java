
public class LevelLeaf {

	
	public TreePrint head;
	
	public LevelLeaf()
	{
		head = null;
	}
	
	public void findLeaf()
	{
		int result = leaf(head,1);
		System.out.println(result);
	}
	
	private int leaf(TreePrint node, int level)
	{
		if(node == null)
			return 0;
		if(node.left == null && node.right == null && level%2==1)
			return level;
		
		return Math.max(leaf(node.left, level+1),leaf(node.right,level+1));
	}
	
}
