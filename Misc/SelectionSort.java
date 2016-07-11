import java.util.Arrays;


public class SelectionSort {
	public int[] select(int arr[])
	{
		int min;
		for(int i=0;i<arr.length-1;i++)
		{
			min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
					min=j;
			}
			int small=arr[min];
			arr[min]=arr[i];
			arr[i]=small;
		}
		return arr;
	}
	public static void main(String args[])
	{
		int arr[]={5,3,6,2,4};
		SelectionSort ss=new SelectionSort();
		System.out.print(Arrays.toString(ss.select(arr)));
	}
}
