class Wrapper_maxNode {
	int value=Integer.MIN_VALUE;
}
public class MaxSumToLeaf {

	private TreeInt root;
	private TreeInt maxNode;
	public MaxSumToLeaf() {
		root = null;
	}
	
	public void maxNode(TreeInt temp,int sum,Wrapper_maxNode max) {
		if(temp==null)
			return;
		sum = sum+temp.data;
		if(temp.left==null && temp.right==null && sum>max.value)
		{
			max.value = sum;
			maxNode = temp;
			return;
		}
		maxNode(temp.left,sum,max);
		maxNode(temp.right,sum,max);
	}
	
	public boolean maxPrint(TreeInt temp) {
		if(temp==null)
			return false;
		if(temp==maxNode)
		{
			System.out.print(temp.data+" ");
			return true;
		}
		if(maxPrint(temp.left)|| maxPrint(temp.right))
		{
			System.out.print(temp.data+" ");
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[]) {
		MaxSumToLeaf m = new MaxSumToLeaf();
		
		m.root = new TreeInt(10);
		m.root.left = new TreeInt(-2);
		m.root.right = new TreeInt(7);
		m.root.left.left = new TreeInt(8);
		m.root.left.right = new TreeInt(-4);
		Wrapper_maxNode m2 = new Wrapper_maxNode();
		m.maxNode(m.root, 0, m2);
		m.maxPrint(m.root);
		System.out.print("Max sum is "+m2.value);
	}
}
