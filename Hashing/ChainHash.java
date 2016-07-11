import java.util.Arrays;


public class ChainHash {

	private SortedListL[] arr;
	private int size;
	
	public ChainHash(int value)
	{
		size = value;
		arr = new SortedListL[size];
		for(int i=0;i<size;i++)
			arr[i] = new SortedListL();
		
	}
	
	private int hashFunction(int key)
	{
		return key%size;
	}
	
	public void insert(LinkL d)
	{
		int hashValue = hashFunction(d.key);
	//	System.out.println(hashValue);
		arr[hashValue].insert(d);
	}
	
	public void delete(int key)
	{
		int hashValue = hashFunction(key);
		
		arr[hashValue].delete(key);
	}
	
	public LinkL find(int key)
	{
		int hashValue = hashFunction(key);
		return arr[hashValue].find(key);
	}
	
	public void displayHash()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print( i + " ");
			arr[i].display();
		}
	}
}
