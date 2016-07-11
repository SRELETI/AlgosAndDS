import java.util.Arrays;
import java.util.Random;


public class GreedyKnapSack {
	private double[] weights;
	private double[] values;
	private double[] taken;
	public GreedyKnapSack(int n)
	{
		weights=new double[n];
		values=new double[n];
		taken=new double[n];
	}
	public void generateRandom()
	{
		Random rad=new Random();
		for(int i=0;i<weights.length;i++)
		{
			weights[i]=rad.nextInt(10);
			values[i]=rad.nextInt(5);
		}
		System.out.println(Arrays.toString(weights));
		System.out.println(Arrays.toString(values));
	}
	public void unitWeightValueOrder()
	{
		for(int i=0;i<weights.length;i++)
		{
			for(int j=1;j<weights.length-i;j++)
			{
				double x=weights[j-1]/values[j-1];
				double y=weights[j]/values[j];
				if(x<=y)
				{
					double temp=weights[j-1];
					weights[j-1]=weights[j];
					weights[j]=temp;
					double temp2=values[j-1];
					values[j-1]=values[j];
					values[j]=temp2;
				}
			}
		}
		System.out.println("After ordering");
		System.out.println(Arrays.toString(weights));
		System.out.println(Arrays.toString(values));
	}
	public void knapsack(int cap)
	{
		int j;
		unitWeightValueOrder();
		for(int i=0;i<values.length;i++)
			taken[i]=0;
		for(j=0;j<values.length;j++)
		{
			if(weights[j]<=cap)
			{
				taken[j]=1;
				cap=(int) (cap-weights[j]);
			}
			else
			{
				break;
			}
		}
		if(j<values.length)
		{
			taken[j]=cap/weights[j];
		}
		System.out.println(Arrays.toString(taken));
	}
	public static void main(String args[])
	{
		GreedyKnapSack gks=new GreedyKnapSack(4);
		gks.generateRandom();
		gks.knapsack(10);
	}
}
