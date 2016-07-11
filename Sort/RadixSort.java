import java.util.ArrayList;


public class RadixSort {
	private int[] arr;
	private int elements;
	public RadixSort(int length)
	{
		arr = new int[length];
		elements=0;
	}
	
	public void add(int value)
	{
		arr[elements++]=value;
	}
	
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public void radixSort(int maxDigits)
	{
		int exp=1;
		for(int i=0;i<maxDigits;i++)
		{
			ArrayList<Integer> bucketList[] =  new ArrayList[10];
			for(int k=0;k<10;k++)
			{
				bucketList[k]= new ArrayList<Integer>();
			}
			for(int k=0;k<arr.length;k++)
			{
				int number= ((arr[k])/exp)%10;
				bucketList[number].add(arr[k]);
			}
			exp=exp*10;
			int index=0;
			for(int k=0;k<10;k++)
			{
				for(int num:bucketList[k])
				{
					arr[index]=num;
					index++;
				}
			}
		}
		display();
	}
	
}
