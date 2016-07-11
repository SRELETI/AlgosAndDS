
public class MoveLastToFirstApp {
	public static void main(String args[])
	{
		MoveLastToFirst ml = new MoveLastToFirst();
		ml.addFront(4);
		ml.addFront(3);
		ml.addFront(2);
		ml.addFront(1);
		ml.display();
		ml.moveLast();
		ml.display();
	}
}
