import java.util.Calendar;


public class Test {

public void calculateYearAndMonth() {
		
		//Get previous month
		Calendar cal =  Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		int month = cal.get(Calendar.MONTH) + 1; // month indexes from 0 in Calendar api
		int year = cal.get(Calendar.YEAR);
	
		
		System.out.println("Year: " + year + " - " + "Month: " + month);
	}

   public static void main(String args[])
   {
	   Test s = new Test();
	   s.calculateYearAndMonth();
   }
}
