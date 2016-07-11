
public class DeepLeftNode {

	public TreePrint head;
	public TreePrint final_node;
	public DeepLeftNode()
	{
		head = null;
		final_node = null;
	}
	
	private class Wrapper
	{
		int value =0;
	}
	public void calc()
	{
		int level =0;
		Wrapper maxLevel= new Wrapper();
		
		findNode(head,level,maxLevel,false);
		
		System.out.println(final_node.data+" ");
	}
	
	private void findNode(TreePrint node, int level, Wrapper maxLevel, boolean isLeft)
	{
		if(node == null)
			return;
		if(isLeft == true && node.left == null && node.right == null && maxLevel.value<level)
		{
			final_node = node;
			maxLevel.value = level;
			return ;
		}
		findNode(node.left,level+1,maxLevel,true);
		findNode(node.right,level+1,maxLevel,false);
			
	}
}
