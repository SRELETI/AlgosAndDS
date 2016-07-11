
public class DeleteRecApp {
	public static void main(String args[])
	{
		DeleteRec dr = new DeleteRec();
		dr.add(5);
		dr.add(4);
		dr.add(3);
		dr.add(2);
		dr.add(1);
		dr.remove();
		dr.display();
		dr.delete(dr.head);
		dr.display();
	}
}
