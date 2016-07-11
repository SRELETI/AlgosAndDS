import java.util.Arrays;


public class LargestCont {

	public void largest(int[] num)
	{
		int cur_sum = num[0];
		int max_sum = num[0];
		for(int i=1;i<num.length;i++)
		{
			cur_sum = Math.max(num[i],cur_sum+num[i]);
			max_sum = Math.max(max_sum,cur_sum);
		}
		
		System.out.println(max_sum);
	}
	
	public static void main(String args[])
	{
		int[] ar = {-2, -3, 4, -1, -2, 1, 5, -3};
		LargestCont l = new LargestCont();
	//	l.largest(ar);
		int[] arr1 = {2,0,7,0,0,10,0};
		int[] arr2 = {5,8,12,14};
	//	l.merge(arr1, arr2);
		StringBuilder sb = new StringBuilder();
		int[] arr = {1,2,3,4};
		l.printTriplets(arr, 0, "");
		
	}
	
	
	public void median(int[] arr1, int[] arr2)
	{
		int n=arr1.length-1;
		int m1=arr1[0];
		int m2=arr2[0];
		for(int i=1;i<n;i++)
		{
			
		}
		
	}
	
	public void printTriplets(int[] arr,int start,String result)
	{
		if(result.length()==3)
		{
			System.out.println(result.toString());
			return;
		}
		for(int i=start;i<arr.length;i++)
		{
			printTriplets(arr,i+1,result+arr[i]);
		}
	}
	
	public void merge(int[] arr1, int[] arr2)
	{
		int j=arr1.length-1;
		for(int i=arr1.length-1;i>=0;i--)
		{
			if(arr1[i]!=0)
			{
				arr1[j]=arr1[i];
				j--;
			}
		}
		int i=arr2.length;
		int k=0;
		j=0;
		while(j<arr2.length && i<arr1.length)
		{
			if(arr2[j]<arr1[i])
			{
				arr1[k]=arr2[j];
				j++;
			}
			else if(arr1[i]<arr2[j])
			{
				arr1[k]=arr1[i];
				i++;
			}
			else
			{
				arr1[k]=arr1[i];
				i++;
				j++;
			}
			k++;
		}
		while(i<arr1.length)
		{
			arr1[k++]=arr1[i++];
		}
		while(j<arr2.length)
		{
			arr1[k++]=arr2[j++];
		}
		System.out.println(Arrays.toString(arr1));
	}
}























