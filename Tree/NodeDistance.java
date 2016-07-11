
public class NodeDistance {

	public TreePrint head;
	
	public NodeDistance()
	{
		head = null;
	}
	
	private class Wrapper
	{
		int dist1 = -1;
		int dist2 = -1;
		int final_dist =0;
	}
	public void nodeDis(int value1, int value2)
	{
		int level=0;
		Wrapper h = new Wrapper();
		TreePrint node = consLCA(head,value1,value2,h, level);
		
		if(h.dist1 !=-1 && h.dist2!=-1)
		{
			System.out.println(h.final_dist);
			return;
		}
		if(h.dist1!= -1)
		{
			h.final_dist = find(node,0,value2);
			System.out.println(h.final_dist);
			return;
		}
		if(h.dist2 !=-1)
		{
			h.final_dist = find(node,0,value1);
			System.out.println(h.final_dist);
			return;
		}
	}
	
	private int find(TreePrint node, int level, int value)
	{
		if(node == null)
			return 0;
		if(node.data == value)
			return level;
		
		int left=-1; 
		left= find(node.left,level+1,value);
		if(left!=-1)
			return left;
		return find(node.right,level+1,value);
	}
	
	private TreePrint consLCA(TreePrint node, int value1, int value2, Wrapper h, int level)
	{
		if(node == null)
			return null;
		
		if(node.data == value1)
		{
			h.dist1 = level;
			return node;
		}
		if(node.data == value2)
		{
			h.dist2 = level;
			return node;
		}
		
		TreePrint left = consLCA(node.left, value1,value2,h,level+1);
		TreePrint right = consLCA(node.right,value1,value2,h,level+1);
		
		if(left!=null && right!=null)
		{
			h.final_dist = h.dist1+h.dist2 - 2*level;
			return node;
		}
		return left !=null ? left:right; 
	}
	
}
