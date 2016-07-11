
public class HashTableApp {

	public static void main(String args[])
	{
		HashTableMain h = new HashTableMain(10);
		HashTable first = new HashTable(40);
		HashTable second = new HashTable(55);
		HashTable third = new HashTable(15);
		h.insert(first);
		h.insert(second);
		h.insert(third);
		
		System.out.println(h.find(40).key);
		h.delete(40);
		System.out.println(h.find(40));
		
	}
}
