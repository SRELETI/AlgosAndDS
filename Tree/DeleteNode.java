
public class DeleteNode {

	public TreePrint head;
	
	public DeleteNode()
	{
		head = null;
	}
	
	public void delete(int totalsum)
	{
	//	print(head);
		TreePrint node = deleteTree(head,totalsum);
		
		print(node);
	}
	
	private void print(TreePrint node)
	{
		if(node == null)
			return;
		print(node.left);
		System.out.print(node.data+" ");
		print(node.right);
	}
	
	private TreePrint deleteTree(TreePrint node, int sum)
	{
		if(node == null)
			return null;
		//int rsum = lsum;
		node.left = deleteTree(node.left,sum-node.data);
		node.right = deleteTree(node.right,sum-node.data);
	//	sum =Math.max(lsum, rsum);
		if(node.left == null && node.right == null)
		{
			if(node.data<sum)
				node = null;
		}
		return node;
	}
	
	
}
