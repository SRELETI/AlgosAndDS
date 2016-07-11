
public class LinkListApp {
	public static void main(String args[])
	{
		LinkList ll=new LinkList();
		ll.insertFirst(2, 1234545);
		ll.insertFirst(3, 2344556);
		ll.insertFirst(4, 4567678);
		ll.display();
		ll.find(5);
		//ll.deleteKey(3);
		ll.insertAfter(4, 5, 3456677);
		System.out.println("After deletion");
		ll.display();
	}
}
