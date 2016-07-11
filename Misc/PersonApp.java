
public class PersonApp {
	public static void main(String args[])
	{
		PersonUsed pu;
		int length=20;
		pu=new PersonUsed(length);
		pu.insert("sudeep","eleti",24);
		pu.insert("Sandeep","le",25);
		pu.insert("VenkatRamReddy","le",48);
		pu.insert("Padma","i",45);
		//pu.display();
		pu.insert("Premala","a",48);
		//System.out.println("before");
		//pu.display();
		pu.Sorting();
		//System.out.println("After Sorting \n");
		//pu.display();
		//pu.delete("a");
		pu.display();
		//System.out.println("The median is \n");
		//pu.median();
		//System.out.println("The array after removal of duplicates");
		//pu.removeDup();
		//pu.oddEvenSort();
		//pu.display();
	}
}
