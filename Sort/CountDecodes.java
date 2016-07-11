import java.util.Arrays;

class TreeString {
	public String data;
	public TreeString left;
	public TreeString right;
	
	public TreeString(String val) {
		data = val;
		left = null;
		right = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class CountDecodes {

	public static String[] codes = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public TreeString buildTree(int data, int[] arr) {
		if(data>26){
			return null;
		}
		TreeString root = new TreeString(codes[data]);
		if(arr.length>0) {
			data = arr[0];
			int[] newArr =  Arrays.copyOfRange(arr, 1, arr.length);
			root.left = buildTree(data,newArr);
		}
		if(arr.length>1) {
			data = arr[0]*10+arr[1];
			int[] newArr = Arrays.copyOfRange(arr, 2, arr.length);
			root.right = buildTree(data,newArr);
		}
		return root;
	}
	
	private void printRootToLeaf(TreeString root,String sb) {
		if(root==null) {
			return;
		}
		sb = sb+root.data;
		if(root.left==null && root.right==null) {
			System.out.println(sb);
		}
		printRootToLeaf(root.left,sb);
		printRootToLeaf(root.right,sb);
	//	sb.deleteCharAt(sb.indexOf(root.data));
	}
	public static void main(String args[]) {
		CountDecodes c = new CountDecodes();
		int[] arr = {1,2,3};
		TreeString root = c.buildTree(0, arr);
		c.printRootToLeaf(root,"");
	}
}
