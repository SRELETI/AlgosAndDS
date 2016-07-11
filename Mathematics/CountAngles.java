
public class CountAngles {

	public void count(double hours, double min)
	{
		if(hours<0 || hours>12 || min<0 || min>60)
		{
			System.out.println("invalid input ");
			return;
		}
		if(min==0)
		{
			min = 0;
			hours = hours+1;
		}
		if(hours==12)
		{
			hours = 0;
		}
		double hours_angle = (hours*60 + min)* 0.5;
		double min_angle = (hours*60+min)* 6;
		double angle = Math.abs(hours_angle-min_angle);
		System.out.println(360-angle > angle ? angle: 360-angle);
	}
	
	public static void main(String args[])
	{
		CountAngles c = new CountAngles();
		c.count(3, 30);
	}
}
