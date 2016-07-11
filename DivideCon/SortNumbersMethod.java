import java.util.Arrays;
import java.util.Stack;


public class SortNumbersMethod {

	public void main_method(int[] arr, int low, int high)
	{
		if(low>high)
			return;
		Stack<Integer> s = new Stack<Integer>();
		s.push(low);
		s.push(high);
		int l,h;
		while(!s.isEmpty())
		{
			h = s.pop();
			l=s.pop();
			int par = partition(arr,l,h);
			if(l<par-1)
			{
				s.push(l);
				s.push(par-1);
			}
			if(h>par+1)
			{
				s.push(par+1);
				s.push(h);
			}
		}
	}
	
	private int partition(int[] arr, int low, int high)
	{
		int par = arr[high];
		int i=low,j;
		for(j=low;j<high;j++)
		{
			if(isCompare(arr,j,high)==true)
			{
				swap(arr,i,j);
				i++;
			}
		}
		swap(arr,i,high);
		return i;
	}
	
	private boolean isCompare(int[] arr, int j, int high)
	{
		String s1 = new String(arr[j]+""+arr[high]);
		String s2 = new String(arr[high]+""+arr[j]);
	//	System.out.println(s1 +" "+s2);
		if(s1.compareTo(s2)>0)
			return true;
		else
			return false;
	}
	private void swap(int[] arr, int l, int h)
	{
		int temp = arr[l];
		arr[l]=arr[h];
		arr[h] = temp;
	}
	
	public static void main(String args[])
	{
		int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
		SortNumbersMethod s = new SortNumbersMethod();
		s.main_method(arr, 0, 7);
	//	System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
	}
}
