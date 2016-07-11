import java.util.Arrays;


public class RandomArray {

	public void randomArr(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
		for(int i=arr.length-1;i>=0;i--)
		{
			int j = (int) (Math.random()*arr.length+1)%(i+1);
		//	System.out.println(j);
			swap(arr,i,j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void swap(int[] arr,int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void main(String args[])
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		RandomArray r = new RandomArray();
		r.randomArr(arr);
	}
}
