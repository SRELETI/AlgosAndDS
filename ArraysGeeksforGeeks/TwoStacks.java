
public class TwoStacks {

	private int data1;
	private int data2;
	private int[] arr;
	private int length;
	
	private int data3;
	private int data4;
	private int[] arr2;
	public TwoStacks(int size)
	{
		length = size;
		arr = new int[length];
		data1 = -1;
		data2 = arr.length;
		arr2 = new int[length];
		data3 = -1;
		data4 = arr2.length/2;
	}
	
	public void push1(int val)
	{
		if(isFull())
		{
			System.out.println("The stack is full ");
			return;
		}
		arr[++data1]= val;
	}
	
	public void push2(int val)
	{
		if(isFull())
		{
			System.out.println("The stack is empty ");
			return;
		}
		arr[--data2]=val;
	}
	
	public int pop1()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return -1;
		}
		int temp = arr[data1];
		data1--;
		return temp;
	}
	
	public int pop2()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty ");
			return -1;
		}
		int temp = arr[data2];
		data2--;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return data1+data2==arr.length-1;
	}
	
	public boolean isFull()
	{
		return data2 == data1+1;
	}
	
	
	public void push3(int val)
	{
		if(isFull2())
		{
			System.out.println("The stack is full ");
			return;
		}
		arr2[++data3] = val;
	
	}
	
	public void push4(int val)
	{
		if(isFull3())
		{
			System.out.println("The stack is full ");
		}
		arr2[data4++] =val;
		
	}
	
	public int pop3()
	{
		if(isEmpty2())
		{
			System.out.println("The stack is empty ");
			return -1;
		}
		int temp = arr2[data3];
		data3--;
		return temp;
		
	}
	
	public int pop4()
	{
		if(isEmpty3())
		{
			System.out.println("The stack is empty ");
			return -1;
		}
		int temp = arr2[data4-1];
		data4--;
		return temp;
	}
	
	public boolean isFull2()
	{
		return data3==(arr2.length/2)-1;
	}
	
	public boolean isEmpty2()
	{
		return data3 ==-1;
	}
	
	public boolean isFull3()
	{
		return data4==arr2.length;
	}
	
	public boolean isEmpty3()
	{
		return data4 == arr2.length/2;
	}
	
}
