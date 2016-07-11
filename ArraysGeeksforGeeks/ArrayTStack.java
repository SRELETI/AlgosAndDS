
public class ArrayTStack {
	private int[] arr;
	private int elements1;
	private int elements2;
	public ArrayTStack(int length1,int length2)
	{
		arr = new int[length1+length2];
		elements1=0;
		elements2=(arr.length/2);
	}
	public void push1(int value)
	{
		if(isFull1())
		{
			System.out.println("The stack 1 is full ");
			return;
		}
		arr[elements1++]=value;
	}
	public int pop()
	{
		if(isEmpty1())
		{
			System.out.println("stack 1 is empty, no elements to delete ");
			return -1;
		}
		int del=arr[elements1-1];
		elements1--;
		return del;
	}
	public boolean isEmpty1()
	{
		return elements1==0;
	}
	public boolean isFull1()
	{
		return elements1==arr.length/2;
	}
	public void display()
	{
		for(int i=0;i<elements1;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void push2(int value)
	{
		if(isFull2())
		{
			System.out.println("The stack 2 is full ");
			return;
		}
		arr[elements2++]=value;
	}
	public int pop2()
	{
		if(isEmpty2())
		{
			System.out.println("The stack 2 is empty, no element to delete ");
			return -1;
		}
		int del=arr[elements2-1];
		elements2--;
		return del;
	}
	public boolean isEmpty2()
	{
		return elements2==(arr.length/2);
	}
	public boolean isFull2()
	{
		return elements2==arr.length;
	}
	public void display2()
	{
		for(int i=arr.length/2;i<elements2;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
