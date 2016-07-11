import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class DPProblems {

	public static void main(String args[]) throws FileNotFoundException {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
	//	System.out.println(lcs(s1,s2));
	//	System.out.println(editDistance("SUNDAY","SATURDAY"));
		int[][] cost = {{1,2,3},{4,8,2},{1,5,3}};
	//	System.out.println(minCostPath(cost,2,2));
		int[] coins = {1,2,3};
	//	System.out.println(coinChange(coins,3,4));
	//	System.out.println(coinChangeDP(coins,3,4));
	//	readInput();
		System.out.println(Integer.MIN_VALUE-1);
		char c = ' '; 
	}
	
	public static int lcs(String s1, String s2) {
		if(s1==null || s2==null) return 0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	public static int editDistance(String s1, String s2) {
		if(s1==null && s2==null) return 0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
				else {
					dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+((s1.charAt(i-1)==s2.charAt(j-1))?0:1)));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	public static int minCostPath(int[][] cost, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = cost[0][0];
		for(int i=1;i<=m;i++) 
			dp[i][0] = dp[i-1][0]+cost[i][0];
		for(int j=1;j<=n;j++) 
			dp[0][j] = dp[0][j-1]+cost[0][j];
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]))+cost[i][j];
			}
		}
		return dp[m][n];
	}
	
	public static int coinChange(int[] coins, int noOfCoins, int total) {
		if(total==0) return 1;
		if(total<0) return 0;
		if(noOfCoins<=0 && total>0) return 0;
		return coinChange(coins,noOfCoins-1,total)+coinChange(coins,noOfCoins,total-coins[noOfCoins-1]);
	}
	
	public static int coinChangeDP(int[] coins, int noOfCoins, int total) {
		if(total==0) return 1;
		int[][] dp = new int[total+1][noOfCoins];
		for(int i=0;i<noOfCoins;i++) 
			dp[0][i] = 1;
		for(int i=1;i<=total;i++) {
			for(int j=0;j<noOfCoins;j++) {
				int x = i-coins[j]>=0 ? dp[i-coins[j]][j]:0;
				int y = j>0 ? dp[i][j-1]:0;
				dp[i][j] = x+y;
			}
		}
		return dp[total][noOfCoins-1];
	}
	
	public static void readInput() throws FileNotFoundException{
		Scanner s = new Scanner((new FileReader("C:\\Users\\IBM_ADMIN\\Desktop\\hack.txt")));
        int testCases = s.nextInt();
        for(int j=0;j<testCases;j++) {
            int N = s.nextInt();
            int[] a = new int[N];
            for(int i=0;i<N;i++) {
                a[i] = s.nextInt();
            }
            long cur_con_max = a[0];
            long cur_ncon_max = a[0]>0?a[0]:0;
            long total_con_max = a[0];
            long total_ncon_max = a[0]>0?a[0]:0;
            for(int i=1;i<N;i++) {
                cur_con_max = Math.max(cur_con_max+a[i],a[i]);
                cur_ncon_max = Math.max(cur_ncon_max+a[i],cur_ncon_max);
                total_con_max = Math.max(total_con_max,cur_con_max);
                total_ncon_max = Math.max(total_ncon_max,cur_ncon_max);
            }
            System.out.println(total_con_max+" "+total_ncon_max);
        }
	}
	
	
	
}
