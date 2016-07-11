
public class Max_subarray_kadane {
	public int kadane(int arr[])
	{
		int max_so_far=0;
		int max_ending_here=0;
		for(int i=0;i<arr.length;i++)
		{
			max_ending_here=max_ending_here+arr[i];
			if(max_ending_here<0)
			{
				max_ending_here=0;
			}
			if(max_so_far<max_ending_here)
				max_so_far=max_ending_here;
		}
		return max_so_far;
	}
	public static void main(String args[])
	{
		int arr[]={12,5,-8,3,1,16};
		Max_subarray_kadane msk=new Max_subarray_kadane();
		System.out.print(msk.kadane(arr));
	}
}
