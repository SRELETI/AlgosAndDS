
public class BestTimeToSell {

	public void timeToBuySell(int[] arr) {
		if(arr == null || arr.length==0)
			return;
		int min = 0;
		int maxDiff = 0;
		int buy=0;
		int sell=0;
		int diff;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[min]) {
				min = i;
			}
			diff = arr[i]-arr[min];
			if(diff>maxDiff) {
				maxDiff = diff;
				 sell = i;
				 buy = min;
			}
		}
		if(maxDiff==0) {
			System.out.println("You cant get profit at all ");
		}
		else {
			System.out.println("Maximum profit can be obtained by buying on day "+min+" and selling on day "+sell+" and the profit is "+maxDiff);
		}
	}
	
	
	public static void main(String args[]) {
		BestTimeToSell b = new BestTimeToSell();
		int[] arr = {40,20,60,100};
		b.timeToBuySell(arr);
	}
}
