
public class MultiThreading {
	public static void main(String args[])
	{
		Runner rs=new Runner();
		Thread firstracer=new Thread(rs,"FirstRacer");
		Thread secondracer=new Thread(rs,"SecondRacer");
		//Thread thirdracer=new Thread(rs,"ThirdRacer");
		firstracer.start();
		secondracer.start();
		//thirdracer.start();

	}
}
