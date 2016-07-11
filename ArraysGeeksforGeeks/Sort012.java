import java.util.Arrays;


public class Sort012 {
	private int[] arr;
	private int elements;
	public static void main(String[] args)
	{
		Sort012 s = new Sort012(12);
		s.insert(0);
		s.insert(1);
		s.insert(1);
		s.insert(0);
		s.insert(1);
		s.insert(2);
		s.insert(1);
		s.insert(2);
		s.insert(0);
		s.insert(0);
		s.insert(0);
		s.insert(1);
		s.sorting();
	}
	public Sort012(int length)
	{
		arr= new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void sorting()
	{
		int low=0;
		int mid=0;
		int high=arr.length-1;
		while(mid<=high)
		{
			switch(arr[mid])
			{
			case 0:
				swap(low,mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(mid,high);
				high--;
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public void swap(int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
