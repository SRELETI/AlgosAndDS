
public class AncestorsApp {
	public static void main(String args[])
	{
		Ancestors a = new Ancestors();
		a.head.data=26;
		a.head.left.data=10;
		a.head.left.left.data=4;
		a.head.left.right.data=6;
		a.head.right.data=3;
		a.head.right.right.data=3;
		a.sumTree();
	/*	a.insert(5);
		a.insert(7);
		a.insert(3);
		a.insert(4);
		a.insert(2);
		a.insert(1);
		a.anscestors(1); */
	}
}
