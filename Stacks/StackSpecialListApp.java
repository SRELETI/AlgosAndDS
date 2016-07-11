
public class StackSpecialListApp {
	public static void main(String args[])
	{
		StackSpecialList ssl = new StackSpecialList();
		//ssl.push(5);
		//ssl.push(4);
		ssl.push(6);
		ssl.push(7);
		ssl.push(6);
		System.out.println(ssl.getMin());
	}
}
