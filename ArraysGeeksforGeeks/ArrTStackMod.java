
public class ArrTStackMod {
	private int[] arr;
	private int elements1;
	private int elements2;
	public ArrTStackMod(int length)
	{
		arr = new int[length];
		elements1=0;
		elements2=0;
	}
	public void push(int value)
	{
		if(isFull())
		{
			System.out.println("The stack 1 is full ");
			return;
		}
		arr[elements1++]=value;
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack 2 is empty ");
			return -1;
		}
		int del=arr[elements1-1];
		elements1--;
		return del;
	}
	public boolean isFull()
	{
		return (elements1+elements2)==arr.length;
	}
	public boolean isEmpty()
	{
		return elements1==0;
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
			System.out.println("The stack2 is full ");
			return;
		}
		arr[arr.length-1-elements2]=value;
		elements2++;
	}
	public int pop2()
	{
		if(isEmpty2())
		{
			System.out.println("The stack 2 is empty");
			return -1;
		}
		int del = arr[arr.length-1-elements2];
		elements2--;
		return del;
	}
	public boolean isFull2()
	{
		return (elements1+elements2)==arr.length;
	}
	public boolean isEmpty2()
	{
		return elements2==0;
	}
	public void display2()
	{
		for(int i=arr.length-1;i>(arr.length-1-elements2);i--)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
