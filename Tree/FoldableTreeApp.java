
public class FoldableTreeApp {
	public static void main(String args[])
	{
		FoldableTree ft = new FoldableTree();
		ft.insert(4);
		ft.insert(8);
		ft.insert(5);
		ft.insert(2);
		ft.insert(3);
		ft.insert(1);
	//	ft.FoldTree();
	//	ft.foldUtil();
	//	ft.printNodes(2);
		ft.nodeLevel(4);
	}
}
