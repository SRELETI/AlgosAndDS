
public class BoundaryTraversal {

	private TreeInt root;
	
	public BoundaryTraversal () {
		root = null;
	}
	
	public void boundary(TreeInt temp) {
		if(temp == null)
			return;
		System.out.print(temp.data+" ");
		printLeft(temp.left);
		printBottom(temp);
		printRight(temp.right);
	}
	
	private void printLeft(TreeInt temp) {
		
		if(temp!=null)
		{ 	
			if(temp.left!=null)
			{
				System.out.print(temp.data+" ");
				printLeft(temp.left);
			}
			else if(temp.right!=null)
			{
				System.out.print(temp.data+" ");
				printLeft(temp.right);
			}
		}
	}
	
	private void printBottom(TreeInt temp) {
		if(temp==null)
			return;
		if(temp.left==null && temp.right==null)
		{
			System.out.print(temp.data+" ");
			return;
		}
		printBottom(temp.left);
		printBottom(temp.right);
	}
	
	private void printRight(TreeInt temp) {
		if(temp!=null)
		{
			if(temp.right!=null)
			{
				printRight(temp.right);
				System.out.print(temp.data+" ");
			}
			else if(temp.left!=null)
			{
				printLeft(temp.left);
				System.out.print(temp.data+" ");
			}
		}
	}
	
	public static void main(String args[]) {
		BoundaryTraversal b = new BoundaryTraversal() ;
		b.root = new TreeInt(20);
		b.root.left = new TreeInt(8);
		b.root.right = new TreeInt(22);
		b.root.left.left = new TreeInt(4);
		b.root.left.right = new TreeInt(12);
		b.root.left.right.left = new TreeInt(10);
		b.root.left.right.right = new TreeInt(14);
		b.root.right.right = new TreeInt(25);
		
		b.boundary(b.root);
	}
 } 
