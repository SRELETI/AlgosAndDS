import java.util.HashMap;

class CloneTreeNode {
	public int data;
	public CloneTreeNode left;
	public CloneTreeNode right;
	public CloneTreeNode random;
	
	public CloneTreeNode(int val) {
		data = val;
		left= null;
		right = null;
		random = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class CloneTree {

	public static void main(String args[]) {
		CloneTree c  =new CloneTree();
		CloneTreeNode root = new CloneTreeNode(1);
		root.left = new CloneTreeNode(2);
		root.right = new CloneTreeNode(3);
		
		root.left.left = new CloneTreeNode(4);
		root.left.right = new CloneTreeNode(5);
		
		root.random = root.left.right;
		
		root.left.left.random = root;
		root.left.right.random = root.right;
		
	//	c.display(root);
		c.startCloning(root);
		
	}
	
	public CloneTreeNode cloneNow(CloneTreeNode root, HashMap<CloneTreeNode, CloneTreeNode> hash) {
		if(root == null) 
			return null;
		CloneTreeNode newNode  = new CloneTreeNode(root.data);
		hash.put(newNode, root);
		newNode.left = cloneNow(root.left,hash);
		newNode.right = cloneNow(root.right,hash);
		return newNode;
	}
	
	public void startCloning(CloneTreeNode root) {
		HashMap<CloneTreeNode, CloneTreeNode> hash = new HashMap<CloneTreeNode, CloneTreeNode>();
		CloneTreeNode cloneNode = cloneNow(root,hash);
		cloneRandom(root,cloneNode,hash);
		display(root);
		display(cloneNode);
	}
	
	public void cloneRandom(CloneTreeNode root, CloneTreeNode clone, HashMap<CloneTreeNode, CloneTreeNode> hash) {
		if(clone==null) {
			return ;
		}
		clone.random = hash.get(clone).random;
		cloneRandom(root.left,clone.left,hash);
		cloneRandom(root.right,clone.right,hash);
	}
	
	
	public void display(CloneTreeNode temp ) {
		if(temp==null)
			return ;
		display(temp.left);
		temp.display();
		System.out.println(temp.random==null ? " null" : " "+temp.random.data);
		display(temp.right);
	}
}
