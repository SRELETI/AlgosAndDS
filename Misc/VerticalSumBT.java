import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VerticalSumBT {

	public TreePrint head;
	
	public VerticalSumBT(TreePrint node)
	{
		head = null;
	}
	
	public void VerticalSum(TreePrint node)
	{
		if(node == null)
			return;
		int lhd =0;
		int rhd =0;
		TreePrint temp = node;
		while(temp.left!=null)
		{
			lhd= lhd -1;
			temp = temp.left;
		}
		temp = node;
		while(temp.right!=null)
		{
			rhd = rhd +1;
			temp = temp.right;
		}
	//	System.out.println(lhd+" "+rhd);
		
		for(int i=lhd;i<=rhd;i++)
		{
			print(node,i,0);
			System.out.println();
		}
	}
	
	private void print(TreePrint node, int hd, int level)
	{
		if(node == null)
			return;
		if(level==hd)
		{
			System.out.print(node.data+" ");
		}
		print(node.left,hd,level-1);
		print(node.right,hd,level+1);
	}
	
	
	public void construct(TreePrint node)
	{
		if(node == null)
			return;
		
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		
		vertical(node,h,0);
		if(h.entrySet()!=null)
			System.out.println(h.entrySet());
	}
	
	private void vertical(TreePrint node, HashMap<Integer, Integer> h, int level)
	{
		if(node!=null)
		{
			
			
			vertical(node.left,h,level-1);
			
			
			
			vertical(node.right,h,level+1);
			
			int prev_sum = h.get(level)==null ? 0: h.get(level);
			h.put(level, prev_sum+node.data);
		}
	}
	
	public static void main(String args[])
	{
		VerticalSumBT v= new VerticalSumBT(null);
		v.head = new TreePrint(1);
		v.head.left = new TreePrint(2);
		v.head.right = new TreePrint(3);
		v.head.left.left = new TreePrint(4);
		v.head.left.right = new TreePrint(5);
		v.head.right.left= new TreePrint(6);
		v.head.right.right = new TreePrint(7);
		
	//	v.VerticalSum(v.head);
		v.construct(v.head);
	}
}
