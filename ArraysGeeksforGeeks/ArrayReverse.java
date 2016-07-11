import java.util.Arrays;

public class ArrayReverse{
	private int[] arr;
	private int elements;
	public ArrayReverse(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void reverse()
	{
		int start=0;
		int end=arr.length-1;
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	public void reverseRec(int start,int end)
	{
		if(start>=end)
			return;
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		reverseRec(start+1,end-1);
	}
	public void display()
	{
		System.out.println(Arrays.toString(arr));
	}
}