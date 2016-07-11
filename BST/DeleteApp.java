
public class DeleteApp {

	public static void main(String args[])
	{
		Delete d = new Delete();
		d.insert(50);
		d.insert(30);
		d.insert(70);
		d.insert(20);
		d.insert(40);
		d.insert(60);
		d.insert(80);
		
	//	d.printInorder();
		
		d.deleteNode(20);
		
		System.out.println();
		
		d.printInorder();
	}
}
