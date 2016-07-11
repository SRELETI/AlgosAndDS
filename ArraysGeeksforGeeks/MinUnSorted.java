
public class MinUnSorted {
	public static void main(String args[])
	{
		int arr[]={10,12,20,30,25,40,32,31,35,50,60};
		find(arr);
	}
	public static void find(int[] arr)
	{
		int s=0;int e=arr.length-1;
		for(s=0;s<arr.length-1;s++)
		{
			if(arr[s]>arr[s+1])
				break;
		}
		if(s==arr.length-1)
			return;
		for(e=arr.length-1;e>0;e--)
		{
			if(arr[e]<arr[e-1])
				break;
		}
		int max=arr[s];int min=arr[s];
		for(int i=s+1;i<=e;i++)
		{
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		for(int i=0;i<=s-1;i++)
		{
			if(arr[i]>min)
				s=i;
		}
		for(int i=arr.length-1;i>e;i--)
		{
			if(arr[i]<max)
				e=i;
		}
		System.out.println("The unsorted array is between "+s+" and "+e);
	}
}
