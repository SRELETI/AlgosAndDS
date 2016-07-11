
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class BitsAllInOne {

	/*
	 * Find a number which occured one time among other numbers which occured 3 times
	 */
	public int get1Number(int[] arr) {
		int result = 0;
		for(int i=0;i<32;i++) {
			int sum = 0;
			int x = 1<<i;
			for(int j=0;j<arr.length;j++) {
				if((arr[j]&x)>0) 
					sum++;
			}
			if(sum%3!=0) 
				result = result|sum;
		}
		return result;
	}
	
	/*
	 * Checks if two numbers are of opp sign
	 */
	public boolean checkOpp(int a, int b) {
		return (a^b)<0;
	}
	
	public boolean checkOpp2(int a, int b) {
		return (a>0) ? (b<0) : (b>0);
	}
	
	public boolean checkOpp3(int a, int b) {
		return ((a^b)>>>31)>0;
	}
	
	/*
	 * Counts all the set bits from 1 to n
	 */
	public int countSetBits(int n) {
		int result = 0;
		for(int i=0;i<32;i++) {
			int x = 1<<i;
			for(int j=1;j<=n;j++) {
				if((j&x)>0)
					result++;
			}
		}
		return result;
	}
	
	/*
	 * Count all the set bits from 1 to n
	 */
	public int countSetBitsRec(int n){
		int m = getLeftMostBit(n);
		return countBits(n,m);
	}
	
	private int getLeftMostBit(int n) {
		int m = 0;
		while(n>1) {
			n = n>>1;
			m++;
		}
		return m;
	}
	
	private int countBits(int n, int m) {
		if(n==0) return 0;
		if(n==((1<<(m+1))-1))
			return (m+1)*(1<<m);
		n = n-(1<<m);
		return (n+1)+countSetBitsRec(n)+(m*(1<<(m-1)));
	}
 	
	/*
	 * Swap bits in a given number
	 */
	public void swapBits(int num,int p1, int p2, int n) {
		int a = ((num>>p1) & (1<<n)-1);
		int b = ((num>>p2) & (1<<n)-1);
		int xor = a ^ b;
		xor = (xor<<p1) | (xor<<p2);
		int result = xor ^ num;
		System.out.println(result);
	}
	
	/*
	 * Addition of two numbers without using arithmetic operations
	 */
	public int addition(int a, int b) {
		while(b!=0) {
			int carry = a&b;
			a = a^b;
			b = carry<<1;
		}
		return a;
	}
	
	public int rec_addition(int a, int b) {
		if(b==0) return a;
		return rec_addition(a^b, (a&b)<<1);
	}
	
	/*
	 * Minimum of two numbers
	 */
	public int getMin(int x, int y) {
		return y+((x-y)&(x-y)>>31);
	}
	
	public int getMax(int x, int y) {
		return x-((x-y)&(x-y)>>31);
	}
	
	/*
	 * Smallest of three Integers
	 */
	public int getMinThree(int a, int b,int c) {
		int count = 0;
		while(a!=0 && b!=0 && c!=0) {
			a--;
			b--;
			c--;
			count++;
		}
		return count;
	}
	
	public int getMinThree2(int a, int b, int c) {
		return getMin(a,getMin(b,c));
	}
	
	public int getMinThree3(int a,int b, int c) {
		if(b/a==0) 
			return b/c==0 ? b:c;
		return a/c==0 ? a:c;
	}
	
	public int getMaxThree(int a,int b, int c) {
		int count = 0;
		while(a>0 || b>0 || c>0) {
			a--;
			b--;
			c--;
			count++;
		}
		return count;
	}
	
	public int getMaxThree2(int a,int b, int c) {
		return getMax(a,getMax(b,c));
	}
	
	public int getMaxThree3(int a,int b, int c) {
		if(a/b==0)
			return c/b==0 ? b : c;
		return a/c==0 ? c: a;
	}
	
	/*
	 * Count set bits in a number
	 */
	public int countSetBitsNum(int num) {
		int count = 0;
		while(num!=0) {
			num = num & (num-1);
			count++;
		}
		return count;
	}
	
	/*
	 * Add 1 to a number
	 */
	public int addNumber1(int num) {
		int x = 1;
		while(num>0) {
			int carry = x&num;
			x = num ^ x;
			num = carry<<1;
		}
		return x;
	}
	
	/*
	 * Multiplying with 3.5
	 */
	public int mul35(int n) {
		return (n<<1) + n + (n>>1);
	}
	
	public int mul35Sec(int n) {
		return ((n<<3)-n)>>1;
	}
	
	/*
	 * turn rightmost set bit
	 */
	public int unSetRghtBit(int n) {
		return n & (n-1);
	}
	
	/*
	 * How to check if a number is powr of 4.
	 */
	public boolean checkPower4(int n) {
		if(n==0) return false;
		if(n==1) return true;
		if(n%4!=0) return false;
		return checkPower4(n/4);
	}
	
	public boolean checkPower4_Sec(int n) {
		if(n==0) return false;
		if((n&(n-1))==0) {
			int count = 0;
			while(n>1) {
				n=n>>1;
				count++;
			}
			return count%2==0;
		}
		return false;
	}
	
	/*
	 * Check if a number is divisible by 7
	 */
	
	public boolean isDivisble7(int n) {
		return isDivisble7Utils(n)==0;
	}
	public int isDivisble7Utils(int n) {
		if(0<= n && n<=6) return n;
		if(7<=n && n<=9) return n-7;
		if(n<0) return -(isDivisble7Utils(-n));
		return isDivisble7Utils(shrink(n));
	}
	
	private int shrink(int n) {
		boolean isFirst = true;
		boolean isSecond = false;
		boolean isThird = false;
		boolean isAdd = true;
		int total = 0;
		int sum = 0;
		while(n>0) {
			int rem = n%10;
			n = n/10;
			if(isFirst) {
				sum = sum+rem;
				isFirst = false;
				isSecond = true;
			}
			else if(isSecond) {
				sum = sum+(3*rem);
				isSecond = false;
				isThird = true;
			}
			else {
				sum = sum+(2*rem);
				isThird = false;
				isFirst = true;
				if(isAdd)
					total = total+sum;
				else
					total = total-sum;
				sum = 0;
				isAdd = !isAdd;
			}
		}
		if(sum!=0) {
			if(isAdd) 
				return total = total+sum;
			else
				return total = total-sum;
		}
		return total;
	}
	
	/*
	 * Abs value without branching
	 */
	public int abs(int n) {
		int mask = n>>31;
		int in = mask+n;
		return in^mask;
	}
	
	/*
	 * Rotate bits of a number
	 */
	public int leftRotation(int n,int d) {
		return n<<d | n>>>(32-d);
	}
	
	public int rightRotation(int n, int d) {
		return n>>d | n<<(32-d);
	}
	
	
	public boolean intOverflow(int a, int b) {
		if(a>Integer.MAX_VALUE-b)
			return true;
		else {
			System.out.println(Integer.MIN_VALUE+" "+Integer.MAX_VALUE);
			System.out.println(a+b);
			return false;
		}
	}
	
	/*
	 * Next highest power of 2
	 */
	public int next2(int n) {
		int count = 0;
		while(n>0) {
			count++;
			n=n>>1;
		}
		return 1<<count;
	}
	
	public int next2_Sec(int n) {
		n = n-1;
		n = n|n>>1;
		n = n|n>>2;
		n = n|n>>4;
		n = n|n>>8;
		n = n|n>>16;
		n++;
		return n;
	}
	
	/*
	 * check if a number is a multiple of 3
	 */
	public boolean checkMul3(int n) {
		if(n==0) return true;
		if(n==1) return false;
		int odd_count =0;
		int even_count = 0;
		while(n>0) {
			if((n&1)==1)
				odd_count++;
			n=n>>1;
			if((n&1)==1)
				even_count++;
			n=n>>1;
		}
		return checkMul3(Math.abs(even_count-odd_count));
	}
	
	/*
	 * Parity
	 */
	public void parity(int n) {
		boolean Evenparity = true;
		while(n>0) {
			Evenparity = !Evenparity;
			n = n&(n-1);
		}
		System.out.println("The parity of the number is "+(Evenparity?"Even":"Odd"));
	}
	
	/*
	 * Position of rightmost set bit
	 */
	public int setBitPosition(int num) {
		return (int)((Math.log(num&-num)/Math.log(2))+1);
	}
	
	/*
	 * swap all even and odd bits in a number
	 */
	public void swapEvenOdd(int num) {
		int even = num & 0xAAAAAAAA;
		int odd  = num & 0x55555555;
		even = even>>1;
		odd = odd<<1;
		int result = even | odd;
		System.out.println(result);
	}
	
	/*
	 * Position of only set bit
	 */
	public int positionSetBit(int num) {
		if(num==0)
			return -1;
		if((num&(num-1))!=0)
			return -1;
		return (int)((Math.log(num&-num)/Math.log(2)) + 1);
	}
	
	public boolean isMul8(int num) {
		return (num&7)==0;
	}
	
	public boolean isMul9(int num) {
		if(num==0||num==9) return true;
		if(num<10) return false;
		return isMul9((num>>8 - num&7));
	}
	
	/*
	 * Check if binary rep of a num is palindrome
	 */
	public boolean isPalindrome(int num) {
		int left = 0;
		int right = 31;
		while(left<right) {
			if(isSet(num,left)!=isSet(num,right)) 
				return false;
			left++;right--;
		}
		return true;
	}
	
	public boolean isSet(int num, int index) {
		return (num & (1<<index))==0?false:true;
	}
	
	public void swapNipples(int num) {
		int first = (num & 0x0F);
		int second = (num & 0xF0);
		first = first <<4;
		second = second >>4;
		System.out.println(first|second);
	}
	
	public void nextGreaterSameBits(int num) {
		int rightMostBit = num & -num;
		int leftSide = num + rightMostBit;
		int rightOnesPattern = leftSide^num;
		rightOnesPattern = (rightOnesPattern>>2)/rightMostBit;
		System.out.println(leftSide | rightOnesPattern);
	}
	
	public void nextSmallerSameBits(int num) {
		int greater = num +1;
		int comm = num & greater;
		int xor = num ^ greater;
		System.out.println(comm-((comm&-comm)/(xor+1)));	
	}
	
	public static void main(String args[]) {
		BitsAllInOne bits = new BitsAllInOne();
		int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
	//	System.out.println(bits.get1Number(arr));
	//	System.out.println(bits.checkOpp(100, 100));
	//	System.out.println(bits.checkOpp2(100, 100));
	//	System.out.println(bits.checkOpp3(100, 100));
	//	System.out.println(bits.countSetBits(8));
	//	System.out.println(bits.countSetBitsRec(8));
	//	bits.swapBits(28, 0, 3, 2);
	//	System.out.println(bits.addition(4, 3));
	//	System.out.println(bits.rec_addition(4, 3));
	//	System.out.println("Mx "+bits.getMax(15, 6)+" Mn "+bits.getMin(15, 6));
	//	System.out.println("Mx "+bits.getMaxThree(78, 88, 68)+" Max "+bits.getMaxThree2(78, 88, 68)+" Max "+bits.getMaxThree3(78, 88, 68));
	//	System.out.println("Mx "+bits.getMinThree(78, 88, 68)+" Max "+bits.getMinThree2(78, 88, 68)+" Max "+bits.getMinThree3(78, 88, 68));
	//	System.out.println(bits.countSetBitsNum(-2));
	//	System.out.println(bits.addNumber1(4));
	//	System.out.println(bits.mul35(2));
	//	System.out.println(bits.mul35Sec(2));
	//	System.out.println(bits.unSetRghtBit(7));
	//	System.out.println(bits.checkPower4(1));
	//	System.out.println(bits.checkPower4_Sec(1));
	//	System.out.println(bits.isDivisble7(335188));
	//	System.out.println(bits.abs(-4));
	//	System.out.println(bits.leftRotation(16, 2));
	//	System.out.println(bits.rightRotation(16, 2));
	//	System.out.println(Integer.MAX_VALUE-Integer.MIN_VALUE);
	//	System.out.println(bits.intOverflow(Integer.MIN_VALUE, Integer.MIN_VALUE-1));
	//	System.out.println(bits.next2(17));
	//	System.out.println(bits.next2_Sec(17));
	//	System.out.println(bits.checkMul3(21));
	//	bits.parity(1);
	//	System.out.println(bits.setBitPosition(19));
	//	bits.swapEvenOdd(23);
	//	System.out.println(bits.positionSetBit(128));
	//	for(int i=0;i<25;i++) {
	//		System.out.println(i+" "+(bits.isMul8(i)==true?"Yes":"No"));
	//	}
	//	System.out.println(bits.isPalindrome((1<<31)+(1)));
	//	bits.swapNipples(100);
	//	bits.nextGreaterSameBits(-1);
		bits.nextSmallerSameBits(9);
	}
	
	
}
