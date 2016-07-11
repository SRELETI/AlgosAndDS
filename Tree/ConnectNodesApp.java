
public class ConnectNodesApp {
	
	public static void main(String args[])
	{
		ConnectNodes_new c = new ConnectNodes_new ();
		c.head = new TreePrintExt(1);
		c.head.left = new TreePrintExt(2);
		c.head.right = new TreePrintExt(3);
		
		c.connect(c.head);
		
		System.out.println(c.head.left.rightExt.data);
		System.out.println(c.head.right.rightExt);
	}
}
