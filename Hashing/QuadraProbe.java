
public class QuadraProbe {

	private Hash dataItem;
	private Hash[] arr;
	private int size;
	private Hash nonItem;
	public QuadraProbe(int size)
	{
		this.size = size;
		arr = new Hash[size];
		nonItem = new Hash(-1);
	}
	
	private int hashFunction(int key)
	{
		return key%size;
	}
	
	public void insert(Hash d)
	{
		int key = d.getKey();
		int hashValue = hashFunction(key);
		int count=1;
		while(arr[hashValue]!=null && arr[hashValue]!=nonItem)
		{
			hashValue = hashValue+ (count*count);
			count++;
			hashValue = hashValue%size;
		}
		arr[hashValue] = d;
	}
	
	public Hash delete(int key)
	{
		int hashValue = hashFunction(key);
		int count=1;
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].key == key)
			{
				Hash temp = arr[hashValue];
				arr[hashValue] = nonItem;
				return temp;
			}
			hashValue = hashValue+ (count*count);
			count++;
			hashValue = hashValue%size;
		}
		return null;
	}
	
	public Hash find(int key)
	{
		int hashValue = hashFunction(key);
		int count =1;
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].key == key)
				return arr[hashValue];
			hashValue = hashValue+(count * count);
			count++;
			hashValue = hashValue%size;
		}
		return null;
	}
	
	public void displayHash()
	{
		for(int i =0; i<size;i++)
		{
			if(arr[i]!=null)
			{
				System.out.print(arr[i].key+" ");
			}
			else
				System.out.print(null+" ");
		}
	}
}
