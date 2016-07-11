import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SuperMarketQueueApp {
	public static void main(String args[]) throws IOException
	{
		int length=5;
		int num;
		int urValue;
		int i=0;
		SuperMarketQueue smq1=new SuperMarketQueue(length);
		SuperMarketQueue smq2=new SuperMarketQueue(length);
		SuperMarketQueue smq3=new SuperMarketQueue(length);
		while(true)
		{
			i++;
			System.out.println("The line 1 Queue");
			smq1.display();
			System.out.println("The line 2 Queue");
			smq2.display();
			System.out.println("The line 3 Queue");
			smq3.display();
			System.out.println("Please Enter the line number which you want to enter, 1 or 2 or 3 ?");
			num=getNumber();
			System.out.println("Please enter ur display number");
			urValue=getNumber();
				
			if(num==1 || num==2 || num==3)
			{
				switch(num)
				{
					case 1:
						smq1.insert(urValue);
						break;
					case 2:
						smq2.insert(urValue);
						break;
					case 3:
						smq3.insert(urValue);
						break;
				}
			}
			else
			{
				System.out.println("You have entered a invalid line number");
				break;
			}
			if(i>=5)
			{
				System.out.println("Enter the line number in which the customer has to be checked out");
				int result=getNumber();
				switch(result)
				{
				case 1:
					smq1.pop();
					break;
				case 2:
					smq2.pop();
					break;
				case 3:
					smq3.pop();
					break;
				default:
					break;
				}
			}
		}
	}
	public static int getNumber() throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int numbe=Integer.parseInt(br.readLine());
		return numbe;
	}
}	
