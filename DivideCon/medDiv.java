import java.util.Arrays;


public class medDiv {

	public void median_merge(int[] arr1, int[] arr2)
	{
		int m1=0;
		int m2=0;
		int n=arr1.length;
		int j=0,k=0;
		for(int i=0;i<=n;i++)
		{
			if(k==n)
			{
				m1=m2;
				m2=arr2[0];
				break;
			}
			if(j==n)
			{
				m1=m2;
				m2=arr1[0];
				break;
			}
			
			if(arr1[k]<arr2[j])
			{
				m1=m2;
				m2=arr1[k];
				k++;
			}
			else
			{
				m1=m2;
				m2=arr2[j];
				j++;
			}
		}
		System.out.println((m1+m2)/2);
	}
	
	public static void main(String args[])
	{
		medDiv m = new medDiv();
		int[] arr1 ={1, 12, 15, 26, 38};
		int[] arr2 ={2, 13, 17, 30, 45};
	//	m.median_merge(arr1, arr2);
	//	System.out.println(m.median_logn(arr1, arr2, 0, arr1.length-1, 0, arr1.length-1, arr1.length));
		m.check("sudeep work hard ra");
	}
	
	
	public int median_logn(int[] arr1, int[] arr2,int start, int end, int start2, int end2, int length)
	{
		if(length<=0)
			return -1;
		if(length==1)
		{
			return (arr1[start]+arr2[start2])/2;
		}
		if(length==2)
		{
			int max = Math.max(arr1[start], arr2[start2]);
			int min = Math.min(arr1[end], arr2[end2]);
		//	System.out.println(arr1[start]+" "+arr2[start2]+" "+arr1[end]+" "+arr2[end2]);
			return (max+min)/2;
		}
		int m1 = get_median(arr1,start,end,length);
		int m2 = get_median(arr2,start2,end2,length);
		System.out.println(m1+" "+m2);
		if(m1==m2)
			return m1;
		if(m1<m2)
		{
			if(length%2==1)
				return median_logn(arr1,arr2,start+length/2,end,start2,start2+length/2,length-length/2);
			else
				return median_logn(arr1,arr2,start+length/2-1,end,start2, start2+length/2,length-length/2+1);
		}
		else
		{
			if(length%2==0)
				return median_logn(arr1,arr2,start,start+length/2-1,start2+length/2,end2,length/2);
			else
				return median_logn(arr1,arr2,start,start+length/2,start2+length/2,end2,length-length/2+1);
		}
	}
	
	private void check(String s)
	{
		String[] ss = s.trim().split("\\s");
		System.out.println(Arrays.toString(ss));
	}
	private int get_median(int[] arr,int start, int end, int length)
	{
		if(length%2==0)
		{
			int middle = (start+end)/2;
			return (arr[middle]+arr[middle-1])/2;
		}
		else
		{
			int middle = (start+end)/2;
			return arr[middle];
		}
	}
}
