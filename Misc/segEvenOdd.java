import java.util.Arrays;


public class segEvenOdd {
	public static void main(String args[])
	{
		int[] arr = {12,34,45,9,8,90,3};
		seg(arr);
	}
	public static void seg(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
		int left=0;
		int right=arr.length-1;
		while(left<right)
		{
			if(arr[left]%2==0)
				left++;
			if(arr[right]%2!=0 && left<right)
				right--;
			if(arr[left]%2!=0 && arr[right]%2 ==0)
			{
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
