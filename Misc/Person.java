
public class Person {
	private String firstname;
	private String lastname;
	private int age;
	public Person(String Firstname,String Lastname,int age1)
	{
		firstname=Firstname;
		lastname=Lastname;
		age=age1;
	}
	public int getAge()
	{
		return age;
	}
	public String getLast()
	{
		return lastname;
	}
	public void setAge(int ages)
	{
		age=ages;
	}
	public void display()
	{
		System.out.print(firstname+" ");
		System.out.print(lastname+" ");
		System.out.print(age+" ");
		System.out.println();
	}
}
