
public class IterativeHeightApp {
	
	public static void main(String args[])
	{
		IterativeHieght i = new IterativeHieght();
		
		i.head = new TreePrint(1);
		i.head.left = new TreePrint(2);
		i.head.right = new TreePrint(3);
	//	i.head.left.left = new TreePrint(4);
		
		i.hei();
	}
}
