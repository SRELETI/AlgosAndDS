
public class GetNMain {
	public static void main(String args[])
	{
		GetNEnd g = new GetNEnd();
		g.addFront(4);
		g.addFront(3);
		g.addFront(2);
		g.addFront(1);
		g.display();
		System.out.println(g.getN2(5));
	}
}
