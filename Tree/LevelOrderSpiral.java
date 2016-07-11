
public class LevelOrderSpiral {
	
	private TreePrint head;
	
	public LevelOrderSpiral()
	{
		head = null;
	}
	
	public void levelOrder(TreePrint node)
	{
		int h = height(node);
		boolean check = false;
		for(int i=1;i<=h;i++)
		{
			levelOrderSpiral(node,i,check);
			if(check==false)
				check = true;
			else
				check = false;
		}
	}
	
	public int height(TreePrint node)
	{
		if(node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		return (left>right ? left+1 : right+1);
	}
	
	public void levelOrderSpiral(TreePrint node,int count, boolean check)
	{
		if(node == null)
			return;
		if(count==1)
			System.out.print(node.data+ " ");
		if(check==false)
		{
			levelOrderSpiral(node.left,count-1,check);
			levelOrderSpiral(node.right,count-1,check);
		}
		else
		{
			levelOrderSpiral(node.right,count-1,check);
			levelOrderSpiral(node.left,count-1,check);
		}
	}
	
	public static void main(String args[])
	{
		LevelOrderSpiral lo = new LevelOrderSpiral();
		lo.head= new TreePrint(1);
		lo.head.left = new TreePrint(2);
		lo.head.right = new TreePrint(3);
		lo.head.left.left = new TreePrint(4);
		lo.head.left.right = new TreePrint(5);
		
		lo.levelOrder(lo.head);
	}
}
