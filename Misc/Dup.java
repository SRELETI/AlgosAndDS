
public class Dup {
	private int length;
	private int[] arr;
	private int elements;
	public Dup(int len)
	{
		length=len;
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements]=value;
		elements++;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void removeDup()
	{
		int i=0;
		int j=1;
		for(j=1;j<elements;j++)
		{
			if(arr[i]!=arr[j])
			{
				i++;
				arr[i]=arr[j];
			}
		}
		for(int k=0;k<i+1;k++)
		{
			System.out.print(arr[k]+" ");
		}
		System.out.println();
	}
	public void OddEvenSort()
	{
		for(int i=0;i<elements/2;i++)
		{
			for(int j=0;j+1<elements;j=j+2)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			for(int j=1;j+1<elements;j=j+2)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
}
