import java.util.Arrays;


public class BubbleSort {
	public int[] sorting(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=1;j<arr.length-i;j++){
				if(arr[j-1]>arr[j])
				{
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public static void main(String args[])
	{
		int arr[]={5,3,7,4,1,2};
		BubbleSort bs=new BubbleSort();
		int result[]=bs.sorting(arr);
		System.out.print(Arrays.toString(result));
	}
}
