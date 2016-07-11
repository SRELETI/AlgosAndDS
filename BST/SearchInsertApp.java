
public class SearchInsertApp {

	public static void main(String args[])
	{
		SearchInsertRev s = new SearchInsertRev();
		
		s.insert(8);
		s.insert(3);
		s.insert(10);
		s.insert(1);
		s.insert(6);
		s.insert(4);
		s.insert(7);
		s.insert(14);
		s.insert(13);
		
	//	s.inorder();
		TreePrint node = s.findNode(11);
		System.out.println(node == null ? null : node.data);
	}
}
