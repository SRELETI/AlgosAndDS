
public class PersonUsed {
	Person[] arr;
	int elements;
	public PersonUsed(int length)
	{
		arr=new Person[length];
		elements=0;
	}
	public void Sorting()
	{
		//int count=0;
		//int copies=0;
		for(int j=1;j<elements;j++)
		{
			Person key=arr[j];
			int i=j-1;
			while(i>=0 && arr[i].getAge()>=key.getAge())
			{
				if(arr[i].getAge()==key.getAge())
					arr[i].setAge(-1);
				i=i-1;
			}
			while(i>=0 && arr[i].getAge()>=key.getAge())
			{
				//count++;
					//copies++;
				arr[i+1]=arr[i];
				i=i-1;
			}
			arr[i+1]=key;
			//copies++;
		}
		//System.out.println(count+" "+copies);
	}
	public void removeDup()
	{
		int i=0;
		for(int j=1;j<elements;j++)
		{
			if(arr[j].getAge()!=arr[i].getAge())
			{
				i++;
				arr[i]=arr[j];
			}
		}
		System.out.println(i);
		for(int k=i+1;k<elements;k++)
		{
			delete(arr[k].getLast());
		}
		display();
	}
	public void insert(String Firstname,String Lastname,int age1)
	{
		arr[elements]=new Person(Firstname,Lastname,age1);
		elements++;
	}
	public void delete(String Lastname)
	{
		int index=-1;
		for(int i=0;i<elements;i++)
		{
			if(arr[i].getLast().equals(Lastname))
			{
				index=i;
			}
		}
		if(index!=-1)
		{
			for(int i=index;i<elements;i++)
			{
				arr[index]=arr[index+1];
			}
			elements--;
		}
		else
		{
			System.out.println("Element not found to delete");
		}
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			arr[i].display();
		}
	}
	public void median()
	{
		arr[elements/2].display();
	}
	public void oddEvenSort()
	{
		for(int i=0;i<elements/2;i++)
		{
			for(int j=0;j+1<elements;j+=2)
			{
				if(arr[j].getAge()>arr[j+1].getAge())
				{
					Person temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			for(int j=1;j+1<elements;j+=2)
			{
				if(arr[j].getAge()>arr[j+1].getAge())
				{
					Person temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
