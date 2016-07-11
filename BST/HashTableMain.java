
public class HashTableMain {

	private HashTable item;
	
	private HashTable[] arr;
	private int arrSize;
	private HashTable nonitem;
	
	public HashTableMain(int size)
	{
		arrSize = size;
		arr = new HashTable[size];
		nonitem = new HashTable(-1);
	}
	
	public void insert(HashTable i)
	{
		int key = i.getKey();
		
		int hashValue = hashFunction(key);
		
		while(arr[hashValue]!=null && arr[hashValue]!=nonitem)
		{
			hashValue++;
			hashValue = hashValue%arrSize;
		}
		arr[hashValue]=i;
	}
	
	public HashTable find(int key)
	{
		int hashValue = hashFunction(key);
		
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].getKey()==key)
				return arr[hashValue];
			hashValue++;
			hashValue= hashValue%arrSize;
		}
		return null;
	}
	
	public HashTable delete(int key)
	{
		int hashValue = hashFunction(key);
		while(arr[hashValue]!=null)
		{
			if(arr[hashValue].getKey()==key)
			{
				HashTable temp = arr[hashValue];
				arr[hashValue]= nonitem;
				return temp;
			}
			hashValue++;
			hashValue = hashValue%arrSize;
		}
		return null;
	}
	
	private int hashFunction(int key)
	{
		return key%arrSize;
	}
}
