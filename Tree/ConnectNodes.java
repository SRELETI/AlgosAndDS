class TreeConnect {
	int data;
	TreeConnect left;
	TreeConnect right;
	TreeConnect nextRight;
	
	public TreeConnect(int val) {
		data = val;
		left = null;
		right = null;
		nextRight = null;
	}
	
	public void display() {
		System.out.print(data+ " ");
	}
}
public class ConnectNodes {

	private TreeConnect root;
	
	public ConnectNodes() {
		root = null;
	}
	
	public void connect(TreeConnect temp) {
		if(temp == null)
			return;
		temp.nextRight = null;
		while(temp!=null)
		{
			TreeConnect q = temp;
			while(q!=null)
			{
				if(q.left!=null)
				{
					if(q.right!=null)
					{
						q.left.nextRight = q.right;
					}
					else
						q.left.nextRight = getNextRight(q);
				}
				if(q.right!=null)
				{
					if(q.nextRight!=null)
						q.right.nextRight = getNextRight(q);
					else
						q.right.nextRight = null;
				}
				q = q.nextRight;
			}
			
				if(temp.left!=null)
					temp = temp.left;
				else if(temp.right!=null)
					temp = temp.right;
				else 
					temp = getNextRight(temp);
		}
		
	}
	
	public void connect_rec(TreeConnect temp) {
		if(temp == null)
			return;
		temp.nextRight = null;
		connect_now(temp);
	}
	
	private void connect_now(TreeConnect temp) {
		if(temp == null)
			return;
		if(temp.nextRight!=null)
			connect_now(temp.nextRight);
		if(temp.left!=null)
		{
			if(temp.right!=null)
			{
				temp.left.nextRight = temp.right;
				temp.right.nextRight = getNextRight(temp);
			}
			else
			{
				temp.left.nextRight = getNextRight(temp);
			}
			connect_now(temp.left);
		}
		if(temp.right!=null)
		{
			temp.right.nextRight = getNextRight(temp);
			connect_now(temp.right);
		}
		else
			connect_now(getNextRight(temp));
	}
	private TreeConnect getNextRight(TreeConnect temp) {
		TreeConnect now  = temp.nextRight;
		while(now!=null)
		{
			if(now.left!=null)
				return now.left;
			else if(now.right!=null)
				return now.right;
			else 
				now = now.nextRight;
		}
		return null;
	}
	
	public static void main(String args[]) {
		ConnectNodes c = new ConnectNodes();
		c.root = new TreeConnect(10);
		c.root.left = new TreeConnect(8);
		c.root.right = new TreeConnect(2);
		c.root.left.left = new TreeConnect(3);
		c.root.right.right = new TreeConnect(90);
		
		c.connect_now(c.root);
		System.out.println((c.root.nextRight==null) ? "null" : c.root.nextRight.data);
		System.out.println((c.root.left.nextRight==null) ? "null":c.root.left.nextRight.data);
		System.out.println((c.root.right.nextRight==null) ? "null":c.root.right.nextRight.data);
		System.out.println((c.root.left.left.nextRight==null) ? "null":c.root.left.left.nextRight.data);
		System.out.println((c.root.right.right.nextRight==null) ? "null":c.root.right.right.nextRight.data);
		
		
	}
}
