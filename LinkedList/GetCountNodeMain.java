
public class GetCountNodeMain {
	public static void main(String args[])
	{
		GetCountNode gcn = new GetCountNode();
		gcn.addFront(4);
		gcn.addFront(3);
		gcn.addFront(2);
		gcn.addFront(1);
		gcn.addFront(1);
		gcn.display();
		//gcn.deleteNode();
		//gcn.display();
		gcn.getCount(5);
	}
}
