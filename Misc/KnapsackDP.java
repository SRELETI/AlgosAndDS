
public class KnapsackDP {
	public static void main(String args[])
	{
		int val[]={5,5,6,7};
		int wt[]={2,3,5,4};
		int cap=5;
		knapsack(val,wt,cap);
	}
	public static void knapsack(int[] val,int[] wt,int cap)
	{
		int noOfItems=val.length;
		int VD[][]=new int[noOfItems+1][cap+1];
		for(int col=0;col<=cap;col++)
		{
			VD[0][col]=0;
		}
		for(int row=0;row<=noOfItems;row++)
			VD[row][0]=0;
		for(int items=1;items<=noOfItems;items++)
		{
			for(int weights=1;weights<=cap;weights++)
			{
				if(wt[items-1]<=weights)
				{
					VD[items][weights]=Math.max(val[items-1]+VD[items-1][weights-wt[items-1]], VD[items-1][weights]);
				}
				else
				{
					VD[items][weights]=VD[items-1][weights];
				}
			}
		}
		System.out.println(VD[noOfItems][cap]);
	}
}
