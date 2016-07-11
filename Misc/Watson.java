import java.io.IOException;
import java.util.Scanner;


public class Watson {

	public static void main(String args[]) throws IOException {
		int i=2;
		while(i>0) {
			Scanner s = new Scanner(System.in);
		//	System.out.println("Enter the values for N,p,q");
			int N = s.nextInt();
			int p = s.nextInt();
			int q = s.nextInt();
			Watson wat = new Watson();
			wat.displayAll(N,p,q);
			i--;
			System.out.println();
		}
	}
	
	public void displayAll(int N, int p, int q) {
		for(int i=1;i<=N;i++) {
			if(checkPresent(p,i)==false && checkPresent(q,i)==false) {
				if(i%p==0 && i%q==0) {
					System.out.print("WATSON ");
				}
				else if(i%p==0) {
					System.out.print("WAT ");
				}
				else if(i%q==0){
					System.out.print("SON ");
				}
				else {
					System.out.print(i+" ");
				}
			}
			else {
				System.out.print(i+" ");
			}
		}
	}
	
	public boolean checkPresent(int single, int N) {
		int rem=0;
		while(N!=0) {
			rem = N%10;
			N=N/10;
			if(rem==single) {
				return true;
			}
		}
		return false;
	}
	
}
