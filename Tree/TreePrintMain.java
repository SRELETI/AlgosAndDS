
public class TreePrintMain {
	public static void main(String args[])
	{
		TreePrintInter tp = new TreePrintInter();
		tp.insert(5);
		tp.insert(3);
		tp.insert(2);
		tp.insert(6);
		tp.insert(4);
		//tp.printPaths();
		tp.spiral_iterative();
	}
}
