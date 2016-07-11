import java.util.Arrays;
import java.util.Stack;


public class IterativeQuickSortExample {

	private int partition(int[] arr, int l,int r)
	{
		int pivot = r;
		int start = l;
		int temp = l;
		for(start=l;start<r;start++)
		{
			if(arr[start]<arr[pivot])
			{
				swap(arr,start,temp);
				temp++;
			}
		}
		swap(arr,temp,pivot);
		return temp;
	}
	
	private void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public void quickSort(int[] arr, int l, int r)
	{
		if(l<r)
		{
			Stack<Integer> s = new Stack<Integer>();
			s.push(l);
			s.push(r);
			while(!s.isEmpty())
			{
				r = s.pop();
				l=s.pop();
				int p = partition(arr,l,r);
				if(r>p+1)
				{
					s.push(p+1);
					s.push(r);
				}
				if(l<p-1)
				{
					s.push(l);
					s.push(p-1);
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {4, 3, 5, 2, 1, 3, 2, 3};
		IterativeQuickSortExample i = new IterativeQuickSortExample();
		i.quickSort(arr, 0, 7);
	}
}
