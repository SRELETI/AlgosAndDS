import java.util.Arrays;
import java.util.Stack;

/*
 * Implementation of different functions in Binary Search Tree
 * 
 * In Binary Search Tree, 
 * All the elements on the left side of the root are less than root
 * All the elements on the right side of the root are greater than root
 * The left subtree and right subtree are also binary search tree
 */
public class BSTAllInOne {

	// Pointer to the root node
	public TreeInt root;
	//Constructor
	public BSTAllInOne() {
		root = null;
	}
	// Iterative method to insert a node into the BST
	// ALways insertion happens at the leaf node in BST, the parent pointer is used
	// to accessing parent, so that when leaf node is reached, then the new node is attached to either left or 
	// right of the parent.
	public boolean insert(int key) {
		TreeInt newNode = new TreeInt(key);
		if(root==null) {
			root = newNode;
			return true;
		}
		TreeInt temp = root;
		while(true) {
			TreeInt parent = temp;
			// goes to this branch if key is less than root node
			if(key<temp.data) {
				temp = temp.left;
				if(temp==null) {
					parent.left = newNode;
					return true;
				}
			}
			// goes to this branch is key is greater than root node
			else {
				temp = temp.right;
				if(temp==null) {
					parent.right = newNode;
					return true;
				}
			}
		}
	}
	// Recursive method to insert a node into the BST 
	public TreeInt insert(TreeInt node, int key) {
		// If BST is empty, insert a new Node into the BST, base condition
		if(node == null) return new TreeInt(key);
		// If key less than root node,then go to left side of the tree, as left side will of tree will be updated, the result is stored
		// in left node of the root
		if(key<node.data){
			node.left = insert(node.left,key);
		}
		// similarly for the right node
		else if(key>node.data) {
			node.right = insert(node.right,key);
		}
		// returns the root after the node is inserted
		return node;
	}
	
	// Iterative method for searching in a BST
	public boolean search(int key) {
		// if BST is empty, return false
		if(root==null) return false;
		TreeInt temp = root;
		// iterate over the BST to find the key
		while(temp!=null) {
			// if found, return true
			if(temp.data==key) return true;
			// if key less than root node, then search in left sub tree
			if(key<temp.data) {
				temp = temp.left;
			}
			// else search in  right subtree
			else temp = temp.right;
		}
		return false;
	}
	
	// Recursive method for searching in a BST
	public boolean search(TreeInt node, int key) {
		// if tree is empty, return false
		if(node==null) return false;
		// if found , return true
		if(node.data==key) return true;
		// search in left sub tree if key less than node's data
		else if(key<node.data) return search(node.left,key);
		// search in right sub tree if key is greater than node's data
		else return search(node.right,key);
	}
	
	// Delete function.
	// Three cases to look for, while deleting a node from BST
	// if node to be deleted is leaf node, then just return null
	// if node to be deleted has only one child, then return that child
	// if node to be deleted has two childs, then replace the node with inorder suc's key and call delete function
	// to delete the inorder successor
	public TreeInt delete(TreeInt node, int key) {
		if(node==null) return null;
		if(node.data==key) {
			if(node.left==null) {
				return node.right;
			}
			else if(node.right==null)
				return node.left;
			else {
				TreeInt suc = getMin(node.right);
				node.data = suc.data;
				node.right = delete(node.right,suc.data);
			}
		}
		else if(key<node.data) 
			node.left = delete(node.left,key);
		else 
			node.right = delete(node.right,key);
		return node;
	}
	
	// Utility method for finding the getting the smallest element in the tree.
	private TreeInt getMin(TreeInt node) {
		while(node.left!=null) 
			node = node.left;
		return node;
	}
	
