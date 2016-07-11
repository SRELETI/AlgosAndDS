
public class BuildTree {

	public void build(int[] arr, int val) {
		if(arr==null || arr.length==0) 
			return;
		TreeInt root=null;
		for(int i=0;i<arr.length;i++) {
			root = buildTree(root,arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		findElement(root,val,sb);
		return;
	}
	
	private TreeInt buildTree(TreeInt root, int val) {
		if(root==null) {
			return new TreeInt(val);
		}
		if(val>root.data) {
			root.right = buildTree(root.right,val);
		}
		else if(val<root.data) {
			root.left = buildTree(root.left,val);
		}
		return root;
	}
	
	private void findElement(TreeInt root, int val, StringBuilder result) {
		if(root==null) {
			return;
		}
		if(root.data==val) {
			System.out.println(result.toString());
			return;
		}
		if(val>root.data) {
			findElement(root.right,val,result.append("0"));
		}
		else {
			findElement(root.left,val,result.append("1"));
		}
	}
	
	public static void main(String args[]) {
		BuildTree b = new BuildTree();
		int[] arr = {8,2,4,9,12,3,1};
		b.build(arr,8);
	}
}
