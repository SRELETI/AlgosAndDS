
public class MedianSortedArray {

	public int median(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		
		if((m+n)%2!=0)
			return findNow(A,B,(m+n)/2,0,m-1,0,n-1);
		else
		{
			return (findNow(A,B,(m+n)/2,0,m-1,0,n-1) + findNow(A,B,((m+n)/2)-1,0,m-1,0,n-1))/2;
		}
	}
	
	private int findNow(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd-aStart+1;
		int bLen = bEnd-bStart+1;
		if(aLen==0)
			return B[bStart+k];
		if(bLen==0)
			return A[aStart+k];
		if(k==0)
			return A[aStart]<B[bStart] ? A[aStart] : B[bStart];
		
		int aMid = (aLen * k )/(aLen+bLen);
		int bMid = k-aMid-1;
		aMid = aMid+aStart;
		bMid = bMid+bStart;
		if(A[aMid]<B[bMid])
		{
			k = k-(aMid-aStart+1);
			aStart = aMid+1;
			bEnd = bMid;
		}
		else
		{
			k= k-(bMid-bStart+1);
			aEnd = aMid;
			bStart = bMid+1;
		}
		return findNow(A,B,k,aStart,aEnd,bStart,bEnd);
	}
	
	public static void main(String args[]) {
		MedianSortedArray m = new MedianSortedArray();
		int[] A = {900};
		int[] B = {5,8,10,20};
		System.out.println(m.median(A, B));
	}
}
