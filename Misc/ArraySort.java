
public class ArraySort {
	private int[] arr={3,4,4,5,2,3};
	public ArraySort(int length)
	{
	}
	public int sort()
	{
		int i=0;
		int j=1;
		for (j=1;j<arr.length;j++)
		{
			if(arr[i]!=arr[j])
			{
				i++;
				arr[i]=arr[j];
			}
		}
		display(i);
		return i;
	}
	public void display(int len)
	{
		for(int i=0;i<len;i++)
			System.out.print(arr[i]);
	}
	public static void main(String args[])
	{
		int length=6;
		ArraySort as = new ArraySort(length);
		as.sort();
	}
	
}
