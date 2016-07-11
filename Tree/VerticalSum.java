import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class VerticalSum {

	private TreeInt root;
	
	public VerticalSum() {
		root = null;
	}
	
	public void vertical(TreeInt temp,int k, Map<Integer,Integer> h) {
		if(temp==null)
			return;
		if(h.containsKey(k)==false)
			h.put(k, temp.data);
		else
			h.put(k, h.get(k)+temp.data);
		vertical(temp.left,k-1,h);
		vertical(temp.right,k+1,h);
	}
	
	public static void main(String args[]) {
		VerticalSum v = new VerticalSum();
		
		v.root = new TreeInt(1);
		v.root.left = new TreeInt(2);
		v.root.right = new TreeInt(3);
		v.root.left.left = new TreeInt(4);
		v.root.left.right = new TreeInt(5);
		v.root.right.left = new TreeInt(6);
		v.root.right.right = new TreeInt(7);
		
		Map<Integer,Integer> h = new TreeMap<Integer,Integer>();
		v.vertical(v.root, 0, h);
		
		for(Entry<Integer,Integer> e:h.entrySet())
		{
			System.out.println(e.getKey()+" is "+e.getValue());
		}
		
	}
	
}
