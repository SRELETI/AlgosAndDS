
public class MirrorTreeApp {
	public static void main(String args[])
	{
		MirrorTree mt = new MirrorTree();
		mt.insert(4);
		mt.insert(2);
		mt.insert(1);
		mt.insert(3);
		mt.insert(5);
		mt.inorder();
		mt.mirror();
		mt.inorder();
	}
}
