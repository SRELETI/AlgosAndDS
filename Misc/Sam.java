import java.util.Scanner;

public class Sam
	{
	public static void main(String[] args)
	{
		Scanner point = new Scanner(System.in);	
		System.out.println("Please enter the values of x, y, x1, y1, x2, y2");
		Double x = point.nextDouble();
		Double y = point.nextDouble();
		Double x1 = point.nextDouble();
		Double y1 = point.nextDouble();
		Double x2 = point.nextDouble();
		Double y2 = point.nextDouble();
		if((x2-x1 == 0))
		{
			if(x-x1==0)
			{
				if (y2>y1 ? ((y1<=y && y<=y2) ?  true : false) : ((y2<=y && y<=y1) ? true : false ) == true)
				{
				
					System.out.println("Given point is on the line check 1");
				}
				else
				{
					System.out.println("Given point is not on the line check 1");
				}
			}
			else
			{
				System.out.println("Given point is not on the line check 1");
			}
		}
		else
		{
			Double m = (y2-y1) / (x2-x1);
			Double c = y1 - (m * x1);
			if ((y == (m*x) + c))
			{
				System.out.println("Given point is on the line");
			}
			else
			{ 
				System.out.println("Given Point is not on the line");
			}
		}

	}
}