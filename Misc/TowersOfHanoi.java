
public class TowersOfHanoi {
	public static void main(String args[])
	{
		doHanoi(64,'A','B','C');
	}
	public static void doHanoi(int topN,char source,char inter,char dest)
	{
		if(topN==1)
			System.out.println("Disk "+topN+" from "+source+" to "+dest );
		else
		{
			doHanoi(topN-1,source,dest,inter);
			System.out.println("Disk "+topN+" from "+source+" to "+dest);
			doHanoi(topN-1,inter,source,dest);
		}
	}
}
