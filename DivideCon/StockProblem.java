class PairStock
{
	int buy;
	int sell;
	public PairStock()
	{
		buy=0;
		sell=0;
	}
}
public class StockProblem {

	public void stock(int[] arr)
	{
		if(arr.length==1)
			return;
		int i=0;
		int count = 0;
		PairStock pair[] = new PairStock[arr.length/2];
		for(int k=0;k<pair.length;k++)
		{
			pair[k] = new PairStock();
		}
		while(i<arr.length-1)
		{
			while(i<arr.length-1 && arr[i+1]<=arr[i])
				i++;
			if(i==arr.length-1)
				break;
			pair[count].buy = i++;
			while(i<arr.length && arr[i]>=arr[i-1])
				i++;
			pair[count].sell = i-1;
			count++;
		}
		if(count==0)
		{
			System.out.println("Profit cannot be achieved on any day");
			return;
		}
		for(i=0;i<count;i++)
		{
			System.out.println("Buy "+arr[pair[i].buy]+" Sell "+arr[pair[i].sell]);
		}
	}
	
	public static void main(String args[])
	{
		int[] price = {100,180,260,310,40,535,695};
		StockProblem s = new StockProblem();
		s.stock(price);
	}
}
