import java.util.Arrays;


public class StockSpan2 {
	private int[] arr;
	private int elements;
	private int capacity;
	private int[] input;
	private int elements1;
	public StockSpan2(int length)
	{
		arr = new int[length];
		elements=0;
		elements1=0;
		capacity=length;
		input = new int[length];
	}
	
	public void add(int value)
	{
		input[elements1++]=value;
	}
	
	public void display()
	{
		for(int i=0;i<input.length;i++)
		{
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}
	public void push(int value)
	{
		if(isFull())
		{
			System.out.println("Not allowed ");
			return;
		}
		else
		{
			arr[elements++]=value;
		}
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Empty, Not allowed");
			return -1;
		}
		int result=arr[elements-1];
		elements--;
		return result;
	}
	
	public boolean isEmpty()
	{
		return elements==0;
	}
	
	public boolean isFull()
	{
		return elements==capacity;
	}
	
	public int peek()
	{
		return arr[elements-1];
	}
	public void stock()
	{
		int[] result = new int[capacity];
		result[0]=1;
		push(0);
		for(int i=1;i<input.length;i++)
		{
			while(!isEmpty() && input[peek()]<=input[i])
				pop();
			result[i]=isEmpty()?i+1:i-peek();
			push(i);
		}
		System.out.println(Arrays.toString(result));
	}
}
