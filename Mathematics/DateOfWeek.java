
public class DateOfWeek {

	public int calc(int d, int m, int y)
	{
		int[] month = {0,3,2,5,0,3,5,1,4,6,2,4};
		if(m<3)
			y=y-1;
		int result = (y+(y/4)-(y/100)+(y/400)+month[m-1]+d)%7;
	//	System.out.println(result);
		return result;
	}
	
	public static void main(String args[])
	{
		DateOfWeek d = new DateOfWeek();
		int result = d.calc(30, 8, 2010);
		System.out.println(result);
	}
	
}
