import java.util.Arrays;


public class TwoSumZero {
	private int[] arr;
	private int elements;
	public TwoSumZero(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void compute()
	{
		int min_l=0;
		int min_r=1;
		int min_sum=arr[0]+arr[1];
		int sum;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				sum=arr[i]+arr[j];
				if(sum<min_sum)
				{
					min_l=i;
					min_r=j;
					min_sum=sum;
				}
			}
		}
		System.out.println("The min elements are "+min_l+" "+min_r);
	}
	public void opt_compute()
	{
		Arrays.sort(arr);
		int start=0;
		int end=arr.length-1;
		int min_sum=arr[0]+arr[1];
		int min_l=0;
		int min_r=1;
		while(start<end)
		{
			int sum=arr[start]+arr[end];
			if(sum<min_sum)
			{
				min_l=start;
				min_r=end;
				min_sum=sum;
			}
			if(sum<0)
				start++;
			if(sum>0)
				end--;
		}
		System.out.println(arr[min_l]+" "+ arr[min_r]);
	}
	public static void main(String args[])
	{
		int length=5;
		TwoSumZero tsz = new TwoSumZero(length);
		tsz.insert(5);
		tsz.insert(4);
		tsz.insert(3);
		tsz.insert(2);
		tsz.insert(1);
		tsz.compute();
		tsz.opt_compute();
	}
}
