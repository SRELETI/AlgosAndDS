import java.util.ArrayList;
import java.util.HashMap;


public class PrintVertical {

	public TreePrint head;
	
	public PrintVertical()
	{
		head = null;
	}
	
	public void printVert(TreePrint node)
	{
		HashMap<Integer,ArrayList<Integer>> h = new HashMap<Integer,ArrayList<Integer>>();
		print(node,0,h);
		System.out.println(h.entrySet());
	}
	
	private void print(TreePrint node, int hd, HashMap<Integer,ArrayList<Integer>> h)
	{
		if(node == null)
			return;
		print(node.left,hd-1,h);
		ArrayList<Integer> l = h.get(hd); 
		if(h.get(hd) == null)
		{
			ArrayList list = new ArrayList();
			list.add(node.data);
			h.put(hd, list);
		}
		else
		{
			h.get(hd).add(node.data);
		}
				
		print(node.right,hd+1,h);
	}
	
	
	public boolean checkSubset(int[] arr1, int[] arr2)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr1.length;i++)
		{
			if(h.get(arr1[i])==null)
		//	if(h.containsKey(arr1[i])==false)
				h.put(arr1[i], 1);
			else
			{
				int val = h.get(arr1[i]);
				h.put(arr1[i], val+1);
			}
		}
	//	System.out.println(h.entrySet());
		for(int i=0;i<arr2.length;i++)
		{
			if(h.get(arr2[i])== null || h.get(arr2[i]) ==0)
		//	if(h.containsKey(arr2[i])==false)
				return false;
			else
			{
				int val = h.get(arr2[i]);
				h.put(arr2[i], val-1);
			}
		}
		return true;
	}
}
