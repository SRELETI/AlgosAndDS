
public class RemoveDupSorApp {
	public static void main(String args[])
	{
		RemoveDupSor rds = new RemoveDupSor();
		rds.addFirst(60);
		rds.addFirst(43);
		rds.addFirst(43);
		rds.addFirst(21);
		rds.addFirst(11);
		rds.addFirst(11);
		rds.addFirst(11);
		rds.display();
		rds.removeDup();
		rds.display();
	}
}
