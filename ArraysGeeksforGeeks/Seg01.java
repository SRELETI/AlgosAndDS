import java.util.Arrays;


public class Seg01 {
	public static void seg(int[] arr)
	{
		int i=0;
		int j;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j]!=1)
			{
				arr[i]=arr[j];
				i++;
			}
		}
		for(int k=i;k<arr.length;k++)
		{
			arr[k]=1;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String args[])
	{
		int arr[]={0,1,0,1,1,1,0,1,0};
		//seg(arr);
		modified(arr);
	}
	public static void modified(int[] arr)
	{
		int left=0;
		int right=arr.length-1;
		while(left<right)
		{
			if(arr[left]==0 && left< right)
				left++;
			if(arr[right]==1 && left < right)
				right--;
			if(arr[left]>arr[right])
			{
				arr[left]=0;
				arr[right]=1;
				left++;
				right--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
