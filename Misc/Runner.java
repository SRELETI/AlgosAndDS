
public class Runner implements Runnable{
	private String winner;
	public Runner()
	{
		System.out.println("Race is about to begin");
	}
	public void race()
	{
		System.out.println(Thread.currentThread().getName()+" has started the race");
			for(int i=1;i<=100;i++)
			{
				System.out.println(Thread.currentThread().getName()+" has travelled " +i +" meters");
				boolean isRace=isRaceWin(i);
				if(isRace)
				{
					break;
				}
			}
		
	}
	public boolean isRaceWin(int distance)
	{
		if((winner==null)&&(distance==100))
			{
				winner=Thread.currentThread().getName();
				System.out.println("The Winner is "+winner);
				return true;
			}
		else if(winner!=null)
		{
			System.out.println(Thread.currentThread().getName()+ " has only travelled "+ distance+" meters");
			return true;
		}
		else
		{
			return false;
		}
	}
	public void run()
	{
		race();
	}
	
}
