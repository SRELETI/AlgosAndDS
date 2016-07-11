
public class ShellSortApp {
	public static void main(String args[])
	{
		ShellSort2 ss = new ShellSort2(10);
		ss.add(5);
		ss.add(7);
		ss.add(3);
		ss.add(10);
		ss.add(6);
		ss.add(8);
		ss.add(4);
		ss.add(9);
		ss.add(2);
		ss.add(1);
		ss.display();
		ss.shellSort();
		ss.display();
	}
}
