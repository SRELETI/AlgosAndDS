
public class Balancepar {
	private char[] arr;
	private int capacity;
	private int elements;
	public Balancepar(int length)
	{
		arr = new char[length];
		capacity=length;
		elements=0;
	}
	public void push(char value)
	{
		arr[elements++]=value;
	}
	public char pop()
	{
		char result=arr[elements-1];
		elements--;
		return result;
	}
	public boolean isFull()
	{
		return elements==capacity;
	}
	public boolean isEmpty()
	{
		return elements==0;
	}
}
