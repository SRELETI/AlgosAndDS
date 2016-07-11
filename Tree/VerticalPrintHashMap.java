import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class VerticalPrintHashMap {

	public TreePrint head;
	
	public VerticalPrintHashMap()
	{
		head = null;
	}
	
	public void printVertical()
	{
		print(head);
	}
	
	private void print(TreePrint node)
	{
		if(node == null)
			return;
		HashMap<Integer,List<Integer>> h =new HashMap<Integer, List<Integer>>();
		fillMap(node,h,0);
		
		Iterator<Integer> it = h.keySet().iterator();
		while(it.hasNext())
		{
			Integer key = it.next();
			System.out.println(h.get(key));
		}
	}
	
	private void fillMap(TreePrint node , HashMap h, int hd)
	{
		if(node == null)
			return;
		h.put(hd, node.data);
		
		fillMap(node.left,h, hd-1);
		fillMap(node.right,h,hd+1);
	}
	
}
