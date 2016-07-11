import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * Implementation of different tree functions
 * 
 */
public class TreeAllInOne {

	// Root of the tree
	private TreeInt head;
	// Constructor
	public TreeAllInOne() {
		head = null;
	}
	/*
	 * Recursive Inorder traversal of tree
	 * 
	 */
	public void inorder(TreeInt node) {
		if(node!=null) {
			inorder(node.left);
			node.display();
			inorder(node.right);
		}
	}
	
	/*
	 * Recursive preorder traversal of tree
	 */
	
	public void preorder(TreeInt node) {
		if(node!=null) {
			node.display();
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	/*
	 * recursive Postorder traversal of tree
	 */
	public void postorder(TreeInt node) {
		if(node!=null) {
			postorder(node.left);
			postorder(node.right);
			node.display();
		}
	}
	
	/*
	 * INorder traversal using Threaded binary tree. 
	 * No extra memory used.
	 */
	public void inorder_threaded(ThreadedTreeInt node) {
		ThreadedTreeInt present = leftMost(node);
		while(present!=null) {
			present.display();
			if(present.rightThread!=null) 
				present = present.rightThread;
			else 
				present = leftMost(present.right);
		}
		System.out.println();
	}
	
	/*
	 * Utility method - Returns the left most node in the tree
	 */
	private ThreadedTreeInt leftMost(ThreadedTreeInt node) {
		if(node==null) 
			return null;
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
	/*
	 * Returns the size of the tree
	 * 
	 */
	public int size(TreeInt node) {
		if(node==null) 
			return 0;
		return size(node.left)+1+size(node.right);
	}
	
	/*
	 * Checks if two trees are identical or not
	 */
	public boolean isIdentical(TreeInt node1, TreeInt node2) {
		if(node1==null && node2==null) 
			return true;
		if(node1==null || node2==null)
			return false;
		if(node1.data!=node2.data)
			return false;
		return isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right);
	}
	
	/*
	 * Height of the tree
	 */
	public int height(TreeInt node) {
		if(node==null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	
	/*
	 * Mirror Tree of a Tree
	 */
	public TreeInt getMirror(TreeInt node) {
		if(node==null)
			return null;
		TreeInt left = getMirror(node.left);
		TreeInt right = getMirror(node.right);
		node.right = left;
		node.left = right;
		return node;
	}
	
	/*
	 * Prints the root to leaf paths one per line
	 */
	public void printRootLeafPath(TreeInt node, int[] arr, int len) {
		if(node==null) {
			return;
		}
		arr[len++] = node.data;
		if(node.left==null && node.right==null) {
			printArray(arr,len);
			return;
		}
		printRootLeafPath(node.left,arr,len);
		printRootLeafPath(node.right,arr,len);
	}
	
	/*
	 * Utility functions, prints the array holding the root to leaf paths 
	 */
	public void printArray(int[] arr, int len) {
		for(int i=0;i<len;i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	/*
	 * Great Tree List Recursion Problem 
	 */
	public TreeInt treeToList(TreeInt node) {
		if(node==null)
			return null;
		TreeInt left = treeToList(node.left);
		TreeInt right = treeToList(node.right);
	
		// creates a circular list of size 1
		node.left = node;
		node.right = node;
		// appends the circular list to other circular lists to make a single list
		left = append(left,node);
		left = append(left,right);
		return left;
	}
	
	
	private TreeInt append(TreeInt node1, TreeInt node2) {
		if(node1==null) return node2;
		if(node2==null) return node1;
		// the last node of each circular list
		TreeInt llast = node1.left;
		TreeInt rlast = node2.left;
		// join last node to first node of other list
		llast.right = node2;
		node2.left = llast;
		rlast.right = node1;
		node1.left = rlast;
		return node1;
	}
	
	
	/*
	 * Level Order Traversal 
	 * 
	 * Method 1: O(n^2) in worst case
	 */
	public void levelOrder(TreeInt node) {
		if(node == null)
			return;
		int height = height(node);
		for(int i=1;i<=height;i++) {
			printLevel(node,i);
			System.out.println();
		}
	}
	/*
	 * Utility method, prints all the nodes at a given level
	 * 
	 */
	private void printLevel(TreeInt node, int i) {
		if(node == null) 
			return;
		if(i==1) {
			System.out.print(node.data+" ");
			return;
		}
		printLevel(node.left,i-1);
		printLevel(node.right,i-1);
	}
	
	/*
	 * Level Order Traversal
	 * O(n) method, uses O(n) extra space
	 */
	public void levelOrder_opt(TreeInt node) {
		if(node==null)
			return;
		Queue queue = new PriorityQueue();
		queue.add(node);
		int nodeCount = 0;
		while(true) {
			nodeCount = queue.size();
			if(nodeCount==0)
				break;
			while(nodeCount>0) {
				node = (TreeInt) queue.remove();
				node.display();
				if(node.left!=null) 
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}
	
	
	/*
	 * Count of Leaf Nodes in the tree
	 */
	public int leafNodes(TreeInt node) {
		if(node==null)
			return 0;
		if(node.left==null && node.right ==null)
			return 1;
		return leafNodes(node.left)+leafNodes(node.right);
	}
	
	/*
	 * Convert arbitrary binary tree into a tree holding children sum property
	 */
	public void childrenSum(TreeInt node) {
		if(node==null || node.left==null && node.right==null)
			return;
		childrenSum(node.left);
		childrenSum(node.right);
		int left = 0;
		int right =0;
		if(node.left!=null)
			left = node.left.data;
		if(node.right!=null)
			right = node.right.data;
		int diff = node.data-(left+right);
		if(diff<0) {
			node.data = node.data+Math.abs(diff);
		}
		else {
			addDown(node,diff);
		}
	}
	
	/*
	 * Diameter of a tree
	 */
	public int diameter(TreeInt node) {
		if(node==null)
			return 0;
		if(node.left==null && node.right==null)
			return 1;
		int leftDia = diameter(node.left);
		int rightDia = diameter(node.right);
		
		int lh = height(node.left);
		int rh = height(node.right);
		
		return Math.max(lh+rh+1, Math.max(leftDia,rightDia));
	}
	
	/*
	 * Adds the diff to the child nodes in the tree
	 */
	public void addDown(TreeInt node, int diff) {
		while(node!=null) {
			if(node.left!=null) {
				node.left.data = node.left.data+diff;
				node = node.left;
			}
			else if(node.right!=null) {
				node.right.data = node.right.data+diff;
				node = node.right;
			}
			else
				node = null;
		}
	}
	
	/*
	 * Diameter Opt function
	 */
	public int diameter_opt(TreeInt node, Wrapper_height h) {
		if(node==null)
			return 0;
		Wrapper_height lh = new Wrapper_height();
		Wrapper_height rh = new Wrapper_height();
		
		int lDia = diameter_opt(node.left,lh);
		int rDia = diameter_opt(node.right,rh);
		
		h.height = 1+Math.max(lh.height, rh.height);
		
		return Math.max(1+lh.height+rh.height, Math.max(lDia,rDia));
	}
	
	/*
	 * Average of a binary Tree
	 */
	public int average(TreeInt node) {
		Wrapper_average average = new Wrapper_average();
		getCountSum(node,average);
		return average.sum/average.count;
	}
	
	/*
	 * Calculates the sum and nodes in the tree
	 */
	public void getCountSum(TreeInt node, Wrapper_average average) {
		if(node!=null) {
			getCountSum(node.left,average);
			average.count++;
			average.sum += node.data;
			getCountSum(node.right,average);
		}
	}
	
	
	/*
	 * Height Balanced Tree
	 */
	public boolean isHeightBalanced(TreeInt node) {
		if(node == null )
			return true;
		boolean left = isHeightBalanced(node.left);
		boolean right = isHeightBalanced(node.right);
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if(leftHeight-rightHeight>1 || rightHeight-leftHeight>1)
			return false;
		return left && right;
	}
	
	/*
	 * Optimized Height Balanced Tree
	 * O(n) method.
	 * Height is calculated at the same time while checking if the tree is height balanced.
	 */
	public boolean isOptHeightBal(TreeInt node) {
		Wrapper_height height = new Wrapper_height();
		return isOptHeight(node,height);
	}
	
	private boolean isOptHeight(TreeInt node, Wrapper_height height) {
		if(node == null)
			return true;
		Wrapper_height left_h = new Wrapper_height();
		Wrapper_height right_h = new Wrapper_height();
		
		boolean left = isOptHeight(node.left, left_h);
		boolean right = isOptHeight(node.right,right_h);
		
		height.height = Math.max(left_h.height, right_h.height)+1;
		
		if(left_h.height-right_h.height>1 || right_h.height-left_h.height>1)
			return false;
		return left && right;
	}	
	
	/*
	 * Inorder Traversal without recursion
	 */
	public void inorderIterative(TreeInt node) {
		// If node is null return
		if(node == null)
			return;
		// Create a stack to hold tree
		Stack s = new Stack();
		while(true) {
			// push the nodes of the tree into stack until the node is null
			while(node!=null) {
				s.push(node);
				node = node.left;
			}
			// Check is stack is empty, if yes, we are done, otherwise pop a nodes from stack
			if(s.isEmpty())
				return;
			node = (TreeInt)s.pop();
			// print it
			System.out.print(node.data+" ");
			// move to right child of the tree
			node  = node.right;
		}
	}
	
	/*
	 * Inorder Traversal Without recursion and Without Stack
	 */
	public void inOrderTrav(TreeInt node) {
		//if node is null return
		if(node == null)
			return;
		while(node!=null) {
			if(node.left==null) {
				System.out.print(node.data+" ");
				node = node.right;
			}
			else {
				TreeInt pre = node.left;
				while(pre.right!=null && pre.right!=node) 
					pre = pre.right;
				if(pre.right==null) {
					pre.right = node;
					node = node.left;
				}
				else {
					pre.right= null;
					System.out.print(node.data+" ");
					node = node.right;
				}
			}
		}
	}
	
	/*
	 * Root to Leaf path sum equal to a given number
	 */
	public boolean isSumEqual(TreeInt node, int number) {
		return isSumEqualCal(node,0,number);
	}
	
	private boolean isSumEqualCal(TreeInt node, int inc, int num) {
		if(node == null)
			return false;
		inc += node.data;
		if(node.left==null && node.right==null)
			return inc == num;
		boolean left = isSumEqualCal(node.left,inc,num);
		boolean right = isSumEqualCal(node.right,inc,num);
		return left || right;
	}
	
	/*
	 * Construct tree from inorder and preorder tree traversal
	 * 
	 */
	public TreeInt treeInPre(int[] in, int[] pre, Wrapper_pre preIndex, int start, int end) {
		if(start>end) return null;
		int index = preIndex.index++;
		TreeInt node = new TreeInt(pre[index]);
		if(start==end)return node;
		int in_Index = findIndex(in,pre[index],start,end);
		node.left = treeInPre(in,pre,preIndex,start,in_Index-1);
		node.right = treeInPre(in,pre,preIndex,in_Index+1,end);
		return node;
	}
	
	private int findIndex(int[] arr, int val, int start, int end) {
		for(int i=start;i<=end;i++) {
			if(arr[i]==val)
				return i;
		}
		return -1;
	}
	
	
	/*
	 * Print root to leaf paths
	 */
	public void printRootToLeaf(TreeInt node) {
		int[] arr = new int[1000];
		printUtils(node,arr,0);
	}
	
	public void printUtils(TreeInt node, int[] arr,int inc) {
		if(node == null) return;
		arr[inc++] = node.data;
		if(node.left==null && node.right==null)  {
			printArray(arr,inc);
			return;
		}
		printUtils(node.left,arr,inc);
		printUtils(node.right,arr,inc);
	}
	
	/*
	 * Double Tree
	 * Double tree is a tree which is obtained by inserting a duplicate for each node as the left child of the original node
	 * 
	 * Double Tree can be constructed by doing a inorder, preorder or postorder traversal over the original tree
	 * 
	 * Inorder Traversal Construction of Double Tree
	 */
	public void doubleTree_inorder(TreeInt node) {
		if(node == null) return;
		doubleTree_inorder(node.left);
		TreeInt temp = node.left;
		node.left = new TreeInt(node.data);
		node.left.left = temp;
		doubleTree_inorder(node.right);
	}
	
	/*
	 * PreOrder Traversal Construction of Double Tree
	 */
	public void doubleTree_preorder(TreeInt node) {
		if(node==null) return;
		TreeInt temp = node.left;
		node.left = new TreeInt(node.data);
		node.left.left = temp;
		doubleTree_preorder(node.left.left);
		doubleTree_preorder(node.right);
	}
	
	/*
	 * PostOrder Traversal Construction of Double Tree
	 */
	
	public void doubleTree_postorder(TreeInt node) {
		if(node==null) return;
		doubleTree_postorder(node.left);
		doubleTree_postorder(node.right);
		TreeInt temp = node.left;
		node.left = new TreeInt(node.data);
		node.left.left = temp;
	}
	
	/*
	 * Maximum width of a binary tree
	 */
	public int maxWidth(TreeInt node) {
		if(node==null) return 0;
		Queue q = new PriorityQueue();
		q.add(node);
		int nodeCount = 0;
		int maxCount = 0;
		while(!q.isEmpty()) {
			nodeCount = q.size();
			if(maxCount<nodeCount) nodeCount = maxCount;
			
			while(nodeCount!=0) {
				node  = (TreeInt) q.remove();
				if(node.left!=null) q.add(node.left);
				if(node.right!=null) q.add(node.right);
				nodeCount--;
			}
		}
		return maxCount;
	}
	
	/*
	 * Foldable Trees
	 */
	
	public boolean isFoldable(TreeInt node) {
		if(node == null) return true;
		// Check if left subtree and right subtree are mirrors of each other, if so then the tree is foldable else not
		return isMirror(node.left,node.right);
	}
	// Checks if two trees are mirrors of each others.
	public boolean isMirror(TreeInt node1, TreeInt node2) {
		// if two trees are empty, return true
		if(node1==null && node2==null)
			return true;
		// if one of the tree is empty, return false;
		if(node1==null || node2==null)
			return false;
		// if we are here, then both the trees are non empty, now check if left subtree of tree1 is same as right subtree of tree2 and rightsubtree of tree1 is same as left subtree of tree2
		return isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
	}
	
	/*
	 * Foldable Trees, Second method. This method changes the tree structure
	 */
	public boolean isFoldable2(TreeInt node) {
		if(node==null)return true;
		
		TreeInt left = getMirror(node.left);
		
		boolean result = isSameUtils(left,node.right);
		
		return result;
	}
	// Checks if two trees are same Structurally 
	private boolean isSameUtils(TreeInt node1, TreeInt node2) {
		if(node1==null && node2==null) return true;
		if(node1==null || node2==null) return false;
		return isSameUtils(node1.left,node2.left) && isSameUtils(node1.right,node2.right);
	}
	
	/*
	 * Print nodes at k distance from the root
	 */
	public void printKDis(TreeInt node, int k) {
		if(node==null)
			return;
		if(k==0) {
			System.out.print(node.data+" ");
			return;
		}
		printKDis(node.left,k-1);
		printKDis(node.right,k-1);
	}
	
	/*
	 * Get Level of a node in a tree
	 */
	public int getLevel(TreeInt node, int val) {
		return levelUtils(node,val,1);
	}
	/*
	 * Utility method for finding the level of a node
	 */
	public int levelUtils(TreeInt node, int val, int level) {
		if(node==null) return -1;
		if(node.data==val) return level;
		
		int left = levelUtils(node.left,val,level+1);
		if(left!=-1) 
			return left;
		return levelUtils(node.right,val,level+1);
	}
	
	/*
	 * Print Ancestors of a given node
	 */
	public void printAns(TreeInt node, int val) {
		printAnsUtils(node, val);
	}
	
	private boolean printAnsUtils(TreeInt node, int val) {
		if(node==null) return false;
		if(node.data==val) return true;
		
		if(printAnsUtils(node.left,val) || printAnsUtils(node.right,val)) { 
			System.out.print(node.data+" ");
			return true;
		}
		return false;
	}
	
	/*
	 * Check if a tree is a binary tree
	 */
	public boolean isSumTree(TreeInt node, Wrapper_height sum) {
		if(node==null) return true;
		if(node.left==null && node.right==null){ 
			sum.height = node.data;
			return true;
		}
		Wrapper_height left_s = new Wrapper_height();
		Wrapper_height right_s = new Wrapper_height();
		
		boolean left = isSumTree(node.left,left_s);
		boolean right = isSumTree(node.right,right_s);
		
		sum.height = left_s.height + right_s.height+node.data;
		
		if(node.data==left_s.height+right_s.height && left && right) 
			return true;
		else 
			return false;
	}
	
	/*
	 * Check if a tree is a subtree of another tree
	 */
	public boolean isSubTree(TreeInt node1, TreeInt node2) {
		if(node1==null && node2==null) return true;
		if(node1==null || node2==null) return false;
		
		if(node1.data==node2.data) return isIdentical(node1,node2);
		return isSubTree(node1,node2.left) || isSubTree(node1,node2.right);
	}
	
	/*
	 * Connect nodes at same Level
	 * 
	 */
	public void connectLevel(ThreadedTreeInt node) {
		if(node==null) return ;
		Queue q = new PriorityQueue();
		q.add(node);
		int nodeCount = 0;
		while(!q.isEmpty()) {
			nodeCount = q.size();
			
			while(nodeCount>0) {
				node = (ThreadedTreeInt) q.remove();
				if(nodeCount>1) 
					node.rightThread = (ThreadedTreeInt) q.peek();
				if(node.left!=null) 
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				nodeCount--;
			}
		}
	}
	
	
	/*
	 * Connect nodes at same level 
	 */
	public void connectNodes(ThreadedTreeInt node) {
		if(node==null) return;
		node.rightThread = null;
		connectNodesUtils(node);
	}
	
	private void connectNodesUtils(ThreadedTreeInt node) {
		if(node==null) return;
		if(node.rightThread!=null)
			connectNodesUtils(node.rightThread);
		if(node.left!=null) {
			if(node.right!=null) {
				node.left.rightThread = node.right;
				node.right.rightThread = getNextRight(node);
			}
			else {
				node.left.rightThread = getNextRight(node);
			}
			connectNodesUtils(node.left);
		}
		else if(node.right!=null) {
			node.right.rightThread = getNextRight(node);
			connectNodesUtils(node.right);
		}
		else 
			connectNodesUtils(getNextRight(node));
	}
	
	private ThreadedTreeInt getNextRight(ThreadedTreeInt node) {
		ThreadedTreeInt temp = node.rightThread;
		while(temp!=null) {
			if(temp.left!=null)
				return temp.left;
			if(temp.right!=null)
				return temp.right;
			temp = temp.rightThread;
		}
		return null;
	}
	
	/*
	 * Populate Inorder Successor for every node
	 */
	public void populateInorder(ThreadedTreeInt node,Wrapper_Node prev) {
		if(node==null) return;
		populateInorder(node.right,prev);
		node.rightThread = prev.prev;
		prev.prev = node;
		populateInorder(node.left,prev);
	}
	
	/*
	 * Convert a tree to its sumTree
	 */
	public int convertSumTree(TreeInt node) {
		if(node==null) return 0;
		int old_val = node.data;
		node.data = convertSumTree(node.left)+convertSumTree(node.right);
		return old_val+node.data;
	}
	
	/*
	 * Construct a special tree from a given inorder traversal
	 * Every node in the tree is greater than its left and right children. 
	 */
	public TreeInt constructInorder(int[] in, int start, int end) {
		if(start>end) return null;
		int index = getMaxIndexUtils(in,start,end);
		TreeInt root = new TreeInt(in[index]);
		if(start==end) return root;
		root.left = constructInorder(in,start,index-1);
		root.right = constructInorder(in,index+1,end);
		return root;
	}
	/*
	 * Returns the index of the largest element in the array
	 */
	public int getMaxIndexUtils(int[] arr, int start, int end) {
		int max = start;
		for(int i=start+1;i<=end;i++) {
			if(arr[i]>arr[max])
				max = i;
		}
		return max;
	}
	
	/*
	 * Boundary traversal of a tree
	 */
	public void boundaryTrav(TreeInt node) {
		if(node==null) return;
		System.out.print(node.data+" ");
		printLeft(node.left);
		printLeaves(node.left);
		printLeaves(node.right);
		printRight(node.right);
	}
	/*
	 * prints left side of the tree
	 */
	private void printLeft(TreeInt node) {
		if(node==null) return;
		if(!isLeaf(node)) {
			System.out.print(node.data+" ");
			if(node.left!=null) 
				printLeft(node.left);
			else if(node.right!=null)
				printLeft(node.right);
		}
	}
	/*
	 * Checks if a node is a leaf node
	 */
	private boolean isLeaf(TreeInt node) {
		return node.left==null && node.right==null;
	}
	
	/*
	 * prints the leaf nodes
	 */
	private void printLeaves(TreeInt node) {
		if(node == null) return;
		if(isLeaf(node)) {
			System.out.print(node.data+" ");
			return;
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}
	/*
	 * prints the nodes on right side of the tree
	 */
	private void printRight(TreeInt node) {
		if(node==null) return;
		if(!isLeaf(node)) {
			if(node.right!=null) 
				printRight(node.right);
			else if(node.left!=null)
				printRight(node.left);
			System.out.print(node.data+" ");
		}
	}
	
	public TreeInt constructPrePost(int[] pre, int[] post, Wrapper_pre preIndex, int start, int end) {
		if(start>end) return null;
		TreeInt root = new TreeInt(pre[preIndex.index]);
		preIndex.index++;
		if(start==end) 
			return root;
		int index = findIndex(post,pre[preIndex.index],start,end);
		root.left = constructPrePost(pre,post,preIndex,start,index);
		root.right = constructPrePost(pre,post,preIndex,index+1,end-1);
		return root;
	}
	
	/*
	 * Iterative PreOrder Traversal
	 */
	public void preOrder_Itr(TreeInt node) {
		if(node==null) return;
		Stack s = new Stack();
		s.push(node);
		while(!s.isEmpty()) {
			node = (TreeInt)s.pop();
			node.display();
			if(node.right!=null)
				s.push(node.right);
			if(node.left!=null)
				s.push(node.left);
		}
	}
	
	/*
	 * Morris PreOrder Traversal
	 */
	public void preOrder_Morris(TreeInt node) {
		if(node==null) return;
		while(node!=null) {
			if(node.left==null) {
				System.out.print(node.data+" ");
				node = node.right;
			}
			else {
				TreeInt temp = node.left;
				while(temp.right!=null && temp.right!=node)
					temp = temp.right;
				if(temp.right==null) {
					temp.right=node;
					System.out.print(node.data+" ");
					node = node.left;
				}
				else {
					temp.right= null;
					node = node.right;
				}
			}
		}
	}
	
	/*
	 * Postorder Traversal With One stack
	 */
	public void postorderTrav(TreeInt node) {
		if(node==null) return;
		Stack s = new Stack();
		do {
			while(node!=null) {
				if(node.right!=null) 
					s.push(node.right);
				s.push(node);
				node = node.left;
			}
			
			node = (TreeInt) s.pop();
			if(node.right!=null && (TreeInt)s.peek()==node.right) {
				s.pop();
				s.push(node);
				node = node.right;
			}
			else {
				node.display();
				node = null;
			}
		}while(!s.isEmpty());
	}
	
	/*
	 * Convert binary tree to a list
	 */
	public TreeInt convertTreeToList(TreeInt node) {
		if(node==null) 
			return node;
		node = convertTreeListUtils(node);
		while(node.left!=null) 
			node = node.left;
		return node;
	}
	
	/*
	 * Utility function to convert tree to list
	 */
	public TreeInt convertTreeListUtils(TreeInt node) {
		if(node==null) return null;
		
		if(node.left!=null) {
			TreeInt left = convertTreeListUtils(node.left);
			while(left.right!=null) 
				left = left.right;
			left.right = node;
			node.left = left;
		}
		if(node.right!=null) {
			TreeInt right = convertTreeListUtils(node.right);
			while(right.left!=null)
				right = right.left;
			right.left = node;
			node.right = right;
		}
		return node;
	}
	
	/*
	 * Isomorphic Trees 
	 */
	public boolean isIso(TreeInt node1, TreeInt node2) {
		if(node1==null && node2==null) return true;
		if(node1==null || node2==null) return false;
		if(node1.data!=node2.data) return false;
		return (isIso(node1.left, node2.left)&&isIso(node1.right,node2.right)) || (isIso(node1.left,node2.right) && isIso(node1.right,node2.left)); 
	}
	
	/*
	 * Find all possible interpretations of array of digits
	 * Input: arrays with values from 1 to 9. Can be of any length
	 * Also given another array which contains all the alphabets, where the index of each alphabets are the values that can be formed from the input array
	 * Example: {1,1} The possible interpretations are "aa", "k", where "aa" represents {1,1} and "k" represents {11}	
	 */
	public void findItr(int[] arr) {
		TreeString result = buildItrTree(arr,0,"");
		
		printLeafs(result);
	}
	// array holding all the alphabets 
	private static String[] alphabets = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"
		,"w","x","y","z"};
	
	// Build a tree which represents all the possible combinations
	private TreeString buildItrTree(int[] arr, int data, String nodeString) {
		if(data>26) return null;
		TreeString node = new TreeString(nodeString+alphabets[data]);
		if(arr.length!=0) {
			data = arr[0];
			int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
			node.left = buildItrTree(newArr,data,node.data);
		}
		if(arr.length>1) {
			data = arr[0]*10+arr[1];
			int[] newArr = Arrays.copyOfRange(arr, 2, arr.length);
			node.right = buildItrTree(newArr,data,node.data);
		}
		return node;
	}
	// Now print all the leaf nodes of the tree, each leaf node represent a possible combination
	private void printLeafs(TreeString node) {
		if(node==null) return;
		if(node.left==null && node.right==null) {
			node.display();
			return;
		}
		printLeafs(node.left);
		printLeafs(node.right);
	}
	
	/*
	 * Construct a linkedlist from the tree - Simpler method compared to the first method
	 */
	public TreeInt convertTreeToList2(TreeInt node) {
		Wrapper_UTNode pre = new Wrapper_UTNode();
		convertLeftUtils(node,pre);
		return convertRightUtils(node,pre);
	}
	// Makes left pointers point to its prev node in the list
	private void convertLeftUtils(TreeInt node, Wrapper_UTNode pre) {
		if(node==null)
			return;
		convertLeftUtils(node.left,pre);
		node.left = pre.prev;
		pre.prev = node;
		convertLeftUtils(node.right,pre);
	}
	// Makes right pointers point to next node in the list and return the head of the list
	private TreeInt convertRightUtils(TreeInt node, Wrapper_UTNode pre) {
		if(node==null) return null;
		while(node!=null && node.right!=null) 
			node = node.right;
		while(node!=null && node.left!=null) {
			pre.prev = node;
			node = node.left;
			node.right = pre.prev;
		}
		return node;
	}
	
	/*
	 * Print Ancestors without using recursion
	 */
	public void printAns_Itr(TreeInt node, int val) {
		if(node==null) {
			return;
		}
		Stack s  = new Stack();
		while(true) {
			while(node!=null) {
				if(node.data==val) {
					while(!s.isEmpty()) {
						((TreeInt)s.pop()).display();
					}
					return;
				}
				s.push(node);
				node = node.left;
			}
			if(s.isEmpty()) return;
			
			if(((TreeInt)s.peek()).right==null) {
				node = (TreeInt)s.pop();
				while(!s.isEmpty() && ((TreeInt)s.peek()).right==node)
					node = (TreeInt)s.pop();
			}
			node = s.isEmpty()?null:((TreeInt)s.peek()).right;
		}
	}
	
	/*
	 * DIfference between sum of nodes at odd levels and even levels 
	 */
	public int sumOddEven(TreeInt node) {
		Wrapper_sums total = new Wrapper_sums();
		sumOddEvenUtils(node,total,true);
		return total.sum_odd-total.sum_even;
	}
	
	private void sumOddEvenUtils(TreeInt node, Wrapper_sums total, boolean decide) {
		if(node==null) return;
		if(decide) 
			total.sum_odd+=node.data;
		else
			total.sum_even+=node.data;
		sumOddEvenUtils(node.left,total,!decide);
		sumOddEvenUtils(node.right,total,!decide);
	}
	
	/*
	 * Print PostOrder traversal without constructing the tree
	 */
	public void printTreeInPre(int[] in,int[] pre,int start, int end) {
		int root = findIndex(in,pre[0],start,end);
		if(root!=start) {
			System.out.println(Arrays.toString(pre)+" "+in[root]);
			printTreeInPre(in,Arrays.copyOfRange(pre,1,in.length),start,root-1);
		}
		if(root!=end) {
			System.out.println(Arrays.toString(pre)+" "+in[root]+" "+in.length);
			printTreeInPre(in,Arrays.copyOfRange(pre, 1+root, in.length),root+1,end);
		}
		System.out.print(in[root]+" ");
	}
	
	/*
	 * Remove all nodes which doesnt lie in any path with sum>=k
	 */
	public TreeInt removeNodes(TreeInt node, int k) {
		Wrapper_average sum = new Wrapper_average();
		return removeNodesUtils(node,k,sum);
	}
	
	private TreeInt removeNodesUtils(TreeInt node, int k , Wrapper_average sum) {
		if(node==null) return null;
		Wrapper_average left= new Wrapper_average();
		Wrapper_average right = new Wrapper_average();
		left.sum = node.data+sum.sum;
		right.sum = left.sum;
		
		node.left = removeNodesUtils(node.left,k,left);
		node.right = removeNodesUtils(node.right,k,right);
		sum.sum  = Math.max(left.sum, right.sum);
		if(sum.sum<k) 
			node = null;
		return node;
	}
	
	/*
	 * Extract leaves of a binary tree into a doubly LL
	 */
	public TreeInt extractDLL(TreeInt node) {
		Wrapper_UTNode head = new Wrapper_UTNode();
		extractDLLUtils(node,head);
		return head.prev;
	}
	
	private TreeInt extractDLLUtils(TreeInt node, Wrapper_UTNode head) {
		if(node==null) 
			return null;
		if(node.left==null && node.right==null) {
			if(head.prev==null) {
				head.prev = node;
			}
			else {
				TreeInt temp = head.prev;
				while(temp.right!=null) 
					temp = temp.right;
				temp.right = node;
			}
			return null;
		}
		node.left = extractDLLUtils(node.left,head);
		node.right = extractDLLUtils(node.right,head);
		return node;
	}
	
	/*
	 * Convert given binary tree to linked list
	 */
	public TreeInt convertTreeLL(TreeInt node) {
		Wrapper_UTNode prev = new Wrapper_UTNode();
		Wrapper_UTNode head = new Wrapper_UTNode();
		convertTreeLLUtils(node,prev,head);
		return head.prev;
	}
	
	private void convertTreeLLUtils(TreeInt node, Wrapper_UTNode prev, Wrapper_UTNode head) {
		if(node == null) return;
		convertTreeLLUtils(node.left,prev,head);
		if(head.prev==null) 
			head.prev = node;
		else {
			node.left = prev.prev;
			prev.prev.right = node;
		}
		prev.prev = node;
		convertTreeLLUtils(node.right,prev,head);
	}
	
	/*
	 * LCA of two nodes in a tree
	 */
	public TreeInt LCA(TreeInt node,int n1, int n2) {
		if(node==null)
			return null;
		TreeInt[] arr1 = new TreeInt[10];
		TreeInt[] arr2 = new TreeInt[10];
		if(findPath(node,n1,arr1,0)==false || findPath(node,n2,arr2,0)==false)
			return null;
		int i=0;
		while(arr1[i]==arr2[i] && i<arr1.length) 
			i++;
		if(i==arr1.length)
			return null;
		else 
			return arr1[i-1];
		
	} 
	
	private boolean findPath(TreeInt node, int val, TreeInt[] arr, int inc) {
		if(node==null)
			return false;
		arr[inc++] = node;
		if(node.data==val) 
			return true;
		return findPath(node.left,val,arr,inc) || findPath(node.right,val,arr,inc);
	}
	
	
	/*
	 * LCA optimized method
	 */
	public TreeInt opt_LCA(TreeInt node, int n1, int n2) {
		if(node==null)
			return null;
		Wrapper_bool values = new Wrapper_bool();
		TreeInt lca = findPathUtils(node,n1,n2,values);
		if((values.isN1 && values.isN2) || (values.isN1 && findUtils(lca,n2)) || (values.isN2 && findUtils(lca,n1)))
			return lca;
		return null;
	}
	
	private boolean findUtils(TreeInt lca, int val) {
		if(lca == null) return false;
		if(lca.data==val) return true;
		return findUtils(lca.left,val) || findUtils(lca.right,val);
	}
	private TreeInt findPathUtils(TreeInt node, int n1, int n2, Wrapper_bool values) {
		if(node==null)
			return null;
		if(node.data==n1) {
			values.isN1=true;
			return node;
		}
		if(node.data==n2){
			values.isN2=true;
			return node;
		}
		TreeInt left = findPathUtils(node.left,n1,n2,values);
		TreeInt right = findPathUtils(node.right,n1,n2,values);
		if(left!=null && right!=null) 
			return node;
		return left==null?right:left;
	}
	
	/*
	 * Distance between two nodes in a Tree
	 */
	public int distance(TreeInt node, int n1, int n2) {
		if(node==null)
			 return 0;
		Wrapper_Distance values = new Wrapper_Distance();
		TreeInt result = findDistanceUtils(node,values,1,n1,n2);
		if(values.d1!=0 && values.d2!=0) 
			return values.dist;
		if(values.d1==0) {
			return findDistanceUtils2(result,n1,values.d2,values.d2);
		}
		if(values.d2==0)
			return findDistanceUtils2(result,n2,values.d1,values.d1);
		return 0;
	}
	
	private int findDistanceUtils2(TreeInt node, int val, int dist1, int dist2) {
		if(node==null) 
			return 0;
		if(node.data==val) {
			return dist2-dist1;
		}
		int left = findDistanceUtils2(node.left,val,dist1,dist2+1);
		int right = findDistanceUtils2(node.right,val,dist1,dist2+1);
		return left==0?right:left;
	}
	
	private TreeInt findDistanceUtils(TreeInt node, Wrapper_Distance values, int level,int n1, int n2) {
		if(node==null) return node;
		if(node.data==n1) {
			values.d1 = level;
			return node;
		}
		if(node.data==n2) {
			values.d2 = level;
			return node;
		}
		TreeInt left = findDistanceUtils(node.left,values,level+1,n1,n2);
		TreeInt right = findDistanceUtils(node.right,values, level+1,n1,n2);
		if(left!=null && right!=null) {
			values.dist = values.d1+values.d2-2*level;
			return node;
		}
		return left==null? right:left;
	}
	
	/*
	 * Print all nodes at k distance from the leaf nodes
	 */
	public void printNodesKLeaf(TreeInt node, int k) {
		if(node==null)
			return;
		int[] arr = new int[100];
		boolean[] visited = new boolean[100];
		printNodesKLeafUtils(node,k,arr,0,visited);
	}
	
	private void printNodesKLeafUtils(TreeInt node, int k, int[] arr, int index, boolean[] visited) {
		if(node==null) return;
		arr[index] =node.data;
		visited[index]=false;
		index++; 
		if(node.left == null && node.right==null && index-k-1>=0 && visited[index-k-1]==false) {
			System.out.print(arr[index-k-1]+" ");
			visited[index-k-1]=true;
			return;
		}
		printNodesKLeafUtils(node.left,k,arr,index,visited);
		printNodesKLeafUtils(node.right,k,arr,index,visited);
	}
	
	private int printNodesKDistance(TreeInt node, int k, TreeInt target) {
		if(node==null) return -1;
		if(node==target) {
			printNodesKDown(node,k);
			return 0;
		}
		int dl = printNodesKDistance(node.left,k,target);
		if(dl!=-1) {
			if(dl+1==k) {
				node.display();
			}
			else {
				printNodesKDown(node.right,k-dl-2);
			}
			return dl+1;
		}
		int dr = printNodesKDistance(node.right,k,target);
		if(dr!=-1) {
			if(dr+1==k) {
				node.display();
			}
			else
				printNodesKDown(node.left,k-dr-2);
			return dr+1;
		}
		return -1;
	}
	
	private void printNodesKDown(TreeInt node, int k) {
		if(node==null) 
			return;
		if(k==0) {
			node.display();
			return;
		}
		printNodesKDown(node.left,k-1);
		printNodesKDown(node.right,k-1);
	}
	
	public TreeInt constructTree_InLevel(int[] in, int[] level,int start, int end) {
		if(start>end) 
			return null;
		TreeInt root = new TreeInt(level[0]);
		if(start==end) 
			return root;
		int index = findIndex(in,level[0],start,end);
		int[] left = extractElements(in,level,start,index-1);
		int[] right = extractElements(in,level,index+1,end);
		root.left = constructTree_InLevel(in,left,start,index-1);
		root.right = constructTree_InLevel(in,right,index+1,end);
		return root;
	}
	
	private int[] extractElements(int[] in,int[] level,int start, int end) {
		int[] result = new int[end-start+1];
		int j=0;
		for(int i=0;i<level.length;i++) {
			if(search(level[i],in,start,end)==true) {
				result[j++] =level[i];
			}
		}
		return result;
	}
	
	private boolean search(int val, int[] in, int start, int end) {
		for(int i=start;i<=end;i++) {
			if(val==in[i]) 
				return true;
		}
		return false;
	}
	
	public int maxPathTwoNodes(TreeInt node) {
		if(node==null) return 0;
		Wrapper_height total = new Wrapper_height(); 
		Wrapper_height sum = new Wrapper_height();
		maxPathTwoNodesUtils(node,total);
		return total.height;
	}
	
	private int maxPathTwoNodesUtils(TreeInt node, Wrapper_height total) {
		if(node==null) return 0;
		int left = maxPathTwoNodesUtils(node.left,total);
		int right = maxPathTwoNodesUtils(node.right,total);
		int sum = Math.max(left+right+node.data, Math.max(left, right));
		if(total.height<sum) {
			total.height = sum;
		}
		return Math.max(left, right)+node.data;
	}
	
	/*
	 * Reverse alternate levels of a perfect binary tree
	 */
	public void reverse_altLevelsPBT(TreeInt node) {
		if(node==null || (node.left==null && node.right==null))
			return;
		int[] arr = new int[100];
		Wrapper_height index = new Wrapper_height();
		getOddLevelNodes(node,0,arr, index);
		
		reverse(arr,index.height);
		index.height=0;
	//	System.out.println(arr[index.height]);
		modifyTree(node,0,arr,index);
	}
	
	private void getOddLevelNodes(TreeInt node, int level, int[] arr, Wrapper_height index) {
		if(node==null) 
			return;
		getOddLevelNodes(node.left,level+1,arr,index);
		if(level%2!=0) {
			arr[index.height++] = node.data;
		}
		getOddLevelNodes(node.right,level+1,arr,index);
	}
	
	private void reverse(int[] arr, int end) {
		
		int i=0;
		int j=end-1;
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	private void modifyTree(TreeInt node, int level , int[] arr, Wrapper_height index) {
		if(node==null) return;
		
		modifyTree(node.left,level+1,arr,index);
		if(level%2!=0) {
			node.data = arr[index.height++];
		}
		
		modifyTree(node.right,level+1,arr,index);
	}
	
	/*
	 * Closest Leaf node to a given node in a binary tree
	 */
	public void closestLeafNode(TreeInt node, int key) {
		TreeInt[] arr = new TreeInt[100];
		Wrapper_average2 leaf = new Wrapper_average2();
		closestLeafUtils(node,key,arr,0,leaf);
		System.out.println("The closest leaf node is "+leaf.sum+ "and the distance is "+leaf.count);
	}
	
	private int closestLeafUtils(TreeInt node, int key, TreeInt[] arr, int index, Wrapper_average2 leaf) {
		if(node==null) return Integer.MAX_VALUE;
		if(node.data==key) {
			Wrapper_average2 leafNode = new Wrapper_average2();
			closestDown(node,leafNode,0);
			leaf.count = leafNode.count;
			leaf.sum = leafNode.sum;
			leafNode.count=Integer.MAX_VALUE;
			leafNode.sum=0;
			for(int i=index-1;i>=0;i--) {
				closestDown(arr[i],leafNode,0);
				if (leaf.count > index-i+leafNode.count) {
					leaf.count = index-i+leafNode.count;
					leaf.sum = leafNode.sum;
				}
			}
			return leaf.count;
		}
		arr[index++] = node;
		return Math.min(closestLeafUtils(node.left,key,arr,index,leaf), closestLeafUtils(node.right,key,arr,index,leaf));
	}
	
	private void closestDown(TreeInt node,Wrapper_average2 leafNode,int level) {
		if(node==null)
			return;
		if(node.left==null && node.right==null && leafNode.count>level) {
			leafNode.count= level;
			leafNode.sum = node.data;
			return;
		}
		closestDown(node.left,leafNode,level+1);
		closestDown(node.right,leafNode,level+1);
	}
	
	
	/*
	 * Convert left right representation of binary tree to down right
	 */
	public void convertLR_DR(TreeInt node) {
		if(node==null) 
			return;
		Queue q  = new LinkedList();
		q.add(node);
		TreeInt firstNode = node;
		int nodeCount =0;
		while(!q.isEmpty()) {
			nodeCount = q.size();
			TreeInt prev = null;
			while(nodeCount>0) {
				node = (TreeInt)q.remove();
				if(node.left!=null) 
					q.add(node.left);
				if(node.right!=null) 
					q.add(node.right);
				if(prev!=null) {
					prev.right = node;
					node.left = null;
				}
				else{
					firstNode.left = node;
					firstNode = node;
				}
				prev = node;
				nodeCount--;
			}
			prev.right = null;
		}
	}
	
	/*
	 * Print Down Right Tree
	 */
	public void downRight(TreeInt node) {
		if(node==null) return;
		node.display();
		downRight(node.right);
		downRight(node.left);
	}
	
	/*
	 * Clone a binary Tree with random pointers
	 */
	public TreeIntRan cloneTree(TreeIntRan node) {
		Map<TreeIntRan,TreeIntRan> map = new HashMap<TreeIntRan,TreeIntRan>();
		TreeIntRan clone = cloneLeftRight(node,map);
		cloneRandom(node,clone,map);
		return clone;
	}
	
	private void cloneRandom(TreeIntRan node, TreeIntRan clone, Map<TreeIntRan,TreeIntRan> map) {
		if(node==null)
			return;
		clone.random = map.get(node.random);
		cloneRandom(node.left,clone.left,map);
		cloneRandom(node.right,clone.right,map);
	}
	
	private TreeIntRan cloneLeftRight(TreeIntRan node, Map<TreeIntRan, TreeIntRan> map) {
		if(node ==null)
			return null;
		TreeIntRan clone = new TreeIntRan(node.data);
		map.put(node, clone);
		clone.left = cloneLeftRight(node.left,map);
		clone.right = cloneLeftRight(node.right,map);
		return clone;
	}
	
	/*
	 * Inorder Traversal of Tree with random pointers
	 */
	public void inorder(TreeIntRan node) {
		if(node!=null) {
			inorder(node.left);
			node.display();
			if(node.random!=null) 
				System.out.print(" Random value "+node.random.data+" ");
			else 
				System.out.print("Random value null ");
			inorder(node.right);
		}
	}
	
	/*
	 * Clone tree optimized method
	 */
	public TreeIntRan opt_cloneTree(TreeIntRan node) {
		TreeIntRan clone = opt_cloneLeftRight(node);
		opt_cloneRandom(node,clone);
		seperateTrees(node,clone);
		return clone;
	}
	
	private TreeIntRan opt_cloneLeftRight(TreeIntRan node) {
		if(node==null)
			return null;
		TreeIntRan temp = node.left;
		TreeIntRan clone = new TreeIntRan(node.data);
		node.left = clone;
		clone.left = temp;
		if(temp!=null) {
			temp.left = opt_cloneLeftRight(temp);
		}
		clone.right = opt_cloneLeftRight(node.right);
		return node.left;
	}
	
	private void opt_cloneRandom(TreeIntRan node, TreeIntRan clone) {
		if(node==null) return;
		if(node.random!=null) {
			clone.random  = node.random.left;
		}
		else{
			clone.random = null;
		}
		if(node.left!=null && clone.left!=null) 
			opt_cloneRandom(node.left.left,clone.left.left);
		opt_cloneRandom(node.right,clone.right);
	}
	
	private void seperateTrees(TreeIntRan node, TreeIntRan clone) {
		if(node==null)
			return;
		if(clone.left!= null) {
			TreeIntRan temp = clone.left.left;
			node.left = node.left.left;
			clone.left = temp;
		}
		else {
			node.left = null;
		}
		seperateTrees(node.left,clone.left);
		seperateTrees(node.right,clone.right);
	}
	
	/*
	 * Remove half nodes from a binary tree
	 */
	public TreeInt removeHalfNodes(TreeInt node) {
		if(node==null) return null;
		if(node.left==null && node.right==null) return node;
		node.left = removeHalfNodes(node.left);
		node.right = removeHalfNodes(node.right);
		if(node.left==null && node.right==null)
			return node;
		else if(node.left==null ) {
			return node.right;
		}
		else if(node.right==null)
			return node.left;
		else 
			return node;
	}
	
	/*
	 * Check if is Full binary tree 
	 */
	public boolean isFull(TreeInt node){
		if(node == null) return true;
		if(node.left==null && node.right == null) return true;
		if(node.left!=null && node.right!=null) return isFull(node.left) && isFull(node.right);
		return false;
	}
	
	
	/*
	 * Main Method
	 */
	public static void main(String args[]) {
		TreeAllInOne tree = new TreeAllInOne();
		
		TreeInt head = new TreeInt(1);
		head.left = new TreeInt(2);
		head.right = new TreeInt(3);
		head.left.left = new TreeInt(4);
		head.left.right = new TreeInt(5);
	//	head.right.left = new TreeInt(1);
		head.right.left = new TreeInt(6);
		head.left.right.left = new TreeInt(7);
		head.left.right.right = new TreeInt(8);
	/*	head.right.right.right = new TreeInt(1);
		head.right.right.right.left = new TreeInt(1);
		head.right.right.right.right = new TreeInt(1);
		head.right.right.right.left.left = new TreeInt(1);
		head.right.right.right.left.right = new TreeInt(1);
		*/
		TreeInt head2 = new TreeInt(2);
		head2.left = new TreeInt(7);
		head2.right = new TreeInt(5);
	//	head2.left.left = new TreeInt(4);
		head2.left.right = new TreeInt(6);
	//	head2.left.left.left = new TreeInt(8);
	//	head2.left.left.right = new TreeInt(9);
		head2.left.right.left = new TreeInt(1);
		head2.left.right.right = new TreeInt(11);
	//	head2.left.left.right = new TreeInt(8);
	//	head2.left.left.right.right = new TreeInt(14);
	//	head2.left.left.right.left = new TreeInt(13);
	//	head2.left.left.right.right.left = new TreeInt(15);
	//	head2.left.left.left = new TreeInt(7);
	//	head2.right.left= new TreeInt(4);
		head2.right.right = new TreeInt(9);
		head2.right.right.left = new TreeInt(4);
	//	head2.right.left.left.left = new TreeInt(8);
	//	head2.right.left.left.right = new TreeInt(9);
	//	head2.right.left.right = new TreeInt(13);
	//	head2.right.right.left = new TreeInt(7);
	//	head2.right.right.right = new TreeInt(8);
	//	head2.right.right.right.right = new TreeInt(-1);
	//	head2.right.right.right.left = new TreeInt(10);
	//	head2.right.right.right.right.left = new TreeInt(10);
	//	head2.right.right.left = new TreeInt(9);
	//	head2.right.right.right = new TreeInt(10);
	//	System.out.println(tree.isIso(head, head2));
	//	tree.printNodesKLeaf(head2, 2);
	//	tree.printNodesKDistance(head2, 2, head2.left);
	//	tree.convertLR_DR(head2);
		TreeInt result = tree.removeHalfNodes(head2);
		tree.inorder(result);
		TreeIntRan head3 = new TreeIntRan(1);
		head3.left = new TreeIntRan(2);
		head3.right = new TreeIntRan(3);
		head3.left.left = new TreeIntRan(4);
		head3.left.right = new TreeIntRan(5);
		
		head3.random = head3.left.right;
		head3.left.left.random = head3;
		head3.left.right.random = head3.right;
		
	//	TreeIntRan result = tree.opt_cloneTree(head3);
	//	tree.inorder(result);
	//	tree.downRight(head2);
	//	int in[]    = {4, 8, 10, 12, 14, 20, 22};
	//  int level[] = {20, 8, 22, 4, 12, 10, 14};
	//  TreeInt result = tree.constructTree_InLevel(in, level, 0, 6);
	//  tree.inorder(result);
	/*	TreeInt result = tree.extractDLL(head2);
		while(result!=null) {
			result.display();
			result = result.right;
		}
		*/
	//	System.out.println(tree.sumOddEven(head2));
	/*	TreeInt node = tree.convertTreeToList2(head2);
		while(node!=null) {
			node.display();
			node= node.right;
		}
	*/		
		
	//	tree.preOrder_Morris(head2);
	//	Wrapper_height sum = new Wrapper_height();
	//	System.out.println(tree.isSumTree(head2, sum));
	//	tree.convertSumTree(head2);
	//	tree.inorder(head2);
	//	tree.boundaryTrav(head2);
		/*
		tree.doubleTree_inorder(head2);
		tree.inorder(head2);
		tree.doubleTree_preorder(head2);
		tree.inorderIterative(head2);*/
	//	tree.doubleTree_postorder(head2);
	//	tree.inorderIterative(head2);
		
	//	System.out.println(tree.isSumEqual(head2, 22));
	//	int[] in = {4,2,5,1,3,6};
	//	int[] pre = {1,2,4,5,3,6};
	//	tree.printTreeInPre(in, pre, 0, 5);
	/*	Wrapper_pre preIndex = new Wrapper_pre();
		TreeInt root = tree.constructPrePost(in, post, preIndex, 0, 8);
		tree.inorder(root);
	
 * Wrapper_pre preIndex = new Wrapper_pre();
		TreeInt root = tree.treeInPre(in, pre, preIndex, 0, 5);
		tree.inorder(root);
		System.out.println();
		tree.inorderIterative(root);
		System.out.println();
		tree.inOrderTrav(root);
		*/
	//	System.out.println(tree.average(head2));
	//	Wrapper_height h = new Wrapper_height();
	//	System.out.println(tree.diameter(head));
	//	System.out.println(tree.diameter_opt(head, h));
	//	tree.childrenSum(head);
	//	tree.levelOrder_opt(head);
	/*	TreeInt result = tree.treeToList(head);
		TreeInt cur = result;
		do {
			result.display();
			result = result.right;
		}while(result!=cur);
		*/
	//	int[] arr = new int[10];
	//	tree.printRootLeafPath(head, arr,0);
	//	TreeInt result = tree.getMirror(head);
	//	tree.inorder(result);
	//	System.out.println(tree.isIdentical(head, head2));
	//	System.out.println(tree.height(head));
	//	System.out.println(tree.size(tree.head));
		
		
		
	/*	System.out.print("Inorder traversal: ");
		tree.inorder(tree.head);
		System.out.println();
		
		System.out.print("Preorder Traversal: ");
		tree.preorder(tree.head);
		System.out.println();
		
		System.out.print("PostOrder Traversal: ");
		tree.postorder(tree.head);
		System.out.println();
		*/
/*		ThreadedTreeInt thread_tree = new ThreadedTreeInt(10);
		thread_tree.left = new ThreadedTreeInt(8);
		thread_tree.right = new ThreadedTreeInt(2);
		thread_tree.left.left = new ThreadedTreeInt(3);
		Wrapper_Node prev = new Wrapper_Node();
		tree.populateInorder(thread_tree, prev);
		
		System.out.println("next right of"+thread_tree.data+" is"+thread_tree.rightThread==null?"null":thread_tree.rightThread.data);
		System.out.println("next right of"+thread_tree.left.data+" is"+thread_tree.left.rightThread==null?"null":thread_tree.left.rightThread.data);
		System.out.println("next right of"+thread_tree.right.data+" is"+(thread_tree.right.rightThread==null?"null":thread_tree.right.rightThread.data));
		System.out.println("next right of"+thread_tree.left.left.data+" is"+thread_tree.left.left.rightThread==null?"null":thread_tree.left.left.rightThread.data);
		*/
	}
}


/*
 * Utility class
 * 
 * Definition of node in a tree
 * 
 */
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

/*
 * Utility Class
 * Definition of a node in a Threaded binary tree
 */
class ThreadedTreeInt {
	public int data;
	public ThreadedTreeInt left;
	public ThreadedTreeInt right;
	public ThreadedTreeInt rightThread;
	
	public ThreadedTreeInt(int val) {
		data = val;
		left = null;
		right = null;
		rightThread  = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

/*
 * Utility class:
 * Definition of a node in the tree
 */
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

/*
 * Utility class;
 * A Wrapper class holding height variable
 */
class Wrapper_height {
	public int height=0;
}

/*
 * Utility class
 * A Wrapper class holding count of nodes and their sum
 */
 class Wrapper_average {
	 public int count=0;
	 public int sum=0;
 }
 
 class Wrapper_average2 {
	 public int count=Integer.MAX_VALUE;
	 public int sum=0;
 }
 
 /* 
  * Utility Class
  * A wrapper class holding the index of preOrder array
  */
 class Wrapper_pre {
	 public int index=0;
 }
 
 /*
  * Utility class
  * A wrapper class holding a threadedtreeNode
  */
 class Wrapper_Node {
	 public ThreadedTreeInt prev = null;
 }
 /*
  * Utility class
  * A wrapper class holding a treeNode
  */
 class Wrapper_UTNode {
	 public TreeInt prev = null;
 }
 
 /*
  * Utility class
  * A wrapper class holding two sums 
  */
 class Wrapper_sums {
	 public int sum_odd = 0;
	 public int sum_even = 0;
 }
 
 class Wrapper_bool {
	 public boolean isN1=false;
	 public boolean isN2=false;
 }
 
 class Wrapper_Distance {
	 public int d1 = 0;
	 public int d2 = 0;
	 public int dist=0;
 }
 
 /*
  * Utility class
  * A wrapper class to define a node in the tree with random pointers
  */
 class TreeIntRan {
	 public int data;
	 public TreeIntRan left;
	 public TreeIntRan right;
	 public TreeIntRan random;
	 
	 public TreeIntRan( int data) {
		 this.data = data;
		 left=null;right=null;random=null;
	 }
	 
	 public void display() {
		 System.out.print(data+" ");
	 }
 }
