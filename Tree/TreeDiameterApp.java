
public class TreeDiameterApp {
	public static void main(String args[])
	{
		TreeDiameter td = new TreeDiameter();
		td.insert(5);
		td.insert(4);
		td.insert(6);
		//td.insert(3);
		td.heightBalance();
		td.optHeightBalanc();
	}
}
