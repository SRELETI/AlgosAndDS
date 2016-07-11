
public class Bits_Test {
	private int num;
	private int count;
	public Bits_Test(int digit, int noOfDigits)
	{
		num=digit;
		count=noOfDigits;
	}
	public void right()
	{
		int result=num>>count;
		System.out.println(result);
	}
	public void left()
	{
		int result=num<<count;
		System.out.println(result);
	}
	public void unsignedright()
	{
		int result=num>>>count;
		System.out.println(result);
	}
}
