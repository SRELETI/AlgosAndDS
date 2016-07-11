
public class PermutationSeq {

	private String permute(int n, int k) {
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact = fact*i;
			arr[i-1] = i;
		}
		for(int i=0;i<n && n>1;i++) {
			fact = fact/n-i;
			int index = (k-1)/fact;
			sb.append(arr[index]);
			while(index<n-1){
				arr[index++] = arr[index];
			}
			n--;
			k = ((k-1)%fact)+1;
		}
		if(n==1)
			sb.append(arr[0]);
		return sb.toString();
	}
	
	public static void main(String args[]) {
		PermutationSeq p = new PermutationSeq();
		System.out.println(p.permute(4, 3));
	}
}
