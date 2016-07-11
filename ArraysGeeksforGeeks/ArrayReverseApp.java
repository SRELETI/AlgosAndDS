
public class ArrayReverseApp {
	public static void main(String args[])
	{
		int length=5;
		ArrayReverse ar = new ArrayReverse(length);
		ar.insert(5);
		ar.insert(4);
		ar.insert(3);
		ar.insert(2);
		ar.insert(1);
		ar.display();
		ar.reverseRec(0,4);
		ar.display();
	}
}
