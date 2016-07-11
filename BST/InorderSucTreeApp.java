
public class InorderSucTreeApp {

	public static void main(String args[])
	{
		InorderSucTree i = new InorderSucTree();
		
		i.insert(20);
		i.insert(8);
		i.insert(22);
		i.insert(4);
		i.insert(12);
		i.insert(10);
		i.insert(14);
		
		TreePrint result = i.inorderSuc(i.head, i.head.left.right);
		System.out.println(result == null ? null : result.data);
	}
}
