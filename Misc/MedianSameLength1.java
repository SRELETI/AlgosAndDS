
public class MedianSameLength1 {

	public int median(int[] arr1, int[] arr2) {
		if(arr1.length==0)
			return 0;
		int m1=0;
		int m2=0;
		int n=arr1.length;
		int k=0;
		int l=0;
		for(int i=0;i<=n;i++)
		{
			if(k==n)
			{
				m1=m2;
				m2 = arr2[0];
				break;
			}
			if(l==n)
			{
				m1=m2;
				m2= arr1[0];
				break;
			}
			if(arr1[k]<=arr2[l])
			{
				m1 = m2;
				m2 = arr1[k];
				k++;
			}
			else 
			{
				m1 = m2;
				m2 = arr2[l];
				l++;
			}
			
		}
		return (m1+m2)/2;
	}
	
	
}
