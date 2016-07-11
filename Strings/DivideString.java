
public class DivideString {

	public void printString(String s,int part)
	{
		for(int i=0;i<s.length();i++)
		{
			if(i%part==0 && i!=0)
				System.out.println();
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String args[])
	{
		String s = "a_simple_divide_string_quest";
		DivideString d = new DivideString();
		d.printString(s, 7);
	}
}
