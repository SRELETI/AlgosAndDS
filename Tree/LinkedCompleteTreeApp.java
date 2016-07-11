
public class LinkedCompleteTreeApp {

	public static void main(String args[])
	{
		LinkedCompleteTree l = new LinkedCompleteTree(20);
		
		for(int i=1;i<=10;i++)
			l.insert(i);
		l.level();
	}
}
