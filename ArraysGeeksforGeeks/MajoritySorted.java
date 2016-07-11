
public class MajoritySorted {
	public static boolean isMajority(int arr[], int element)
	{
		int middle=arr.length/2;
		for(int i=0;i<middle;i++)
		{
			if(arr[i]==element && arr[i+middle]==element)
				return true;
		}
		return false;
	}
	public static int isrecursive(int arr[], int start,int end, int element)
	{
		if(end<start)
			return -1;
		int middle=start+((end-start)/2);
		if((middle==0 || element>arr[middle-1]) && arr[middle]==element)
		{
			return middle;
		}
		if(arr[middle]<element)
			return isrecursive(arr,middle+1,end,element);
		else
			return isrecursive(arr,start,middle-1,element);
	}
	public static void main(String args[])
	{
		int arr[]={0,1,1,1,2};
		//System.out.println(isMajority(arr,1));
		System.out.println(isrecursive(arr,0,arr.length-1,1));
	}
}
