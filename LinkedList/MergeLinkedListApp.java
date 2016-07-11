
public class MergeLinkedListApp {
	public static void main(String args[])
	{
		MergeLinkedList mll = new MergeLinkedList();
		mll.addFront(15);
		mll.addFront(10);
		mll.addFront(5);
		mll.addFront2(35);
		mll.addFront2(25);
		mll.addFront2(20);
		mll.addFront2(3);
		mll.addFront2(2);
		mll.display();
		mll.display2();
		mll.mergeLists();
		mll.display_res();
	}
}