	// Inorder predecessor and inorder successor of a key in a BST
	public void preSuc(int key) {
		// Stores the predecessor
		Wrapper_Pre1 node1 = new Wrapper_Pre1();
		// Stores the successor
		Wrapper_Suc node2 = new Wrapper_Suc();
		// utility function which finds pre and suc
		preSucUtils(root,key,node1,node2);
		// print them
		System.out.println("Predecessor is "+(node1==null?"null":node1.pre .data)+" And Successor is "+(node2==null?"null":node2.suc.data));
	}
	
	
	private void preSucUtils(TreeInt node, int key, Wrapper_Pre1 node1, Wrapper_Suc node2) {
		if(node==null) return;
		// If key is found, and key has left and right subtrees, then pre and suc are found in the subtrees, caculate them
		if(node.data==key) {
			if(node.left!=null) {
				TreeInt temp = node.left;
				while(temp.right!=null) 
					temp = temp.right;
				node1.pre = temp;
			}
			if(node.right!=null) {
				TreeInt temp = node.right;
				while(temp.left!=null) 
					temp = temp.left;
				node2.suc = temp;
			}
			return;
		}
		// if key less than node data, then node becomes predecessor of its right child
		if(key<node.data) {
			node2.suc = node;
			preSucUtils(node.left,key,node1,node2);
		}
		// similarly key becomes successor of its left child
		else {
			node1.pre = node;
			preSucUtils(node.right,key,node1,node2);
		}
	}
	
