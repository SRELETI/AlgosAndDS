
public class LevelTreeApp {

	public static void main(String args[])
	{
		LevelTree l = new LevelTree();
		l.head = new TreePrint(3);
		l.head.left = new TreePrint(2);
		l.head.right = new TreePrint(5);
		l.head.left.left = new TreePrint(1);
		l.head.left.right = new TreePrint(4);
		
		l.getLevel(5);
	}
}
