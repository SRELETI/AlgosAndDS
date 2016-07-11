
public class LevelTree {
	
	public TreePrint head;
	
	public LevelTree()
	{
		head = null;
	}
	
	public void getLevel(int value)
	{
		int result = level(head,value,1);
		System.out.println(result);
	}
	
	private int level(TreePrint node, int value, int level)
	{
		if(node == null)
			return 0;
		if(node.data == value)
			return level;
		int result = level(node.left,value,level+1);
		if(result!=0)
			return result;
		return level(node.right,value,level+1);
	}
}
