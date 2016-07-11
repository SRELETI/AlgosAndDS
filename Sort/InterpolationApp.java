
public class InterpolationApp {
	public static void main(String args[])
	{
		InterpolationSearch is = new InterpolationSearch(5);
		is.add(1);
		is.add(2);
		is.add(3);
		is.add(4);
		is.add(5);
		is.display();
		System.out.println(is.interpolationSearch(1, 1, 5));
		
	}
}
