
public class LinkListINUNApp {

	public static void main(String args[])
	{
		LinkListINUN l = new LinkListINUN();
		
		l.insert(20);
		l.insert(4);
		l.insert(15);
		l.insert(10);
		
		l.insert2(10);
		l.insert2(2);
		l.insert2(4);
		l.insert2(8);
		
	//	l.union();
	//	l.intersection();
	//	l.display(l.result);
		
	//	l.union_hash();
		l.intersection_hash();
	}
	
}
