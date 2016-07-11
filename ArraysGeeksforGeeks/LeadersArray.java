
public class LeadersArray {
	private int[] arr;
	private int elements;
	public LeadersArray(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void leaders()
	{
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[i]<=arr[j])
					break;
			}
			if(j==arr.length)
				System.out.println(arr[i]);
		}
	}
	public void leaders2()
	{
		int max=arr[arr.length-1];
		System.out.println(max);
		for(int i=arr.length-2;i>=0;i--)
		{
			if(max<arr[i])
			{
				System.out.println(arr[i]);
				max=arr[i];
			}
		}
	}
	public static void main(String args[])
	{
		int length=5;
		LeadersArray la = new LeadersArray(length);
		la.insert(5);
		la.insert(4);
		la.insert(3);
		la.insert(2);
		la.insert(1);
		//la.leaders();
		la.leaders2();
	}
}
