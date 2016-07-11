
public class SpecialTreesApp {

	public static void main(String args[])
	{
		SpecialTrees s = new SpecialTrees();
		
		int[] pre = {1,2,4,8,9,5,3,6,7};
		int[] post = {8,9,4,5,2,6,7,3,1};
		
		s.special(pre, post);
	}
}
