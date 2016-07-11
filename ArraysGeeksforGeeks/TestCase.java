
public class TestCase {

	public void med(int[] arr1)
	{
		int sum = Integer.MAX_VALUE;
		int start = 0;
		int end = arr1.length-1;
		int temp;
		while(start<end)
		{
			temp = arr1[start]+arr1[end];
			if(Math.abs(temp)<sum)
				sum = temp;
			if(temp<0)
				start++;
			else
				end--;
		}
		System.out.println(sum);
	}
	
	public static void main(String args[])
	{
		int[] arr = {1,2,-15,4,30,-25};
	}
}
