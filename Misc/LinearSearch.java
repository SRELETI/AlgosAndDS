
public class LinearSearch {
	public int search(int[] arr,int value)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==value)
			{
				return i;
			}
		}
		return -1;
	}
	public static void main(String args[])
	{
		int arr[]={4,5,6,7,8,9};
		int value=4;
		LinearSearch ls=new LinearSearch();
		System.out.print(ls.search(arr,value));
	}
}
