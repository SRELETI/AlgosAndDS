import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ListIteratorApp {
	public static void main(String args[]) throws IOException
	{
		ItList lis=new ItList();
		ListIterator li=lis.getIterator();
		li.insertAfter(20);
		li.insertAfter(40);
		li.insertAfter(60);
		while(true)
		{
			System.out.println("Please enter any of the following values: ");
			System.out.println("s"+"      "+"r"+"      "+"n"+"     "+"g"+"     "+"b"+"     "+"a"+"     "+"d"+"     ");
			char choice=getChar();
			switch(choice)
			{
			case 's':
				lis.display();
				break;
			case 'r':
				li.reset();
				break;
			case 'n':
				li.nextLink();
				break;
			case 'g':
				li.getCurrent();
				break;
			default:
				System.out.println("Invalid entry");
				return;
			}
		}
	}
	public static char getChar()throws IOException 
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		char result=s.charAt(0);
		return result;
	}
}
