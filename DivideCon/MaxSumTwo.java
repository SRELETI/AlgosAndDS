
public class MaxSumTwo {

	public void cal(int[] arr, int[] arr2)
	{
		int sum1 = 0;
		int sum2 = 0;
		int total =0;
		int i=0,j=0;
		while(i<arr.length && j<arr2.length)
		{
			if(arr[i]<arr2[j])
				sum1=sum1+arr[i++];
			else if(arr2[j]<arr[i])
				sum2 = sum2+arr2[j++];
			else
			{
				total = total + Math.max(sum1, sum2);
				sum1= 0;
				sum2= 0;
				while(i<arr.length && j<arr2.length && arr[i]==arr2[j])
				{
					total = total + arr[i];
					i++;
					j++;
				}
			}
		}
		while(i<arr.length)
		{
			sum1 = sum1+arr[i++];
		}
		while(j<arr2.length)
		{
			sum2 = sum2+arr[j++];
		}
		total = total + Math.max(sum1, sum2);
		System.out.println(total);
	}
	public static void  main(String args[])
	{
		int[] arr = {2, 3, 7, 10, 12, 15, 30, 34};
		int[] arr2 = {1, 5, 7, 8, 10, 15, 16, 19};
		MaxSumTwo m = new MaxSumTwo();
		m.cal(arr, arr2);
	}
}
