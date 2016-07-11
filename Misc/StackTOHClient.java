
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class StackTOHClient {

	public static void main(String args[]) {
		int numOfDisks = 3;
		StackTOH src = new StackTOH(3);
		StackTOH dest = new StackTOH(3);
		StackTOH aux = new StackTOH(3);
		
		iterativeTOH(src,dest,aux,numOfDisks);
	}
	
	private static void iterativeTOH(StackTOH src, StackTOH dest, StackTOH aux, int numOfDisks) {
		char s ='S'; char d = 'D'; char a ='A';
		if(numOfDisks%2 == 0) {
			StackTOH temp = dest;
			dest = aux;
			aux = temp;
		}
		
		int noOfSteps = (int)Math.pow(2, numOfDisks)-1;
		
		for(int i=numOfDisks;i>0;i--) 
			src.push(i);
		for(int i = 1;i<=noOfSteps;i++) {
			if(i%3 == 1) {
				moveDisk(src,dest,s,d);
			}
			else if(i%3 == 2) {
				moveDisk(src,aux,s,a);
			}
			else {
				moveDisk(aux,dest,a,d);
			}
		}
	}
	
	private static void moveDisk(StackTOH s1, StackTOH s2, char ss1, char ss2) {
		int s1Val = s1.pop();
		int s2Val = s2.pop();
		if(s1Val == Integer.MIN_VALUE) {
			s1.push(s2Val);
			moveDiskDisplay(ss2,ss1,s2Val);
		}
		else if(s2Val == Integer.MIN_VALUE) {
			s2.push(s1Val);
			moveDiskDisplay(ss1,ss2,s1Val);
		}
		else if(s1Val > s2Val) {
			s1.push(s1Val);
			s1.push(s2Val);
			moveDiskDisplay(ss2,ss1,s2Val);
		}
		else {
			s2.push(s2Val);
			s2.push(s1Val);
			moveDiskDisplay(ss1,ss2,s1Val);
		}
	}
	
	private static void moveDiskDisplay(char src, char dest, int val) {
		System.out.println("Disk "+val+" Moved from "+src+" to "+dest);
	}
	
}
