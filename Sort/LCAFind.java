import java.util.ArrayList;
import java.util.Iterator;

class TreeInt {
	public int data;
	public TreeInt left;
	public TreeInt right;
	public TreeInt(int val) {
		data = val;
		left = null;
		right = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class LCAFind {

	public boolean findLCA(TreeInt root, int k, ArrayList<TreeInt> kArr) {
		if(root==null) {
			return false;
		}
		kArr.add(root);
		if(root.data==k) {
			return true;
		}
		if((findLCA(root.left,k,kArr)==true || findLCA(root.right,k,kArr)==true))
				return true;
		kArr.remove(kArr.size()-1);
		return false;
	}
	
	
	public TreeInt find(TreeInt root, int n1, int n2) {
		ArrayList<TreeInt> n1Arr = new ArrayList<TreeInt>();
		findLCA(root,n1,n1Arr);
		ArrayList<TreeInt> n2Arr = new ArrayList<TreeInt>();
		findLCA(root,n2,n2Arr);
	//	System.out.println(n1Arr.toString());
		return isThere(n1Arr,n2Arr,n1,n2);
	} 
	
	public TreeInt isThere(ArrayList<TreeInt> n1Arr, ArrayList<TreeInt> n2Arr, int k1, int k2) {
		TreeInt n1 = n1Arr.get(n1Arr.size()-1);
		TreeInt n2 = n2Arr.get(n2Arr.size()-1);
		if(n1.data!=k1 || n2.data!=k2) {
			return null;
		}
		
		Iterator<TreeInt> i1 = n1Arr.iterator();
		Iterator<TreeInt> i2 = n2Arr.iterator();
		
		TreeInt prevN1=null;
		
		while(i1.hasNext() && i2.hasNext()) {
			TreeInt temp = i1.next();
			TreeInt temp2 = i2.next();
			if(temp.data!=temp2.data) {
				return prevN1;
			}
			prevN1 = temp;
		}
		return null;
	}
	
	public static void main(String args[]) {
		LCAFind l = new LCAFind();
		TreeInt root = new TreeInt(1);
		root.left = new TreeInt(2);
		root.right = new TreeInt(3);
		
		root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(5);
		
		root.right.left = new TreeInt(6);
		root.right.right = new TreeInt(7);
		TreeInt temp = l.find(root, 4, 5);
		System.out.println(temp==null ? "null":temp.data);
	}
}
