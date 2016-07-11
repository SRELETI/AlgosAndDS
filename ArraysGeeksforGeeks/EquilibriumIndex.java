
public class EquilibriumIndex {
	public static void main(String args[])
	{
		int[] arr= {-7,1,5,2,-4,3,0};
		index(arr);
		index_mod(arr);
	}
	public static void index(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			int leftsum=0;
			int rightsum=0;
			for(int j=0;j<i;j++)
				leftsum=leftsum+arr[j];
			for(int j=i+1;j<arr.length;j++)
				rightsum=rightsum+arr[j];
			if(leftsum==rightsum)
				System.out.println(i);
		}
	}
	public static void index_mod(int[] arr)
	{
		int leftsum=0;
		int sum=arr[0];
		for(int i=1;i<arr.length;i++)
			sum=sum+arr[i];
		for(int i=0;i<arr.length;i++)
		{
			sum=sum-arr[i];
			if(leftsum==sum)
				System.out.println(i);
			leftsum=leftsum+arr[i];
		}
	}
}
