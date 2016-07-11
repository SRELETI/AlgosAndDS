
public class DoubleHash {

	private Hash dataItem;
	private Hash[] arr;
	private int size;
	private Hash nonItem;
	
	public DoubleHash(int size)
	{
		this.size = size;
		dataItem = new Hash(-1);
		arr = new Hash[size];
	}
	
	private int hashFunction(int key)
	{
		return key%size;
	}
	
	private int hashFunction2(int key)
	{
		return 5-(key%5);
	}
	
	public void insert(Hash d)
	{
		int key = d.getKey();
		int hashValue = hashFunction(key);
		int step = hashFunction2(key);
		while(arr[hashValue]!=null && arr[hashValue]!=nonItem)
		{
			hashValue = hashValue+step;
			hashValue = hashValue%size;
		}
		arr[hashValue]=d;
	}
	
	public Hash delete(int key)
	{
		int hashValue = hashFunction(key);
		int step = hashFunction2(key);
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].key == key)
			{
				Hash temp = arr[hashValue];
				arr[hashValue]= nonItem;
				return temp;
			}
			hashValue = hashValue+step;
			hashValue = hashValue%size;
		}
		return null;
	}
	
	public Hash find(int key)
	{
		int hashValue = hashFunction(key);
		int step = hashFunction2(key);
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].key == key)
				return arr[hashValue];
			hashValue = hashValue + step;
			hashValue = hashValue%size;
		}
		return null;
	}
	
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			if(arr[i]!=null)
				System.out.print(arr[i].key+" ");
			else
				System.out.print(null+" ");
		}
	}
}
