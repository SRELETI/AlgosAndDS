import java.util.Arrays;


public class CountPowerPairs {

	public void power(int[] X, int[] Y)
	{
		int[] noOf = {0,0,0,0,0};
		for(int i=0;i<Y.length;i++)
		{
			if(Y[i]<5)
				noOf[Y[i]]++;
		}
		Arrays.sort(Y);
		int total=0;
		for(int i=0;i<X.length;i++)
		{
			total = total+ count_now(X[i],Y,noOf);
		}
		System.out.println(total);
	}
	
	private int count_now(int a, int[] Y,int[] noOf)
	{
		if(a==0)
			return 0;
		if(a==1)
			return noOf[0];
		int count=0;
		int index = findCeil(a,Y);
		if(index!=-1)
			count = Y.length-1-index;
		count = count + noOf[1]+noOf[0];
		if(a==2)
		{
			count = count - noOf[2]-noOf[3];
		}
		if(a==3)
			count = count + noOf[2];
		return count;
	}
	
	private int findCeil(int a, int[] Y)
	{
		if(a<=Y[0])
			return 0;
		if(a>Y[Y.length-1])
			return -1;
		
		for(int i=0;i<Y.length-1;i++)
		{
			if(a>=Y[i]&&a<Y[i+1])
				return i;
		}
		if(a==Y[Y.length-1])
			return Y.length-1;
		return -1;
	}
	
	public static void main(String args[])
	{
		int[] X = {10, 19, 18};
		int[] Y = {11, 15, 9};
		CountPowerPairs c = new CountPowerPairs();
		c.power(X, Y);
	}
}
