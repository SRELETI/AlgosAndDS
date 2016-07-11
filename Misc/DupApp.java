
public class DupApp {
	public static void main(String args[])
	{
		int length=5;
		Dup d=new Dup(length);
		d.insert(1);
		d.insert(5);
		d.insert(2);
		d.insert(6);
		d.insert(4);
		d.display();
		//d.removeDup();
		d.OddEvenSort();
		d.display();
	}
}
