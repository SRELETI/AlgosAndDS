import java.util.Arrays;


public class PanCake {

	public void sort(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
		int cur_size = arr.length;
		for(int i=cur_size;i>=1;i--)
		{
			int m = findMax(arr,i);
			flip(arr,m);
			flip(arr,i-1);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private int findMax(int[] arr, int n)
	{
		int max = 0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]>arr[max])
				max = i;
		}
		return max;
	}
	
	private void flip(int[] arr, int n)
	{
		int temp;
		int start =0;
		while(start<n)
		{
			temp =arr[start];
			arr[start]= arr[n];
			arr[n]=temp;
			start++;
			n--;
		}
	}
	
	public static void main(String args[])
	{
		PanCake p = new PanCake();
		int[] arr = {23,10,20,11,12,6,7};
		p.sort(arr);
	}
}
