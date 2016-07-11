
public class InorderPostOrderApp {

	public static void main(String args[])
	{
		int[] in = {4,8,10,12,14,20,22};
		int[] post = {4,10,14,12,8,22,20};
		
		InorderPostOrder i = new InorderPostOrder();
		
		i.construct(in, post);
	}
}
