
public class TrappingRain {


	private int trapRain(int[] A) {
		if(A.length<=2)
			return 0;
		int a = 0;
		int b = A.length-1;
		int leftM = 0;
		int rightM = 0;
		int max = 0;
		while(a<b) {
			leftM = Math.max(leftM, A[a]);
			rightM = Math.max(rightM, A[b]);
			if(leftM<rightM) {
				max = max + leftM-A[a];
				a++;
			}
			else {
				max = max + rightM-A[b];
				b--;
			}
		}
		return max;
	}
	
	public static void main(String args[]) {
		TrappingRain t = new TrappingRain();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(t.trapRain(A));
		String s="";
		System.out.println(s.length());
	}
}
