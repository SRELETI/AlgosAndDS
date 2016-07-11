
public class ArrayObjectApp {
	public static void main(String args[])
	{
		int length=20;
		ArrayClass ac;
		ac=new ArrayClass(length);
		ac.insert("eleti", "sudeep", 24);
		ac.insert("eletis", "Sandeep", 25);
		ac.insert("elet", "Venkat ram Reddy", 48);
		ac.display();
		ac.find("eleti");
	}
}
