import java.util.Arrays;


public class SegArr {

	public void seg(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		while(start<end)
		{
			while(arr[start]%2==0 && start<end)
				start++;
			while(arr[end]%2==1 && start<end)
				end--;
			if(start<end)
			{
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[])
	{
		SegArr s = new SegArr();
		int[] arr = {12,34,45,9,8,90,3};
		s.seg(arr);
	}
}
