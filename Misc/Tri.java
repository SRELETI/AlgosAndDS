import java.util.Arrays;


public class Tri {

	public void triplet(int[] arr, int result_sum)
	{
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			int l = i+1;
			int h = arr.length-1;
			int sum;
			while(l<h)
			{
				sum= arr[i]+arr[l]+arr[h];
				if(sum == result_sum)
				{
					System.out.println("Sum found at index "+arr[i]+" "+arr[l]+" "+arr[h]);
					return;
				}
				else if(sum<result_sum)
					l++;
				else
					h--;
			}
		}
		
		System.out.println("Sum not found ");
	}
	
	public static void main(String args[])
	{
		int[] arr = {12,3,4,1,6,9};
		Tri r = new Tri();
		r.triplet(arr, 26);
	}
}
