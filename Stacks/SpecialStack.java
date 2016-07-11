
public class SpecialStack {
	private int[] original;
	private int[] aux;
	private int capacity;
	private int elements;
	public SpecialStack(int length)
	{
		capacity=length;
		original=new int[capacity];
		aux= new int[capacity];
		elements=0;
	}
	public void push(int value)
	{
		if(elements==0)
		{
			original[elements]=value;
			aux[elements]=value;
			elements++;
		}
		else
		{
			if(original[elements-1]<=value)
			{
				original[elements]=value;
				aux[elements]=aux[elements-1];
				elements++;
			}
			else
			{
				original[elements]=value;
				aux[elements]=value;
				elements++;
			}
		 }
	  }
	public int pop()
	{
		int result=original[elements-1];
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
	public int getMin()
	{
		return aux[elements-1];
	}
}
