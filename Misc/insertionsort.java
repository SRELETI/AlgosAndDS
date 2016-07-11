import java.util.*;
public class insertionsort {
	public int[] sorting(int arr[])
	{
		int key;
		int i;
		for(int j=1;j<arr.length;j++)
		{
			key=arr[j];
			i=j-1;
			while(i>=0 && arr[i]>key)
			{
				arr[i+1]=arr[i];
				i=i-1;
			}
			arr[i+1]=key;
		}
		return arr;
	}
	public static void main(String args[])
	{
		int arr[]={5,3,6,1,2};
		insertionsort is=new insertionsort();
		int result[]=is.sorting(arr);
		System.out.println(Arrays.toString(result));
	}
}
