import java.util.Arrays;


public class PositiveUnsorted {
	public static void main(String args[])
	{
		int[] arr= { 2, 3, -7, 6, 8, -10, 15 };
	//	positive(arr);
	//	sort_positive(arr);
		int[] arr2=segregate(arr);
		missing(arr2);
	//	segregate2(arr);
	}
	public static void positive(int[] arr)
	{
		int n=Integer.MAX_VALUE;
		int j;
		for(int i=1;i<n;i++)
		{
			for(j=0;j<arr.length;j++)
			{
				if(i==arr[j])
					break;
			}
			if(j==arr.length)
			{
				System.out.println("The missing number is "+i);
				return;
			}
		}
	}
	public static void missing(int[] arr)
	{
		int index=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				index=i;
				break;
			}
		}
		int len = arr.length-index;
		for(int i=index;i<arr.length;i++)
		{
			if(Math.abs(arr[i])-1 < arr.length && arr[Math.abs(arr[i])-1]>0)
				arr[Math.abs(arr[i])-1]=-arr[Math.abs(arr[i])-1];
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void sort_positive(int[] arr)
	{
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>1 && arr[i-1]>=0 && arr[i]-arr[i-1]!=1)
			{
				System.out.println(arr[i-1]+1);
				return;
			}
			else if(arr[i]>1 && arr[i-1]<0 && arr[i]-arr[i-1]!=1)
			{
				System.out.println(1);
				return;
			}
		}
		System.out.println(arr[arr.length-1]+1);
	}
	
	public static int[] segregate(int[] arr)
	{
		int start=0;
		int end=arr.length-1;
		while(start<end)
		{
			if(arr[start]<=0)
				start++;
			if(arr[end]>0)
				end--;
			if(start<arr.length && end>=0 && arr[start]>0 && arr[end]<=0)
			{
				int temp=arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
		return arr;
	}
	
	
	
	
	
	public static void segregate2(int[] arr)
	{
		int i=0;
		int j=0;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j]<=0)
			{
				arr[i]=arr[j];
				i++;
			}
		}
		for(int k=i;k<arr.length;k++)
			System.out.print(arr[k]+" ");
	}
}
