
public class CountPossible {

	public int count(char[] arr, int n) {
		if(n==0 || n==1)
			return 1;
		int count = 0;
		if(arr[n-1]!='0')
			count = count(arr,n-1);
		if(n>1 && arr[n-2]<'2' || arr[n-2]=='2' && arr[n-1]<'7')
			count = count + count(arr,n-2);
		return count;
	}
	
	public static void main(String args[]) {
		CountPossible c = new CountPossible();
		char[] text = {'1','0','1'};
	//	System.out.println(c.count(text, text.length));
		System.out.println(c.count_dp(text, text.length));
	}
	
	public int count_dp(char[] arr, int n) {
		if(n==0 || n==1)
			return 1;
		int[] count = new int[n+1];
		count[0]= count[1]=1;
		for(int i=2;i<=n;i++) {
			if(arr[i-1]!='0') {
				count[i]=count[i-1];
			}
			if(arr[i-2]>'0' && arr[i-2]<'2' || arr[i-2]=='2' && arr[i-1]<'7')
				count[i]=count[i]+count[i-2];
		}
		return count[n];
	}
}
