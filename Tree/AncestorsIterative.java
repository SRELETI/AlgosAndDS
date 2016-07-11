
public class AncestorsIterative {

	private TreeInt root;
	
	public AncestorsIterative() {
		root = null;
	}
	
	public void ancestors(TreeInt temp, int key) {
		if(temp==null)
			return;
		StackTree s = new StackTree();
		while(true)
		{
			while(temp!=null && temp.data!=key)
			{
				s.push(temp);
				temp = temp.left;
			}
			if(temp!=null && temp.data==key)
				break;
			if(s.peek().right==null)
			{
				temp = s.pop();
				
				while(!s.isEmpty() && s.peek().right==temp)
					temp = s.pop();
			}
			temp = s.isEmpty() ? null : s.peek().right;
		}
		while(!s.isEmpty())
			s.pop().display();
	}
	
	public static void main(String args[]) {
		AncestorsIterative a = new AncestorsIterative();
		a.root = new TreeInt(1);
		a.root.left = new TreeInt(2);
		a.root.right = new TreeInt(3);
		a.root.left.left = new TreeInt(4);
		a.root.left.right = new TreeInt(5);
		a.root.right.left  = new TreeInt(6);
		a.root.right.right = new TreeInt(7);
		a.root.left.left.left = new TreeInt(8);
		a.root.left.right.right = new TreeInt(9);
		a.root.right.right.left = new TreeInt(10);
		for(int i=1;i<=10;i++)
		{
			a.ancestors(a.root, i);
			System.out.println();
		}
	}
}
