
public class Med {

	public void median(int[] arr1, int[] arr2)
	{
		int median1 = arr1[0];
		int median2 = arr2[0];
		int n = arr2.length;
		int count = 0;
		int i=0;
		int j=0;
		for(count=0;count<=n;count++)
		{
			if(i==n)
			{
				median1 = median2;
				median2 = arr2[0];
				break;
			}
			if(j==n)
			{
				median1 = median2;
				median2 = arr1[0];
				break;
			}
			
			if(arr1[i]<=arr2[j])
			{
				median1 = median2;
				median2 = arr1[i];
				i++;
			}
			else
			{
				median1 = median2;
				median2 = arr2[j];
				j++;
			}
		}
		System.out.println((median1+median2)/2);
	}
	
	public void median2(int[] arr1, int[] arr2)
	{
		int result = cal(arr1,arr2,0,arr1.length-1,0,arr2.length-1,arr1.length);
		System.out.println(result);
	}
	
	private int cal(int[] arr1, int[] arr2, int start, int end, int start2, int end2, int length)
	{
		if(start>end)
			return -1;
		if(start+end+1==1 && start2+end2+1==1)
			return (arr1[0]+arr2[0])/2;
		if(start+end+1==2 && start2+end2+1==2)
		{
			int max = Math.max(arr1[0], arr2[0]);
			int min = Math.min(arr1[1], arr1[1]);
			return (max+min)/2;
		}
		int m1 = getMedian(arr1,start,end);
		int m2 = getMedian(arr2,start2,end2);
		System.out.println(m1+" "+m2);
		if(m1==m2)
			return m1;
		
		else if (m2>m1)
		{
			return cal(arr1,arr2,(length/2),end,start2,(arr2.length-1/2),length/2);
		}
		else
			return cal(arr1,arr2,start,(length/2),(length/2),end2,length/2);
	}
	
	private int getMedian(int[] arr, int start, int end)
	{
		int med = (start+end)/2;
		if((start+end)%2==0)
		{
			return arr[med];
		}
		else
		{
			return (arr[med]+arr[med+1])/2;
		}
	}
	
	public void median3(int[] arr1,int[] arr2, int length)
	{
		int result = cal2(arr1,arr2,0,arr1.length-1,length);
		System.out.println(result);
	}
	
	private int cal2(int[] arr1, int[] arr2, int start, int end, int length)
	{
		if(start>end)
			return cal2(arr2,arr1,0,arr1.length-1,arr1.length);
		int i,j;
		
		i =(start+end)/2;
		j = length-i-1;
		
		if(arr1[i]>arr2[j] && j==length-1 || arr1[i]<=arr2[j+1])
		{
			if(i==0 || arr2[j]>arr1[i-1])
				return (arr2[j]+arr1[i])/2;
			else
				return (arr1[i-1]+arr1[i])/2;
		}
		else if(arr1[i]>arr2[j] && j!=length-1 && arr1[i]>arr2[j])
			return cal2(arr1,arr2,start,i-1,length);
		else
			return cal2(arr1,arr2,i+1,end,length);
	}
	
	public static void main(String args[])
	{
		Med m = new Med();
		int[] arr1 = {1,12,15,26,33};
		int[] arr2 = {2,13,17,30,45};
		m.median(arr1, arr2);
		m.median2(arr1, arr2);
		m.median3(arr1, arr2, arr1.length);
	}
}
