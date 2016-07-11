import java.util.Arrays;


public class Sort0N2 {

	public void sort(int[] arr, int n)
	{
		sortNow(arr,n,1);
		sortNow(arr,n,n);
		sortNow(arr,n,n*n);
	}
	
	public void sortNow(int[] arr,int n, int d)
	{
		int[] count = new int[n];
		int[] result = new int[n];
		for(int i=0;i<arr.length;i++)
		{
			count[(arr[i]/d)%n]++;
		}
		for(int i=1;i<count.length;i++)
			count[i] = count[i]+count[i-1];
		for(int i=arr.length-1;i>=0;i--)
		{
			count[(arr[i]/d)%n]--;
			result[count[(arr[i]/d)%n]] =arr[i];
		}
		for(int i=0;i<result.length;i++)
			arr[i] = result[i];
	}
	
	public static void main(String args[])
	{
		int[] arr = {0,23,95,120,9};
		Sort0N2 s = new Sort0N2();
		s.sort(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
}
