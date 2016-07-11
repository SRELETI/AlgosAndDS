
public class OddElementInEven {
	private int[] arr;
	private int elements;
	public OddElementInEven(int length)
	{
		elements=0;
		arr=new int[length];
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public int isOdd()
	{
		int result=0;
		for(int i=0;i<arr.length;i++)
		{
			result=result ^ arr[i];
		}
		return result;
	}
	public static void main(String args[])
	{
		int length=5;
		OddElementInEven oe =  new OddElementInEven(length);
		oe.insert(5);
		oe.insert(4);
		oe.insert(3);
		oe.insert(4);
		oe.insert(3);
		System.out.println(oe.isOdd());
	}
	
}
