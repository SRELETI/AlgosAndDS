
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class LongestIncSeq {

	public static void main(String args[]) {
		LongestIncSeq lis = new LongestIncSeq();
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int size = arr.length;
		System.out.println(lis.lis(arr, size));
		System.out.println(lis.lis_dp(arr));
	}
	
	/*
	 * Recursive Approach
	 */
	public int lis(int[] arr, int size) {
		Wrapper_Max max = new Wrapper_Max();
		lisUtils(arr,size,max);
		return max.val;
	}
	
	public int lisUtils(int[] arr, int size, Wrapper_Max max) {
		if(size==1)
			return 1;
		int res;
		int max_ending_here = 1;
		for(int i=1;i<size;i++) {
			res = lisUtils(arr,i,max);
			if(arr[i-1]<arr[size-1] && res+1>max_ending_here)
				max_ending_here = res+1;
		}
		
		if(max.val<max_ending_here) 
			max.val = max_ending_here;
		return max_ending_here;
	}
	
	public int lis_dp(int[] arr) {
		if(arr==null || arr.length==0)
			return 0;
		int[] dp = new int[arr.length];
		int[] prev = new int[arr.length];
		dp[0] = 1;
		prev[0] = -1;
		for(int i=1;i<arr.length;i++) {
			dp[i] =1;
			prev[i] = -1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && (dp[j]+1)>dp[i]) {
					dp[i] = dp[j]+1;
					prev[i] = j;
				}
			}
		}
		int max = 1;
		int end = -1;
		for(int i=1;i<dp.length;i++) {
			if(max<dp[i])
				end = i;
				max = dp[i];
		}
		System.out.print(arr[end]+" ");
		while(end>0 && prev[end]!=-1) { 
			System.out.print(arr[prev[end]]+" ");
			end = prev[end];
		}
		return max;
	}
	
	
	
}
class Wrapper_Max {
	public int val = 1;
}
