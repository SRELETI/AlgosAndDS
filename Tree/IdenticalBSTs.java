
public class IdenticalBSTs {

	public boolean check(int[] arr, int[] arr2) {
		if(arr.length!=arr2.length)
			return false;
		int n = arr.length;
		return checkUtils(arr,arr2,n,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	
	public boolean checkUtils(int[] arr1, int[] arr2, int n, int i, int j, int max, int min) {
		int ii,jj;
		for(ii = i;ii<n;ii++) {
			if(min<arr1[ii] && arr1[ii]<max) 
				break;
		}
		for(jj=j;jj<n;jj++) {
			if(min<arr2[jj] && arr2[jj]<max) 
				break;
		}
		
		if(ii==n && jj==n)
			return true;
		if((ii==n || jj==n) || arr1[ii]!=arr2[jj])
			return false;
		return checkUtils(arr1,arr2,n,ii+1,jj+1,max,arr1[ii]) && checkUtils(arr1,arr2,n,ii+1,jj+1,arr1[ii],min);
	}
	
	
	public static void main(String args[]) {
		IdenticalBSTs i = new IdenticalBSTs();
		int[] arr1 = {2,1,3};
		int[] arr2 = {2,4,3,1};
		boolean result = i.check(arr1, arr2);
		System.out.println(result);
	}
}
