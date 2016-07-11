
public class ShellSort2 {
	private int outer;
	private int inner;
	private int h;
	private int temp;
	private int[] arr;
	private int elements;
	public ShellSort2(int length)
	{
		arr = new int[length];
		h=1;
		elements=0;
	}
	public void add(int value)
	{
		arr[elements++]=value;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void shellSort()
	{
		while(h<=elements/3)
		{
			h=3*h+1;
		}
		while(h>0)
		{
			for(outer=h;outer<elements;outer++)
			{
				temp=arr[outer];
				inner=outer;
				while(inner>h-1 && arr[inner-h]>=temp)
				{
					arr[inner]=arr[inner-h];
					inner=inner-h;
				}
				arr[inner]=temp;
			}
			h=(h-1)/3;
		}
	}
}
