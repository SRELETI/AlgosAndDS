
public class UniquePaths {

	private int unique(int n, int m) {
		int[][] mat = new int[100][100];
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++){
				mat[i][j] = -1;
			}
		}
		return count(0,0,n,m,mat);
	}
	
	private int count(int r, int c, int n, int m,int[][] mat) {
		if(r==n-1 && c == m-1)
			return 1;
		if(r>n-1 || c>m-1)
			return 0;
		if(mat[r+1][c]==-1)
			mat[r+1][c] = count(r+1,c,n,m,mat);
		if(mat[r][c+1]==-1)
			mat[r][c+1] = count(r,c+1,n,m,mat);
		return mat[r+1][c] + mat[r][c+1];
	}
	
	
	public String addBinary(String a, String b) {
        if(a.length()==0 && b.length()==0)
            return "";
        if(a.length()==0)
            return b;
        if(b.length()==0)
            return a;
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        int sum;
        while(len1>0 && len2>0) {
            sum = a.charAt(len1-1)-'0' + b.charAt(len2-1)-'0';
            System.out.println(sum);
            carry = sum/10;
            sb.insert(0, sum%10);
            len1--;
            len2--;
        }
        
        while(len1>0) {
        	sum = (int) a.charAt(len1-1)+ carry;
        	carry = sum/10;
        	sb.insert(0, sum%10);
        	len1--;
        }
        while(len2>0) {
        	sum = (int) b.charAt(len2-1)+ carry;
        	carry = sum/10;
        	sb.insert(0, sum%10);
        	len2--;
        }
        if(carry==1)
        	sb.insert(0, carry);
        return sb.toString();
    }
	public int comb(int m,int n) {
		int noOfSteps = n+m-2;
		int down = m-1;
		int res =1;
		for(int i=1;i<=down;i++) {
			res = res*(noOfSteps-down+1)/i;
		}
		return res;
	}
	
	public static void main(String args[]) {
		UniquePaths u = new UniquePaths();
		System.out.println(u.addBinary("0", "0"));
	}
	
}
