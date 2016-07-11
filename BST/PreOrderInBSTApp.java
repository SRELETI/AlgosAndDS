
public class PreOrderInBSTApp {

	public static void main(String args[])
	{
		PreOrderToBST p = new PreOrderToBST();
		
		int[] arr = {10,5,1,7,40,50};
	//	p.convertToBST(arr);
	//	p.preOrder(arr);
		
		p.consPre(arr);
	}
}
