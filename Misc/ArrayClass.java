
public class ArrayClass {
	
	private ObjectClass[] arr;
	private int elements;
	public ArrayClass(int length)
	{
		arr=new ObjectClass[length];
		elements=0;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			arr[i].display();
		}
		System.out.println();
	}
	public int find(String value)
	{
		for(int i=0;i<elements;i++)
		{
			if(arr[i].getLast().equals(value))
			{
				System.out.println("The element is found at index "+i);
				return i;
			}
		}
		System.out.println("Not Found");
		return -1;
	}
	public void insert(String lastname, String firstname,int age)
	{
		arr[elements]=new ObjectClass(lastname,firstname,age);
		elements++;
	}
	public void delete(String lastname,String firstname,int age)
	{
		int result=-1;
		for(int i=0;i<elements;i++)
		{
			if(arr[i].getLast().equals(lastname))
				result=i;
		}
		if(result==-1)
			System.out.println("The Element is not found to delete");
		else
		{
			for(int i=result;i<elements-1;i++)
			{
				arr[i]=arr[i+1];
			}
			elements--;
		}
	}
}
