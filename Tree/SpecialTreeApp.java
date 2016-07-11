
public class SpecialTreeApp {

	public static void main(String args[])
	{
		int[] arr = {10,30,20,5,15};
		char[] bool ={'N','N','L','L','L'};
		int size = arr.length;
		
		SpecialTreePreOrder s = new SpecialTreePreOrder();
		s.construct(arr, bool, size);
	}
}
