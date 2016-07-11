
public class FixedElement {
	public static void main(String args[])
	{
		int[] arr={-10,-5,3,4,7,9};
		fixed(arr);
		System.out.println(fixed_rec(arr,0,arr.length-1));
	}
	public static void fixed(int[] arr)
	{
		int i;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]==i)
			{
				System.out.println("The element is "+arr[i]);
				break;
			}
		}
		if(i==arr.length)
			System.out.println("The element not found "+-1);
	}
	public static int fixed_rec(int[] arr,int start, int end)
	{
		if(start>end)
			return -1;
		int middle=start+end;
		if(arr[middle]==middle)
			return middle;
		else if(arr[middle]>middle)
			return fixed_rec(arr,start,middle-1);
		else
			return fixed_rec(arr,middle+1,end);
	}
}
