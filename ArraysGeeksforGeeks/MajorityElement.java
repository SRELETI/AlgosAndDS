
public class MajorityElement {
	private int[] arr;
	private int elements;
	public MajorityElement(int length)
	{
		elements=0;
		arr=new int[length];
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public int majority()
	{
		int count;
		for(int i=0;i<arr.length;i++)
		{
			count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					count++;
				if(count>arr.length/2)
					return arr[i];
			}
		}
		return -1;
	}
	public void mooreAlgo()
	{
		int maj_index=0;
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[maj_index]==arr[i])
				count++;
			else
				count--;
			if(count==0)
			{
				maj_index=i;
				count=1;
			}
		}
		System.out.println(arr[maj_index]);
		//System.out.println(findN(arr[maj_index]));
		//System.out.println(findMaj(arr[maj_index]));
	}
	public int findMaj(int index)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==index)
				count++;
			if(count>arr.length/2)
				return arr[i];
		}
		return -1;
	}
	public int findN(int index)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==index)
				count++;
			if(count==arr.length/2)
				return arr[i];
		}
		return -1;
	}
	public static void main(String args[])
	{
		MajorityElement me = new MajorityElement(5);
		me.insert(2);
		me.insert(2);
		me.insert(2);
		me.insert(4);
		me.insert(5);
		//me.insert(6);
		System.out.println(me.majority());
		me.mooreAlgo();
	}
}

