
public class TwoStackArray {
	private int[] arr;
	private int capacity;
	private int elements1;
	private int elements2;
	public TwoStackArray(int length1, int length2)
	{
		capacity=length1+length2;
		arr = new int[capacity];
		elements1=0;
		elements2=0;
	}
	public void push1(int value)
	{
		if(isFull())
		{
			System.out.println("Full");
			return;
		}
		arr[elements1++]=value;
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return 0;
		}
		int result=arr[elements1-1];
		elements1--;
		System.out.println("The element popped "+result);
		return result;
	}
	public boolean isEmpty()
	{
		return elements1==0;
	}
	public boolean isFull()
	{
		return elements1==arr.length/2;
	}
	public void push2(int value)
	{
		if(isFull2())
		{
			System.out.println("The stack2 is full ");
			return;
		}
		arr[(arr.length/2)+elements2]=value;
		elements2++;
	}
	public int pop2()
	{
		if(isEmpty2())
		{
			System.out.println("The stack is empty ");
			return 0;
		}
		int result=arr[(arr.length/2)+elements2-1];
		elements2--;
		System.out.println("The element popped is "+result);
		return result;
	}
	public boolean isEmpty2()
	{
		return elements2==0;
	}
	public boolean isFull2()
	{
		return elements2==arr.length-(arr.length/2);
	}
	public void display1()
	{
		for(int i=0;i<elements1;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void display2()
	{
		for(int i=0;i<elements2;i++)
		{
			System.out.print(arr[(arr.length/2)+i]+" ");
		}
		System.out.println();
	}
}
