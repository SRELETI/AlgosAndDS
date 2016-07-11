
public class ArrSubApp {

	public static void main(String args[])
	{
		ArrSub a = new ArrSub(10,10);
		
		int[] arr1 = {1,2,2,4};
		int[] arr2 = {1,2,4};
		
		System.out.println(a.isSubset(arr1, arr2));
		System.out.println(a.isSubSET(arr1, arr2));
		
	}
}