	/* 
	 * Check if a binary tree is a BST
	 * 
	 * A binary tree is a bst, if the root is greater than max element(predecessor) in the left subtree and 
	 * root is less than min element(Successor) in the right subtree. and
	 * left subtree and right subtree are also bst's
	 */
	public boolean isBST(TreeInt node) {
		return isBSTUtils(node,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	// utility function for checking if the tree is BST or not
	// the min and max are the valid values for the node for the tree to be BST
	private boolean isBSTUtils(TreeInt node, int min, int max) {
		// if node is null, it is a BST
		if(node==null) return true;
		// if node's value is outside that range, then return false
		if(node.data<min || node.data>max) return false;
		// check for left and right subtree by narrowing down the possible values for each node
		return isBSTUtils(node.left, min,node.data-1) && isBSTUtils(node.right,node.data+1,max);
	}
	
	/*
	 * Checking if the tree is a BST 
	 * Second method, based on Inorder traversal of the BST
	 */
	public boolean isBST_Inorder(TreeInt node) {
		Wrapper_PrevPointer pre = new Wrapper_PrevPointer();
		return isBST_InorderUtils(node,pre);
	}
	
	private boolean isBST_InorderUtils(TreeInt node, Wrapper_PrevPointer pre) {
		if(node==null) return true;
		if(isBST_InorderUtils(node.left,pre)==false)
			return false;
		if(pre.prev!=null && pre.prev.data>=node.data)
			return false;
		pre.prev = node;
		return isBST_InorderUtils(node.right,pre);
	}
	
	
	/*
	 * LCA of n1 and n2 in a BST
	 */
	public TreeInt findLCA(TreeInt node, int n1, int n2) {
		Wrapper_LCA check = new Wrapper_LCA();
		TreeInt result = isFindLCAUtils(node,n1,n2,check);
		if((check.n1!=false && findUtils(result,n2)) || (check.n2==true && findUtils(result,n1))) 
			return result;
		else if(check.n1==false && check.n2==false) {
			if(n1<n2) {
				if(findUtils(result.left,n1) && findUtils(result.right,n2))
					return result;
			}
			else  { 
				if(findUtils(result.left,n2) && findUtils(result.right,n1))
					return result;
			}
		}
		return null;
	}
	
	private boolean findUtils(TreeInt node, int val) {
		if(node == null ) return false;
		if(node.data == val) return true;
		return findUtils(node.left,val) || findUtils(node.right,val);
	}
	
	private TreeInt isFindLCAUtils(TreeInt node, int n1, int n2, Wrapper_LCA check) {
		if(node==null) return null;
		if(node.data==n1) {
			check.n1= true;
			return node;
		}
		if(node.data==n2) {
			check.n2 = true;
			return node;
		}
		if(n1<node.data && n2<node.data)
			return isFindLCAUtils(node.left,n1,n2,check);
		if(n1>node.data && n2>node.data)
			return isFindLCAUtils(node.right,n1,n2,check);
		return node;
	}
	
	/*
	 * Kth smallest element in the BST
	 */
	public void kthSmallest(TreeInt node , int k) {
		Wrapper_Counter inc = new Wrapper_Counter();
		kthSmallestUtils(node,inc,k);
	}
	
	private void kthSmallestUtils(TreeInt node,Wrapper_Counter inc, int k) {
		if(node!=null) {
			kthSmallestUtils(node.left,inc,k);
			inc.count++;
			if(inc.count==k) {
				System.out.println("The "+k+"th smallest element is "+node.data);
			}
			kthSmallestUtils(node.right,inc,k);
		}
	}
	
	public void printBSTKeysRange(TreeInt node, int k1, int k2) {
		if(node==null)
			return;
		if(node.data>k1) 
			printBSTKeysRange(node.left,k1,k2);
		if(k1<=node.data && node.data<=k2)
			node.display();
		if(node.data<k2) 
			printBSTKeysRange(node.right,k1,k2);
	}
	
	/*
	 * Sorted array to balanced BST
	 */
	public TreeInt consBSTArr(int[] arr, int start, int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeInt root = new TreeInt(arr[mid]);
		root.left = consBSTArr(arr,start,mid-1);
		root.right = consBSTArr(arr,mid+1,end);
		return root;
	}
	
	/*
	 * Inorder Traversal
	 */
	public void inorder(TreeInt node) {
		if(node!=null)  {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	/*
	 * Remove keys outside a range of values
	 */
	public TreeInt removeKeys(TreeInt node, int n1, int n2) {
		if(node==null) return null;
		node.left = removeKeys(node.left,n1,n2);
		node.right = removeKeys(node.right,n1,n2);
		if(node.data<n1) {
			return node.right;
		}
		if(node.data>n2) {
			return node.left;
		}
		return node;
	}
	
	/*
	 * Check if a triplet is equal to zero in a BST
	 */
	public boolean isPresentTriplet(TreeInt node) {
		if(node==null)
			return false;
		Wrapper_Nodes list = new Wrapper_Nodes();
		convertBSTToList(node,list);
		return checkTripletList(list);
	}
	
	private boolean checkTripletList(Wrapper_Nodes list) {
		if(list.head==null) return false;
		TreeInt temp = list.head;
		while(temp.right!=list.tail && temp.data<0) {
			if(checkValue(temp.right,list.tail,-temp.data))
				return true;
			temp = temp.right;
		}
		return false;
	}
	
	private boolean checkValue(TreeInt start, TreeInt end, int val) {
		while(start!=end) {
			int value = start.data+end.data;
			if(value<val) {
				start = start.right;
			}
			else if(value>val) 
				end = end.left;
			else 
				return true;
		}
		return false;
	}
	
	private void convertBSTToList(TreeInt node, Wrapper_Nodes list) {
		if(node==null) return;
		convertBSTToList(node.left,list);
		if(list.head==null) {
			list.head = node;
			list.tail= node;
		}
		else {
			list.tail.right = node;
			node.left = list.tail;
			list.tail = list.tail.right;
		}
		convertBSTToList(node.right,list);
	}
	
	public TreeInt mergeTwoBSTs(TreeInt node1, TreeInt node2) {
		if(node1==null && node2==null) return null;
		if(node1==null) return node2;
		if(node2==null) return node1;
		Wrapper_Nodes list = new Wrapper_Nodes();
		convertBSTToList2(node1,list);
		Wrapper_Nodes list2 = new Wrapper_Nodes();
		convertBSTToList(node2,list2);
		TreeInt mergedList = merge(list.head,list2.head);
		int count = getCount(mergedList);
		list.head= mergedList;
		list.tail= null;
		return convertListToBST(list,count);
	}
	
	private int getCount(TreeInt node) {
		int  count = 0;
		while(node!=null) {
			count++;
			node = node.right;
		}
		return count;
	}
	
	private TreeInt convertListToBST(Wrapper_Nodes list, int count) {
		if(count<=0) return null;
		TreeInt left = convertListToBST(list,count/2);
		TreeInt root = list.head;
		root.left = left;
		list.head = list.head.right;
		root.right = convertListToBST(list,count-count/2-1);
		return root;
	}
	
	private void convertBSTToList2(TreeInt node1,Wrapper_Nodes list) {
		if(node1==null) return;
		convertBSTToList2(node1.left,list);
		if(list.head==null) 
			list.head = node1;
		else {
			list.tail.right = node1;
			node1.left = list.tail;
		}
		list.tail = node1;
		convertBSTToList2(node1.right,list);
	}
	
	private TreeInt merge(TreeInt node1, TreeInt node2) {
		if(node1==null) return node2;
		if(node2==null) return node1;
		
		TreeInt result = new TreeInt(0);
		TreeInt tmp = result;
		while(node1!=null && node2!=null) {
			if(node1.data<node2.data) {
				tmp.right = new TreeInt(node1.data);
				node1 = node1.right;
			}
			else if (node1.data>node2.data){
				tmp.right = new TreeInt(node2.data);
				node2 = node2.right;
			}
			else {
				tmp.right = new TreeInt(node1.data);
				node1 = node1.right;
				node2 = node2.right;
			}
			tmp = tmp.right;
		}
		
		while(node1!=null) {
			tmp.right = new TreeInt(node1.data);
			node1 = node1.right;
			tmp = tmp.right;
		}
		while(node2!=null) {
			tmp.right = new TreeInt(node2.data);
			node2 = node2.right;
			tmp = tmp.right;
		}
		return result.right;
	}
	
	/*
	 * Construct BST from  a given preorder traversal 
	 */
	public TreeInt constBSTPre(int[] pre) {
		Wrapper_Counter index = new Wrapper_Counter();
		return constBSTPreUtils(pre,index,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	
	private TreeInt constBSTPreUtils(int[] pre, Wrapper_Counter index, int max, int min) {
		if(index.count>=pre.length)
			return null;
		TreeInt root = null;
		if(pre[index.count]>min && pre[index.count]<max) {
			root = new TreeInt(pre[index.count++]);
			root.left = constBSTPreUtils(pre,index,root.data,min);
			root.right = constBSTPreUtils(pre,index,max,root.data);
		}
		return root;
	}
	
	/*
	 * Kth largest element in a BST
	 */
	public int kthLargest(TreeInt node, int k) {
		Wrapper_Counter count = new Wrapper_Counter();
		kthLargestUtils(node,count,k);
		return count.count;
	}
	
	private void kthLargestUtils(TreeInt node, Wrapper_Counter count,int k) {
		if(node==null) return;
		kthLargestUtils(node.right,count,k);
		count.count++;
		if(count.count==k) {
			System.out.println(k+"th largest element is "+node.data);
			return;
		}
		kthLargestUtils(node.left,count,k);
	}
	
	/*
	 * Transform a BST to greater sum tree
	 */
	public void bstToGreaterBST(TreeInt root) {
		Wrapper_Counter sum = new Wrapper_Counter();
		bstToGreaterBST(root,sum);
	}
	
	private void bstToGreaterBST(TreeInt root, Wrapper_Counter sum) {
		if(root==null) return;
		bstToGreaterBST(root.right,sum);
		sum.count +=root.data;
		root.data = sum.count-root.data;
		bstToGreaterBST(root.left,sum);
	}
	
	/*
	 * Convert binary tree to BST
	 */
	public TreeInt convertBTtoBST(TreeInt node) {
		Wrapper_Counter count = new Wrapper_Counter();
		int[] arr = new int[100];
		inorderTrav(node,arr,count);
		Arrays.sort(arr, 0, count.count);
		return consBSTArr(arr,0,count.count-1);
	}
	
	private void inorderTrav(TreeInt node, int[] arr, Wrapper_Counter count) {
		if(node==null)return;
		inorderTrav(node.left,arr,count);
		arr[count.count++] = node.data;
		inorderTrav(node.right,arr,count);
	}
	
	 /*
	  * Catalan number
	  */
	public int findCatalanNum(int n) {
		if(n==0 || n==1) return 1;
		int sum = 0;
		for(int i=1;i<=n;i++) {
			int left = findCatalanNum(i-1);
			int right = findCatalanNum(n-i);
			sum +=(left*right);
		}
		return sum;
	}
	
	/*
	 * Catalan number - Dynamic programming
	 */
	public int findCatNum(int num) {
		if(num==0 || num==1) return 1;
		int[] arr = new int[num+1];
		arr[0]=arr[1]=1;
		for(int i=2;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				arr[i] += (arr[j-1]*arr[i-j]);
			}
		}
		return arr[num];
	}
	
	/*
	 * Find a pair with the given sum in the BST
	 */
	public void findPair(TreeInt node,int sum) {
		if(node==null) return;
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		
		boolean isDone1 = false;
		boolean isDone2 = false;
		TreeInt temp1 = node;
		TreeInt temp2 = node;
		int val1 = -1;
		int val2= -1;
		while(true) {
			while(isDone1==false) {
				if(temp1!=null) {
					s1.push(temp1);
					temp1 = temp1.left;
				}
				else {
					if(s1.isEmpty()) 
						return;
					temp1 = (TreeInt)s1.pop();
					val1 = temp1.data;
					temp1=temp1.right;
					isDone1=true;
				}
			}
			while(isDone2==false) {
				if(temp2!=null) {
					s2.push(temp2);
					temp2 = temp2.right;
				}
				if(s2.isEmpty())
					return;
				temp2 = (TreeInt) s2.pop();
				val2 = temp2.data;
				isDone2 =true;
				temp2 = temp2.left;
			}
			
			if(val1!=val2 && val1+val2==sum) {
				System.out.println("Found pair "+val1+" and "+val2);
				return;
			}
			if(val1+val2<sum) {
				isDone1=false;
			}
			else if(val1+val2>sum){
				isDone2 = false;
			}
			else if(val1>val2)
				return;
		}
		
	}
	
	/*
	 * Ceil of a value from BST
	 */
	public int ceil(TreeInt node, int val) {
		Wrapper_Counter  count = new Wrapper_Counter();
		ceilUtils(node,val, count);
		return count.count;
	}
	
	private void ceilUtils(TreeInt node, int val, Wrapper_Counter count) {
		if(node==null) return;
		if(node.data==val) {
			count.count= node.data;
			return;
		}
		if(node.data>val) {
			count.count = node.data;
			ceilUtils(node.left,val,count);
		}
		else {
			ceilUtils(node.right,val,count);
		}
	}
	
	
	public static void main(String args[]) {
		BSTAllInOne bst = new BSTAllInOne();
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(2);
		bst.insert(6);
		bst.insert(10);
		bst.insert(14);
	//	System.out.println(bst.search(60));
	//	TreeInt result = bst.findLCA(bst.root, 11, 13);
	//	System.out.println(result==null ? "null":result.data);
	//	bst.printBSTKeysRange(bst.root, 4, 22);
	//	int[] arr = {1,2,3,4,5,6,7};
	//	TreeInt result = bst.consBSTArr(arr, 0, 6);
	//	bst.inorder(result);
	//	bst.inorder(bst.root);
	//	System.out.println();
	//	TreeInt result = bst.removeKeys(bst.root, -10, 13);
	//	bst.inorder(result);
	//	System.out.println(bst.isPresentTriplet(bst.root));
	//	bst.kthLargest(bst.root, 7);
	//	bst.inorder(bst.root);
	//	System.out.println();
	//	bst.bstToGreaterBST(bst.root);
	//	bst.inorder(bst.root);
		TreeInt root = new TreeInt(10);
		root.left = new TreeInt(30);
		root.right = new TreeInt(15);
		root.left.left = new TreeInt(20);
		root.right.right = new TreeInt(5);
		TreeInt result = bst.convertBTtoBST(root);
	//	bst.inorder(result);
	/*	for(int i=0;i<10;i++) {
			int num1= bst.findCatalanNum(i);
			int num2 = bst.findCatNum(i);
			System.out.println(num1+" "+num2);
		}
		*/
		for(int i=0;i<16;i++) {
			System.out.println(bst.ceil(bst.root, i));
		}
	}
}


/*
 * Utility class
 * A wrapper class to store predecessor
 */
class Wrapper_Pre1 {
	public TreeInt pre;
}
/*
 * Utility class
 * A Wrapper class to store successor
 */
class Wrapper_Suc {
	public TreeInt suc;
}

class Wrapper_PrevPointer {
	public TreeInt prev;
}

class Wrapper_LCA {
	public boolean n1;
	public boolean n2;
}

class Wrapper_Counter {
	public int count=0;
}

class Wrapper_Nodes {
	public TreeInt head;
	public TreeInt tail;
}
