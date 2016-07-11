
public class ObjectClass {
	private String FirstName;
	private String LastName;
	private int age;
	public ObjectClass(String lastname,String firstname,int ages)
	{
		FirstName=firstname;
		LastName=lastname;
		age=ages;
	}
	public void display()
	{
		System.out.println(FirstName);
		System.out.println(LastName);
		System.out.println(age);
	}
	public String getLast()
	{
		return LastName;
	}
}
