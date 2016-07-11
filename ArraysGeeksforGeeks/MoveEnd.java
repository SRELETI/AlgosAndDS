import java.util.Arrays;


public class MoveEnd {

	public void merge(int[] arr, int[] small)
	{
		moveEnd(arr);
		int mn = arr.length;
		int n = small.length;
		int i=0;
		int j=n;
		int k=0;
		while(i<n && j<mn)
		{
			if(small[i]<=arr[j])
			{
				arr[k]=small[i];
				i++;
			}
			else 
			{
				arr[k]=arr[j];
				j++;
			}
			k++;
		}
		while(i<n)
		{
			arr[k]=small[i];
			i++;
			k++;
		}
		while(j<mn)
		{
			arr[k++]=arr[j++];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void moveEnd(int[] arr)
	{
		int i,j=arr.length-1;
		for(i=arr.length-1;i>=0;i--)
		{
			if(arr[i]!=-1)
			{
				arr[j]=arr[i];
				j--;
			}
		}
		
	}
	
	public static void main(String args[])
	{
		MoveEnd m = new MoveEnd();
		int[] arr = {2,-1,7,-1,-1,10,-1};
		int[] small = {5,8,12,14};
		
	//	m.merge(arr, small);
		
		int[] arr1 = {1,12,15,26,38};
		int[] arr2 = {2,13,17,30,45};
		
	//	m.median_opt(arr1, arr2);
		int[] rev = {1,2,3,4,5,6};
		m.reverse(rev);
	}
	
	
	public int median(int[] arr1, int[] arr2)
	{
		int n = arr1.length;
		
		int m1=-1;
		int m2=-1;
		int i=0;
		int j=0;
		int count;
		for(count=0;count<=n;count++)
		{
			if(i==n)
			{
				m1=m2;
				m2=arr2[0];
				break;
			}
			else if(j==n)
			{
				m1=m2;
				m2=arr1[0];
				break;
			}
			if(arr1[i]<arr2[j])
			{
				m1=m2;
				m2=arr1[i];
				i++;
			}
			else 
			{
				m1=m2;
				m2=arr2[j];
				j++;
			}
		}
		return (m1+m2)/2;
		
	}
	
	
	public void median_opt(int[] arr1, int[] arr2)
	{
		int start = 0;
		int end = arr1.length-1;
		int result = median_cal(arr1,start,end, arr2,start, end);
		System.out.println(result);
	}
	
	private int median_cal(int[] arr1,int start, int end, int[] arr2, int start2, int end2)
	{
		if(end-start+1 == 2)
		{
			return (Math.max(arr1[start], arr2[start2])+ Math.min(arr1[end], arr2[end2]))/2;
		}
		int n = end-start+1;
		int m1,m2;
		if(n%2==1)
		{
			m1=(start+end)/2;
			m2=(start2+end2)/2;
		}
		else
		{
			m1=(start+end)/2 + (start+end-1)/2;
			m2=(start2+end2)/2+(start2+end2-1)/2;
		}

		if(arr1[m1]==arr2[m2])
			return m1;
		else if(arr1[m1]<arr2[m2])
			return median_cal(arr1,m1,end,arr2,start2,m2);
		else
			return median_cal(arr1,start,m1,arr2,m2,end2);
		
	}
	
	private void reverse(int[] arr)
	{
		int start =0;
		int end = arr.length-1;
		while(start<end)
		{
			swap(arr,start,end);
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int[] arr, int start, int end)
	{
		int temp = arr[start];
		arr[start]= arr[end];
		arr[end] = temp;
	}
			
}
