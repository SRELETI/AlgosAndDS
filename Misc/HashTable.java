import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Some problems solved using HashTables
 * 
 */

public class HashTable {

	/*
	 * This function checks if an array contains duplicates within k distance.
	 * 
	 * 
	 */
	public boolean containsDups(int[] arr, int k) {
		if(arr==null || arr.length==0) return false;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) return true;
			map.put(arr[i], i);
			if(i>=k) {
				map.remove(arr[i-k]);
			}
		}
		return false;
	}
	
	/*
	 * This function prints a binary tree in vertical order
	 * 
	 */
	public void printVertical(TreeInt2 node) {
		if(node==null) return;
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		printOrder(node,map,0);
		Iterator<List<Integer>> i = map.values().iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	private void printOrder(TreeInt2 node, Map<Integer,List<Integer>> map,int hd) {
		if(node == null) return;
		if(map.containsKey(hd)) {
			List<Integer> list= map.get(hd);
			list.add(node.data);
			map.put(hd, list);
		}
		else {
			List<Integer> list = new LinkedList<Integer>();
			list.add(node.data);
			map.put(hd, list);
		}
		printOrder(node.left,map,hd-1);
		printOrder(node.right,map,hd+1);
	}
	
	public static void main(String args[]) {
		HashTable hash = new HashTable();
		int[] arr = {1, 2, 3, 4, 4};
	//	System.out.println(hash.containsDups(arr, 3));
		TreeInt2 node = new TreeInt2(1);
		node.left = new TreeInt2(2);
		node.right = new TreeInt2(3);
		node.left.left = new TreeInt2(4);
		node.left.right = new TreeInt2(5);
		node.right.left = new TreeInt2(6);
		node.right.right = new TreeInt2(7);
		node.right.left.right = new TreeInt2(8);
		node.right.right.right = new TreeInt2(9);
		hash.printVertical(node);
	}
}

class TreeInt2 {
	public int data;
	public TreeInt2 left;
	public TreeInt2 right;
	
	public TreeInt2(int val) {
		data = val;
		left = null;
		right = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}
