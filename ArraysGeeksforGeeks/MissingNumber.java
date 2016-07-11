
public class MissingNumber {
	private int[] arr;
	private int elements;
	public MissingNumber(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public int check()
	{
		int total=(elements+1)*(elements+2)/2;
		for(int i=0;i<elements;i++)
			total=total-arr[i];
		return total;
	}
	public int xORcheck()
	{
		int x1=arr[0];
		int x2=1;
		for(int i=1;i<arr.length;i++)
			x1=x1^arr[i];
		for(int i=2;i<=arr.length+1;i++)
			x2=x2^i;
		return x1^x2;
	}
	public static void main(String args[])
	{
		int length=5;
		MissingNumber mn= new MissingNumber(length);
		mn.insert(5);
		mn.insert(3);
		mn.insert(4);
		mn.insert(2);
		mn.insert(1);
		System.out.println(mn.check());
		System.out.println(mn.xORcheck());
	}
}
