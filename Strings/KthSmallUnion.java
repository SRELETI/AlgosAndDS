import java.util.Arrays;


public class KthSmallUnion {

	public int findNow(int[] arr1, int m, int[] arr2, int n, int k) {
	//	System.out.println(1);
		int i = (int) ((double)(m/(m+n)*(k-1)));
		int j = (k-1)-i;
		
		int Ai_1 = (i==0)? Integer.MIN_VALUE:arr1[i-1];
		int Bj_1 = (j==0)? Integer.MIN_VALUE:arr2[j-1];
		int Ai   = (i==m)? Integer.MAX_VALUE:arr1[i];
		int Bj   = (j==n)? Integer.MAX_VALUE:arr2[j];
		
		if(Bj_1 < Ai && Ai < Bj) 
			return Ai;
		else if(Ai_1 < Bj && Bj<Ai) 
			return Bj;
		else 
		{
			if(Ai<Bj) {
				int[] newArr = Arrays.copyOfRange(arr1, i+1, m);
				int[] newArr2 = Arrays.copyOfRange(arr2, 0, j);
				return findNow(newArr,m-(i+1),newArr2,j,k-(i+1));
			}
			else
			{
				int[] newArr3 = Arrays.copyOfRange(arr1, 0, i);
				int[] newArr4 = Arrays.copyOfRange(arr2, j+1, n);
				return findNow(newArr3,i,newArr4,n-(j+1),k-(j+1));
			}
		}
	}
	
	public static void main(String args[]) {
		KthSmallUnion k = new KthSmallUnion();
		int[] arr2 = {1,3,5,7};
		int[] arr1 = {2,4,6,8};
		System.out.println(k.findNow(arr1, arr1.length, arr2, arr2.length, 5));
	}
}
