import java.util.Arrays;


public class SumEqualToX {
	private int[] arr;
	private int elements;
	public SumEqualToX(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public int isCheck(int x)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==x)
					count++;
			}
		}
		return count;
	}
	public void insert(int value)
	{
		if(elements==arr.length)
		{
			System.out.println("Not allowed");
			return;
		}
		arr[elements++]=value;
	}
	public int modifiedCheck(int x)
	{
		Arrays.sort(arr);
		int left=0;
		int right=arr.length-1;
		int count=0;
		while(left<right)
		{
			int result=arr[left]+arr[right];
			if(result==x)
			{
				left++;
				right--;
				count++;
			}
			else if(result<x)
				left++;
			else
				right--;
		}
		return count;
	}
	public static void main(String args[])
	{
		int length=6;
		SumEqualToX s = new SumEqualToX(length);
		s.insert(9);
		s.insert(6);
		s.insert(7);
		s.insert(8);
		s.insert(5);
		s.insert(4);
		s.insert(11);
		System.out.println(s.isCheck(13));
		System.out.println(s.modifiedCheck(13));
	}
}
